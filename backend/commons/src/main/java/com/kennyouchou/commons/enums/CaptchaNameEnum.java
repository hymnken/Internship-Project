package com.kennyouchou.commons.enums;

/**
 * <p>
 * shiro 缓存枚举
 * </p>
 *
 * @author kennyouchou
 * @date 2022-10-31 09:59:24
 */
public enum CaptchaNameEnum {

    /**
     * 登录验证码
     * @since 2022/10/31 10:08
     **/
    LOGIN_CAPTCHA(":login_captcha"),

    ;


    private final String value;

    CaptchaNameEnum(String value){
        this.value = value;
    }

    public static String isSuccessEnum(String value){
        CaptchaNameEnum[] array = values();
        for(CaptchaNameEnum arr: array){
            if(arr.value.equals(value)){
                return arr.value;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
