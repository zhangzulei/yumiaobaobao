package com.yumiaobaobao.app.common.dto;

public class AliyunMessage {

    private static String usreAddMesaage;

    private static String userLoginMessage;

    private static String loginAbnormalMessage;

    private static String userInfoUpdateMessage;

    private static String AuthenticationMessage;

    public static String getUsreAddMesaage() {
        return usreAddMesaage;
    }

    public static String getUserLoginMessage() {
        return userLoginMessage;
    }

    public static String getLoginAbnormalMessage() {
        return loginAbnormalMessage;
    }

    public static String getUserInfoUpdateMessage() {
        return userInfoUpdateMessage;
    }

    public static String getAuthenticationMessage() {
        return AuthenticationMessage;
    }

    public static String MessageType(int MessageType, String code) {
        switch (MessageType) {
            case 1:
                return usreAddMesaage=code;
            case 2:
                return userLoginMessage=code;
            case 3:
                return loginAbnormalMessage=code;
            case 5:
                return userInfoUpdateMessage=code;
            case 6:
                return AuthenticationMessage=code;
            default:
                return "";
        }
    }
}
