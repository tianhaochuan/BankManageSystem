import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.MouseInfo;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import javax.swing.*;

public class bot1{

    private Dimension dim; //存储屏幕尺寸
    private Robot robot;//自动化对象

    public bot1(){
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("屏幕大小为：" + dim.getWidth() + " " + dim.getHeight());
        try{
            robot = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }

    public void Move(int width,int heigh){    //鼠标移动函数
        System.out.println("enter Move()...");
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();
        System.out.println("移动前坐标：" + mousepoint.x + " " + mousepoint.y);
        width += mousepoint.x;
        heigh += mousepoint.y;
        try{
            robot.delay(100);
            robot.mouseMove(width,heigh);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("移动后坐标：" + width + " " + heigh);
        //robot.mousePress(InputEvent.BUTTON1_MASK);//鼠标单击
    }


    public static void main(String args[])throws Exception{
        bot1 mmc = new bot1();
        System.out.println("mouse control start:");
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int j = 0; j <300 ; j++) {
            for (int i = 0; i <10 ; i++) {
                robot.mouseMove(300,300);
            }
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);

            mmc.Move(20,20);//坐标为相对坐标
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            System.out.println("=======第二次移动=======");
            mmc.Move(20,20);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }


        System.out.println("mouse control stop.");

    }
}