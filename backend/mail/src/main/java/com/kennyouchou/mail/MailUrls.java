package com.kennyouchou.mail;

/**
 * <p>
 * 邮件请求地址
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-30 21:22:22
 */
public class MailUrls {

    /**
     * 邮件模块跟请求路径
     * @since 2022/10/30 13:56
     **/
    public final static String PACKAGE_URL = "/mail";

    /**
     * 社区-期 地址控制
     * @author kennyouchou
     * @since 2022/10/30 13:59
     **/
    public static class MessageCtrls{
        public static final String BASE_URL =  PACKAGE_URL + "/message";
        public static final String SENDER_SIMPLE_MAIL =   "/sendSimpleMessage";
        public static final String FIND_MESSAGE =   "/findMessage";
        public static final String READ_MESSAGE =   "/readMessage";
    }
}
