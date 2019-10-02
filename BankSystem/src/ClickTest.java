import java.awt.*;
import java.awt.event.InputEvent;

public class ClickTest {
    public static void Click(int x, int y){
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
//模拟鼠标松开左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void main(String[] args) {
        for (int i = 0; i <600 ; i++) {
            Click(331,446);
        }

    }
}
