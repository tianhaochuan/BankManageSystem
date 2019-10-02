package Test;

import java.awt.AWTException;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ice
 */
public class ColorTest2 extends Thread {
    private static Robot robot = null;
    /**/
    private static int x = 200;
    public static int y = 485;

    private ColorTest2() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        Color color;
        while (x < 350) {
            color = this.pickColor();
            System.out.println("color = " + color);
            if (color.getBlue() == 0) {
                System.out.println("click");
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        }
    }

    public static void main(String[] args) {
        new ColorTest2().start();
    }

    // 取得当前鼠标所在位置的颜色
    public Color pickColor() {
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
        Color pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
        // robot.mouseMove(x += 1, y);
        x = mousepoint.x;
        return pixel;
    }
}
