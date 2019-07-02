package com.yumiaobaobao.app.common.dto;


/**
 * Created by WH on 2019/04/09.
 */
public class AliyunMessageParameter {

    private AliyunMessageParameter(){}

    public static final String REGIONID="cn-hangzhou";
    public static final String ACCESSKEYID="LTAIwNmIdgydqxsD";
    public static final String SECRET="oIRMaFSbVyaGsW5ylQgb3uHbHyY26e";
    public static final String SIGNNAME="芋苗宝宝";

    public static String getTemplateCode(int typenume){
        switch(typenume) {
            case 1:
                return "SMS_162461130";
            case 2:
                return "SMS_162461132";
            case 3:
                return "SMS_162461131";
            case 5:
                return "SMS_162461128";
            case 6:
                return "SMS_162461133";
            default:
                return "类型参数错误 无法匹配";
        }
    }
}
