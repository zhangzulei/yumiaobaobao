package com.yumiaobaobao.app.user.userlogin.phonelogin.controller;


import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yumiaobaobao.app.common.dto.AliyunMessage;
import com.yumiaobaobao.app.common.dto.AliyunMessageParameter;
import com.yumiaobaobao.app.common.utils.aliyunmessage.AliyunCode;
import com.yumiaobaobao.app.common.utils.util.DateUtils;
import com.yumiaobaobao.app.common.utils.util.RandomNumberUtil;
import com.yumiaobaobao.app.user.comment.service.Serviceindex_discover;
import com.yumiaobaobao.app.user.entity.UserInfo;
import com.yumiaobaobao.app.user.entity.index_discover;
import com.yumiaobaobao.app.user.scorechange.entity.scorechange;
import com.yumiaobaobao.app.user.scorechange.service.scorechangeService;
import com.yumiaobaobao.app.user.token.service.user_tokenService;
import com.yumiaobaobao.app.user.userlogin.phonelogin.service.PhoneLoginService;
import com.yumiaobaobao.app.user.usermember.service.user_level_infoService;
import com.yumiaobaobao.app.user.userupdate.service.UserUpdateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Component
@Api(tags = "手机登录 1.发送验证码 3.手机登录 4.注册")
public class PhoneLoginController {

    @Autowired
    private PhoneLoginService phoneloginservice;
    @Autowired
    private UserUpdateService userUpdateService;
    @Autowired
    private user_level_infoService user_level_info;
    @Autowired
    private Serviceindex_discover serviceindex_discover;
    @Autowired
    private user_tokenService user_tokenService;
    @Autowired
    private scorechangeService scorechangeService;

    private Object TemplateParam;

    private Map<String, Object> mapCode;


    @ApiOperation(value = "发送验证码", notes = "发送验证码 1用户注册验证码 2登录确认验证码 3登录异常验证码  5信息变更验证码 6身份验证验证码")
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public String sendMessage(@ApiParam(value = "手机号") @RequestParam("PhoneNumbers") String PhoneNumbers,
                              @ApiParam(value = "短信类型") @RequestParam("messagetype") int messagetype,
             HttpServletResponse response, HttpServletRequest request) {
        mapCode = new ConcurrentHashMap<>();
        String code = RandomNumberUtil.randomnumber();
        mapCode.put("code", AliyunMessage.MessageType(messagetype,code));
        TemplateParam = JSON.toJSONString(mapCode);
        return AliyunCode.sendMessage(AliyunMessageParameter.REGIONID, AliyunMessageParameter.ACCESSKEYID,
                AliyunMessageParameter.SECRET, PhoneNumbers, AliyunMessageParameter.SIGNNAME,
                AliyunMessageParameter.getTemplateCode(messagetype), TemplateParam,code);
    }

