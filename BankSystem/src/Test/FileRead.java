package Test;

import java.io.*;


public class FileRead {
    public static void main(String[] args) throws IOException {

        //创建文件
        File file = new File("田浩川.txt");
        if (file.exists() || file.isDirectory()) ;
        file.createNewFile();

        //读取文件
        FileReader f = new FileReader("田浩川.txt");
      BufferedReader b = new BufferedReader(f);

        //显示文件内容
        String line = null;
        while((line=b.readLine())!=null)
        {
            System.out.println(line);
        }

    }
}
