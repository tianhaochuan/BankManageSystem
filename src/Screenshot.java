import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class Screenshot {

    public static void captureScreen(int x,int y,int z,int h,String j) throws Exception {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        // 截图保存的路径
        File screenFile = new File("d:\\"+j+".png");
        // 如果文件夹路径不存在，则创建
        if (!screenFile.getParentFile().exists()) {
            screenFile.getParentFile().mkdirs();
        }
        // 指定屏幕区域，参数为截图左上角坐标(100,100)+右下角坐标(500,500)
        BufferedImage subimage = image.getSubimage(x,y,z,h);
        ImageIO.write(subimage, "png", screenFile);

    }
    public static double getSimilarity(File imageFile1, File file2) throws IOException {
        int[] pixels1 = getImgFinger(imageFile1);
        int[] pixels2 = getImgFinger(file2);
// 获取两个图的汉明距离（假设另一个图也已经按上面步骤得到灰度比较数组）
        int hammingDistance = getHammingDistance(pixels1, pixels2);
// 通过汉明距离计算相似度，取值范围 [0.0, 1.0]
        double similarity = calSimilarity(hammingDistance)*100;
        System.out.println("相似度:"+similarity+"%");
        return similarity;
    }

    private static int[] getImgFinger(File imageFile) throws IOException {
        Image image = ImageIO.read(imageFile);
// 转换至灰度
        image = toGrayscale(image);
// 缩小成32x32的缩略图
        image = scale(image);
// 获取灰度像素数组
        int[] pixels1 = getPixels(image);
// 获取平均灰度颜色
        int averageColor = getAverageOfPixelArray(pixels1);
// 获取灰度像素的比较数组（即图像指纹序列）
        pixels1 = getPixelDeviateWeightsArray(pixels1, averageColor);
        return pixels1;
    }

    // 将任意Image类型图像转换为BufferedImage类型，方便后续操作
    public static BufferedImage convertToBufferedFrom(Image srcImage) {
        BufferedImage bufferedImage = new BufferedImage(srcImage.getWidth(null),
                srcImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(srcImage, null, null);
        g.dispose();
        return bufferedImage;
    }

    // 转换至灰度图
    public static BufferedImage toGrayscale(Image image) {
        BufferedImage sourceBuffered = convertToBufferedFrom(image);
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        BufferedImage grayBuffered = op.filter(sourceBuffered, null);
        return grayBuffered;
    }

    // 缩放至32x32像素缩略图
    public static Image scale(Image image) {
        image = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        return image;
    }

    // 获取像素数组
    public static int[] getPixels(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int[] pixels = convertToBufferedFrom(image).getRGB(0, 0, width, height,
                null, 0, width);
        return pixels;
    }

    // 获取灰度图的平均像素颜色值
    public static int getAverageOfPixelArray(int[] pixels) {
        Color color;
        long sumRed = 0;
        for (int i = 0; i < pixels.length; i++) {
            color = new Color(pixels[i], true);
            sumRed += color.getRed();
        }
        int averageRed = (int) (sumRed / pixels.length);
        return averageRed;
    }

    // 获取灰度图的像素比较数组（平均值的离差）
    public static int[] getPixelDeviateWeightsArray(int[] pixels,final int averageColor) {
        Color color;
        int[] dest = new int[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            color = new Color(pixels[i], true);
            dest[i] = color.getRed() - averageColor > 0 ? 1 : 0;
        }
        return dest;
    }

    // 获取两个缩略图的平均像素比较数组的汉明距离（距离越大差异越大）
    public static int getHammingDistance(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] == b[i] ? 0 : 1;
        }
        return sum;
    }

    // 通过汉明距离计算相似度
    public static double calSimilarity(int hammingDistance){
        int length = 32*32;
        double similarity = (length - hammingDistance) / (double) length;

// 使用指数曲线调整相似度结果
        similarity = java.lang.Math.pow(similarity, 2);
        return similarity;
    }

public static String[][] location(int x,int y){
        String[][] c = new String[3][3];
    for (int i = 0; i <3 ; i++) {
        for (int j = 0; j <3 ; j++) {
            c[i][j] = (x+j*241)+","+(y+i*207);
            System.out.println(c[i][j]);
        }
        
    }
      return  c;
}
    public static void main(String[] args) throws Exception {
       /* captureScreen(1260,720,56,30,"one");
        File imageFile1 = new File("d:\\tummy.png");
        File file2 = new File("d:\\tummy.png");
        getSimilarity(imageFile1, file2);
            captureScreen(766,346,56,30,"two");*/
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        File file2 = new File("d:\\tummy.png");



        captureScreen(766,346,56,30,"one");

        captureScreen(1007,346,56,30,"two");

        captureScreen(1248,346,56,30,"three");

        captureScreen(766,553,56,30,"four");

        captureScreen(1007,553,56,30,"five");

        captureScreen(1248,553,56,30,"six");

        captureScreen(766,760,56,30,"seven");

        captureScreen(1007,760,56,30,"eight");

        captureScreen(1248,760,56,30,"nine");






       /*String[][] todo = location(766,346);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                String[] temp = todo[i][j].split(",");
                captureScreen(Integer.parseInt (temp[0]),Integer.parseInt (temp[0]),56,30,"hello");
            }

        }*/

      }

    }
