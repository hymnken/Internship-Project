package com.kennyouchou.commons.encrypt_decrypt.factory.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import org.springframework.stereotype.Component;

import com.kennyouchou.commons.config.EncryptDencryptProperties;
import com.kennyouchou.commons.encrypt_decrypt.factory.service.LEncryptDecryptService;

import javax.annotation.Resource;

/**
 * <p>
 *  AES加密解密
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-30 13:34:23
 */
@Component("AES")
public class AESEncryptDecryptServiceImpl implements LEncryptDecryptService {

    @Resource
    private EncryptDencryptProperties.AesKey aesKey;



    /**
     * 加密
     * @param content 被加密字符串
     * @return java.lang.String 加密后字符串
     * @author kennyouchou
     * @since 2022/10/10 13:24
     **/
    @Override
    public String encrypt(String content) {
        SymmetricCrypto symmetriccrypto = new SymmetricCrypto(SymmetricAlgorithm.AES.getValue(), Base64.decode(aesKey.getKey()));
        return symmetriccrypto.encryptHex(content);
    }

    /**
     * 解密
     * @param content 加密的字符串
     * @return java.lang.String 原字符串
     * @author kennyouchou
     * @since 2022/10/10 13:25
     **/
    @Override
    public String decrypt(String content) {
        SymmetricCrypto symmetriccrypto = new SymmetricCrypto(SymmetricAlgorithm.AES.getValue(), Base64.decode(aesKey.getKey()));
        return symmetriccrypto.decryptStr(content);
    }
}
