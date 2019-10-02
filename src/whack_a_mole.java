
//339,292
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.ExecutorService;

public class whack_a_mole
{
    static ExecutorService executorService;// 线程池
    public static String[][] getloc(int x,int y)
    {
        String [][]result=new  String[6][10];
        for (int i = 0 ; i <3  ; i++)
        {
            for (int j = 0 ; j <3  ; j++)
            {
                result[i][j]=(x+j*115)+","+(y+i*99);       //115，99
                //	System.out.println ((x+j*27)+","+(y+i*22));
            }
        }
        return result;
    }
    public static void fun1()
    {
        //初始化robot
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        //Color pixel = robot.getPixelColor(630, 458);
        //System.out.println (pixel);
        //java.awt.Color[r=102,g=102,b=102]
        //java.awt.Color[r=222,g=222,b=222]
        String [][]todo=getloc (340,291);
        for (int k = 0 ; k <300  ; k++)
        {
            for (int i = 0 ; i <3  ; i++)
            {

                for (int j = 0 ; j <3  ; j++)
                {
                    String[]temp=todo[i][j].split (",");

                    if(robot.getPixelColor(Integer.parseInt (temp[0]),Integer.parseInt (temp[1])).getBlue ()==101)
                    {
                        for (int l = 0; l <3 ; l++) {
                            robot.mouseMove(Integer.parseInt (temp[0]),Integer.parseInt (temp[1]));
                        }


                        for (int l = 0; l <3; l++) {
                            //模拟鼠标按下左键
                            robot.mousePress(InputEvent.BUTTON1_MASK);
                            //模拟鼠标松开左键

                            robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        }

				/*	flag=0;
					break;*/
                    }
                }

            }
        }
    }


    public static void main (String[] args)
    {
        fun1 ();


    }
}
