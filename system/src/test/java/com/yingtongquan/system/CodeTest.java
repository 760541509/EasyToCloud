package com.yingtongquan.system;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.BufferedImageLuminanceSource;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class CodeTest {

    private static final String CHARSET = "utf-8";

    public static void main(String[] args) {
        QrConfig qrConfig = QrConfig.create().setImg("D:/timg.jpg");
//            String content = "https://ytq.oss-cn-beijing.aliyuncs.com/shop_app/qrcode?shopId=10036";
        String content = "www.baidu.com";

        Map<String, Object> map = new HashMap<>();
        map.put("url", "www.baidu.com");
        map.put("A", "A");

        File file1 = FileUtil.file("D:/code/LuckyDraw" + 2 + ".jpg");
        test(content, qrConfig, file1);

        File file = FileUtil.file("D:/code/wx_shop_10080.png");

        try {
            String decode = decode(file);
            System.out.println(decode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test(String content, QrConfig config, File targetFile) {
        QrCodeUtil.generate(content, config, targetFile);
    }

    public static String decode(File file) throws Exception {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }




}

