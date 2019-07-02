package com.yumiaobaobao.app.common.utils.aliyunmessage;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;


/***
 * @author wangheng 2019 3 16
 *
 * 阿里云短信验证码工具类
 */
public class AliyunCode {

    public static String sendMessage(
            String regionId,
            String accessKeyId,
            String secret,
            String PhoneNumbers,
            String SignName,
            String TemplateCode,
            Object TemplateParam,
            String code
    ){
    DefaultProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,secret);
    IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", SignName);
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putQueryParameter("TemplateParam", TemplateParam.toString());
        StringBuffer  MessageCode= new StringBuffer();
        int result = 0;
        try {
            CommonResponse response = client.getCommonResponse(request);
            result=response.getData().lastIndexOf("OK");
            MessageCode.append(response.getData()).replace(result,result+2,code);
            System.out.println(MessageCode);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return MessageCode.toString();
    }
}
