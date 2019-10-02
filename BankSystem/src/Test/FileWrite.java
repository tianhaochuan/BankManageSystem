package Test;

import contentcl.UserMessage;

import java.io.*;
import java.util.Scanner;

public class FileWrite {
    public static void main(String[] args) throws IOException {
        //创建文件
        File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
        writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
        //修改文件
        while (true) {
            System.out.println("请输入您的信息：");
            Scanner s = new Scanner(System.in);
            String e = s.next();
            FileOutputStream out = new FileOutputStream(writeName, true);
            out.write(e.getBytes());
        }


    }

}


