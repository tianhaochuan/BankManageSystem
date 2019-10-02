package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class write
{


    /**
     *构造函数第二个参数为真，意味着追加内容到末尾
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //建立文件对象
        File file=new File("output.txt");
        while (true) {
            System.out.println("请输入您的信息：");
            Scanner s = new Scanner(System.in);
            String e = s.next();
            FileOutputStream out = new FileOutputStream(file, true);
            out.write(e.getBytes());
        }
    }

}
