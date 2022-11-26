package com.kennyouchou.commons.QrCodeFactory;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.kennyouchou.commons.config.SystemProperties;
import com.kennyouchou.commons.utils.ApplicationContextUtils;

/**
 * <p>
 * QrCode基类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-05 21:29:11
 */
public abstract class QrCodeBase {

    protected final SystemProperties systemProperties;

    public QrCodeBase() {
        systemProperties = ApplicationContextUtils.getBean(SystemProperties.class);
    }

    /**
     * 创建二维码
     * @param resultMap  二维码携带的信息
     * @return java.awt.image.BufferedImage
     * @author kennyouchou
     * @since 2022/10/24 19:52
     **/
    public abstract BufferedImage createQrCode(Map<String, Object> resultMap);
}
