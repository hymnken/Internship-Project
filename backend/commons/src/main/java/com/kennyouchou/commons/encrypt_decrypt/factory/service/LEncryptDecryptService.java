package com.kennyouchou.commons.encrypt_decrypt.factory.service;

/**
 * <p>
 * RSA加密解密服务
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-10 13:20:32
 */
public interface LEncryptDecryptService {

    /**
     * 加密
     * @param content 被加密字符串
     * @return java.lang.String 加密后字符串
     * @author kennyouchou
     * @since 2022/10/10 13:24
     **/
    String encrypt(String content);

    /**
     * 解密
     * @param content 加密的字符串
     * @return java.lang.String 原字符串
     * @author kennyouchou
     * @since 2022/10/10 13:25
     **/
    String decrypt(String content);
}
