package com.kennyouchou.commons.QrCodeFactory;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.kennyouchou.commons.enums.QrCodeColorEnum;

/**
 * <p>
 * 二维码工厂类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-05 21:41:17
 */
public class QrCodeFactory {

    /**
     * 构建二维码
     * @param qrCodeColorEnum 二维码类型
     * @param resultMap  携带参数
     * @return java.awt.image.BufferedImage
     * @author kennyouchou
     * @since 2022/10/5 21:54
     **/
    public static BufferedImage getQrCode(QrCodeColorEnum qrCodeColorEnum, Map<String, Object> resultMap){
        QrCodeBase qrCodeBase = null;
        if (qrCodeColorEnum.getValue().equals(QrCodeColorEnum.GREEN.getValue())){
            qrCodeBase = new GreenQrCode();
        }else if (qrCodeColorEnum.getValue().equals(QrCodeColorEnum.RED.getValue())){
            qrCodeBase = new RedQrCode();
        }else if (qrCodeColorEnum.getValue().equals(QrCodeColorEnum.YELLOW.getValue())){
            qrCodeBase = new YellowQrCode();
        }else if (qrCodeColorEnum.getValue().equals(QrCodeColorEnum.GRAY.getValue())){
            qrCodeBase = new GrayQrCode();
        }
        return qrCodeBase.createQrCode(resultMap);
    }

}
