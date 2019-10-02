package Test;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SpitTest {
/*
    public static void mouseClicked(MouseEvent e) {

        if (e.getButton() == e.BUTTON1) {//点击鼠标左键
            int x = e.getX();
            int y = e.getY();
            String str = "您点击的是左键，鼠标当前点击位置的坐标是(" + x + "," + y + ")";
            //label.setText(str);
        }
    }*/
    /*public static void mousePressed(MouseEvent e) {//鼠标按键被按下时被触发
        // TODO Auto-generated method stub
        System.out.print("鼠标按键被按下，");
        int i = e.getButton(); // 通过该值可以判断按下的是哪个键
        if(i == MouseEvent.BUTTON1) {
            System.out.print("按下了鼠标左键");
        }}*/
    /*public static void mouseClicked(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.BUTTON1) {
// 左键点击
        } else if(arg0.getButton() == MouseEvent.BUTTON2) {
// 中键点击
        } else if(arg0.getButton() == MouseEvent.BUTTON3) {
// 右键点击
        }
    }*/

    public static void main(String[] args) {
       PointerInfo pinfo = MouseInfo.getPointerInfo();
        Point p = pinfo.getLocation();
        double mx = p.getX();
        double my = p.getY();
        System.out.println(mx+ ","+my);
      /*  MouseEvent a = new MouseEvent();
        mouseClicked(a);*/



    }
}

