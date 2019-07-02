package com.yumiaobaobao.app.common.utils.aliyunauthentication;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20180916.GetStatusRequest;
import com.aliyuncs.cloudauth.model.v20180916.GetStatusResponse;
import com.aliyuncs.cloudauth.model.v20180916.SubmitVerificationRequest;
import com.aliyuncs.cloudauth.model.v20180916.SubmitVerificationResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.yumiaobaobao.app.common.dto.AliyunAuthenticationParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2019/04/12.
 * aliyun 实人认证  RPMin认证方案
 */
public class AliyunAuthenticationUtil {

   private AliyunAuthenticationUtil(){}

    public static String AliyunAuthentication(
            String IdentificationNumber,
            String Name,
            String FacePic,
            String IdCardFrontPic,
            String IdCardBackPic,
            String UUId
            ){
        DefaultProfile profile = DefaultProfile.getProfile(
                AliyunAuthenticationParameter.REGIONID,
                AliyunAuthenticationParameter.ACCESSKEYID,
                AliyunAuthenticationParameter.SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        String biz = AliyunAuthenticationParameter.BIZ;
        String ticketId = UUId;


        SubmitVerificationRequest submitRequest = new SubmitVerificationRequest();
        submitRequest.setBiz(biz);
        submitRequest.setTicketId(ticketId);

        List<SubmitVerificationRequest.Material> materialList = new ArrayList<SubmitVerificationRequest.Material>();

        SubmitVerificationRequest.Material material1 = new SubmitVerificationRequest.Material();
        material1.setMaterialType("IdentificationNumber");
        material1.setValue(IdentificationNumber);
        materialList.add(material1);

        SubmitVerificationRequest.Material material2 = new SubmitVerificationRequest.Material();
        material2.setMaterialType("Name");
        material2.setValue(Name);
        materialList.add(material2);

        SubmitVerificationRequest.Material material3 = new SubmitVerificationRequest.Material();
        material3.setMaterialType("FacePic");
        material3.setValue(FacePic);
        materialList.add(material3);

        SubmitVerificationRequest.Material material4 = new SubmitVerificationRequest.Material();
        material4.setMaterialType("IdCardFrontPic");
        material4.setValue(IdCardFrontPic);
        materialList.add(material4);

        SubmitVerificationRequest.Material material5 = new SubmitVerificationRequest.Material();
        material5.setMaterialType("IdCardBackPic");
        material5.setValue(IdCardBackPic);
        materialList.add(material5);
        submitRequest.setMaterials(materialList);
        try {
            SubmitVerificationResponse response = client.getAcsResponse(submitRequest);
            return JSON.toJSONString(response);

        } catch (ServerException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ClientException e) {
            return "{\"Message\":\""+e.getErrMsg()+"\"}";
        }
    }


    public static String GetStatus(String TicketId,String Biz){
        DefaultProfile profile = DefaultProfile.getProfile(AliyunAuthenticationParameter.REGIONID, AliyunAuthenticationParameter.ACCESSKEYID, AliyunAuthenticationParameter.SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        GetStatusRequest request = new GetStatusRequest();
        request.setTicketId(TicketId);
        request.setBiz(Biz);

        try {
            GetStatusResponse response = client.getAcsResponse(request);
            return new Gson().toJson(response);
        } catch (ServerException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ClientException e) {
            return "{\"Message\":\""+e.getErrMsg()+"\"}";
        }
    }
}
