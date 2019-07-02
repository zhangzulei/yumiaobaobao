package com.yumiaobaobao.app.common.utils;


/**
 * Created by WH on 2019/04/11.
 */
public class NotesScore {

    /**
     * 判断是否为有效便签
     * @return
     */
    public boolean isEffective(int imgNumber,String textLength,Boolean isSensitive){
        if(imgNumber<3){
            return false;
        }
        if(textLength.length()<200){
            return false;
        }
        if(isSensitive==false){
            return false;
        }
        return false;
    }
}
