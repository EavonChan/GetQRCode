import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author Eavon Chan
 * @date 2019/12/27 - 14:39
 */

public class GetQRCode {
        public static void getURCodePiture() {
            int width=600;
            int height=600;
            //格式
            String typeString ="png";
            // 扫描二维码内容
            String contextString="https://github.com/EavonChan/";
            //二维码配置
            HashMap hints= new HashMap(3);
            //字符集
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //容错等级
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            //二维码边距
            hints.put(EncodeHintType.MARGIN,2);
            try {
                //二维码对象，传入各种属性
                BitMatrix bitMatrix= new MultiFormatWriter()
                        .encode(contextString, BarcodeFormat.QR_CODE,width,height,hints);
                //路径
                Path file= new File("src\\main\\resources\\picture\\code.png").toPath();
                MatrixToImageWriter.writeToPath(bitMatrix,typeString,file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
       getURCodePiture();
    }

}