    @Transactional
    @ApiOperation(value = "登录", notes = "用户登录  Message  0=>验证码输入错误 -1=>用户未注册 自动调用注册接口 " +
            "-2=>写入登陆时间失败  Message => -3 没有数据  Message =>-4 更新积分失败 Message =>-5 更新会员失败")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(@ApiParam(value = "手机号") @RequestParam(value = "userphone") String userphone,
                        @ApiParam(value = "验证码") @RequestParam(value = "codephone",required = false) String Inputcodephone,
                        HttpServletRequest request) {
        UserInfo list = phoneloginservice.byUserPhoneToUserInfo(userphone); //查询该用户是否注册
//        System.out.println("测试时间"+list.getRegistrationtime());
        if (null == list) {
            return "{\"Message\": \"-1\"}";
        }
        Date dates = new Date();
        LocalDateTime last_login_time = null;
        //注册成功之后判断是否有user_level_info记录，没有就创建一条
        if(scorechangeService.selectByUserid(String.valueOf(list.getUserid()))==null||
                scorechangeService.selectByUserid(String.valueOf(list.getUserid())).size()<=0){
          /*  Map<String,Object> maps = new HashMap<String,Object>();
            maps.put("userid",list.getUserid());
            maps.put("score",5);
            maps.put("post","登录奖励");
            maps.put("getintegral",5);
            maps.put("logintime",DateUtils.newDateTime());
            maps.put("createtime",DateUtils.newDateTime());
            maps.put("notecreatetime",null);
            maps.put("noteContent",null);
            int i = scorechangeService.addScorechange(maps);
            if(i==0){
                return "{\"Message\": \"-4\"}";
            }*/
        }else{//有这条记录就判断今天是否登陆过
            UserInfo userInfo = userUpdateService.selectUserInfoByUserId(list.getUserid().toString());
            System.out.println("获取时间-----"+list.getLastLoginTime());
            if(userInfo==null){
                return  "{\"Message\":\"-3\"}";
            }
            last_login_time = userInfo.getLastLoginTime();
            dates = DateUtils.convertLDTToDate(last_login_time);
            SimpleDateFormat sdfLogin = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            String lastTime = sdfLogin.format(dates);
            String nowTime = sdfLogin.format(currentTime);
            if(!nowTime.equals(lastTime)){
                List<scorechange> scorechanges = scorechangeService.selectLastByUserid(String.valueOf(list.getUserid()));
                Map<String,Object> maps = new HashMap<String,Object>();
                maps.put("userid",list.getUserid());
                maps.put("score",scorechanges.get(0).getScore()+5);
                maps.put("post","登录奖励");
                maps.put("getintegral",5);
                maps.put("logintime",DateUtils.newDateTime());
                maps.put("createtime",DateUtils.newDateTime());
                maps.put("notecreatetime",null);
                maps.put("noteContent",null);
                int i = scorechangeService.addScorechange(maps);
                if(i==0){
                    return "{\"Message\":\"-4\"}";
                }
            }
            List<scorechange> byUserid = scorechangeService.selectLastByUserid(String.valueOf(list.getUserid()));
            Integer s = byUserid.get(0).getScore();
            if(s>=1000){
                int o = userUpdateService.updateVip(Integer.valueOf(list.getUserid()));
                if(o==0){
                    return "{\"Message\":\"-5\"}";
                }
            }
//            return "{\"Message\":\"1\"}";
        }

        //判断是否发布最新文章间隔时间超过一天，超过则减去35积分
        List<index_discover> index_discovers = serviceindex_discover.selectByUseridLast(list.getUserid());
        if(index_discovers==null||index_discovers.size()<=0){
            //没有发布过便签 积分默认为0
            int i = scorechangeService.updateScoreZero(String.valueOf(list.getUserid()));
            if(i==0){
//                    return "{\"Message\":\"-5\"}";
            }
        }else{
            Date createtime = index_discovers.get(0).getCreatetime();
            dates = DateUtils.convertLDTToDate(last_login_time);
            int days = (int) ((createtime.getTime() - dates.getTime()) / (1000*3600*24));
            if(days>=1){ //发便签时间超过一天
                List<scorechange> scorechanges = scorechangeService.selectLastByUserid(String.valueOf(list.getUserid()));
                Map<String,Object> maps = new HashMap<String,Object>();
                maps.put("userid",list.getUserid());
                maps.put("score",scorechanges.get(0).getScore()-35);
                maps.put("post","未发帖");
                maps.put("getintegral",35);
                maps.put("logintime",DateUtils.newDateTime());
                maps.put("createtime",DateUtils.newDateTime());
                maps.put("notecreatetime",null);
                maps.put("noteContent",null);
                int i = scorechangeService.addScorechange(maps);
                if(i==0){
                    return "{\"Message\":\"-4\"}";
                }
                List<scorechange> byUserids = scorechangeService.selectLastByUserid(String.valueOf(list.getUserid()));
                Integer score = byUserids.get(0).getScore();
                if(score<1000){
                    int i1 = userUpdateService.loseVip(list.getUserid());
                    if(i1==0){
                        return "{\"Message\":\"-5\"}";
                    }
                    if(score<0){
                        int i2 = scorechangeService.updateScoreZero(String.valueOf(list.getUserid()));
                        if(i2<=0){
                            return "{\"Message\":\"-4\"}";
                        }
                    }
                }
            }
        }
        //登陆成功之后添加一个最后登录时间
        Date time = new Date();
        LocalDateTime localDateTime = DateUtils.convertDateToLDT(time);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int j = userUpdateService.updateLoginTime(localDateTime, list.getUserid().toString());
        if(j==0){
            return "{\"Message\": \"-2\"}";
        }
//        //成功之后把userid添加到session中
//        HttpSession session = request.getSession();
//        session.setAttribute("userid",list.getUserid());
//        List<user_token> byUserId = user_tokenService.findByUserId(String.valueOf(list.getUserid()));
//        if(byUserId==null||byUserId.size()<=0){
//            return "{\"Message\": \"-3\"}";
//        }
//        list.setToken(byUserId.get(0).getToken());
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(list)+"}";
    }


    @Transactional
    @ApiOperation(value = "注册", notes = "注册  Message  0=>注册失败 1=>注册成功 -1=>用户已注册 -2=>系统异常  -3=>新增token失败" +
            "-2=>增加user_level_info失败  -4=>")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(
            @ApiParam(value = "用户起始选择的性别 如不是第一次安装可以不写") @RequestParam(value = "userGender",defaultValue = "-1") String userGender,
            @ApiParam(value = "手机号")                                      @RequestParam(value = "userphone") String userphone,
            @ApiParam(value = "用户起始选择的生日 如不是第一次安装可以不写") @RequestParam(value = "userbirthday",defaultValue="null") String userbirthday,
            HttpServletRequest request) {

        UserInfo list = phoneloginservice.byUserPhoneToUserInfo(userphone); //查询该用户是否注册
        if (null != list) {
            return "{\"Message\": \"-1\"}";
        }
        int result=phoneloginservice.addNewUser(userGender,userphone,userbirthday,RandomNumberUtil.randomnumberEnglish(8));
        if (result <= 0) {
            return "{\"Message\": \"0\"}";
        }
        UserInfo listinfo = phoneloginservice.byUserPhoneToUserInfo(userphone);
        if (null == listinfo) {
            return "{\"Message\": \"-2\"}";
        }

        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("userid",listinfo.getUserid());
        maps.put("score",5);
        maps.put("post","登录奖励");
        maps.put("getintegral",5);
        maps.put("logintime",DateUtils.newDateTime());
        maps.put("createtime",DateUtils.newDateTime());
        maps.put("notecreatetime",null);
        maps.put("noteContent",null);
        int i = scorechangeService.addScorechange(maps);
        if(i==0){
            return "{\"Message\": \"-4\"}";
        }

//        HttpSession session = request.getSession();
//        session.setAttribute("userid",list.getUserid());
        return "{\"Message\": \"1\", \"Data\":"+JSON.toJSONString(listinfo)+"}";
    }

    public String createToken(UserInfo user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getUserid()))
                .sign(Algorithm.HMAC256(user.getYumiaoAccount()));
        return token;
    }


    @ApiOperation(value = "登出", notes = "登出  Message  0=>验证码输入错误 ")
    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String LoginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();//获取当前session
        if(session!=null){
            String userid = (String)session.getAttribute("userid");//从当前session中获取用户信息
            session.invalidate();//关闭session
        }
        return "{\"Message\": \"1\"}";
    }

}