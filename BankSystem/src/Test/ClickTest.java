package Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class ClickTest {
    public static void Click(int x, int y) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        //鼠标移动到某一点
        robot.mouseMove(x, y);
//模拟鼠标按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
//模拟鼠
// 标松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }


    public static void main(String[] args) {
        //初始化robot
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        int x[] = {251,278,305,332,359,386,413,440,467,494,521,548,575,602,629};
        int y[] = {271,293,315,337,359,381,403,425,447,469,491};
        for (int k= 0; k <500 ; k++) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 11; j++) {
                    robot.mouseMove(x[i],y[j]);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                }
            }
        }

    }
}

