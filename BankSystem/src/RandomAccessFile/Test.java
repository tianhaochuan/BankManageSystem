package RandomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Test {
    int id;
    String name;
    String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Test() {

    }

    public Test(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public void Write(RandomAccessFile r) throws IOException {
        r.writeInt(id);
        r.writeUTF(name);
        r.writeUTF(sex);
       // r.writeUTF("\r\n");
    }

    public void Read(RandomAccessFile r) throws IOException {
        this.id = r.readInt();
        this.name = r.readUTF();
        this.sex = r.readUTF();

    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile r = new RandomAccessFile("d:/Student.txt", "rw");
      /*  System.out.println("请输入学生人数");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入学生学号");
            int id = s.nextInt();
            System.out.println("请输入学生姓名");
            String name = s.next();
            System.out.println("请输入学生性别");
            String sex = s.next();
            Test p = new Test(id, name, sex);
            p.Write(r);
          //  r.writeBytes("\r\n");
        }*/
        r.seek(0);
        /*for (int i = 0; i <n ; i++) {
            Test p2 = new Test();
            p2.Read(r);
            System.out.println("id=" + p2.getId() + ";name=" + p2.getName()
                    + ";sex=" + p2.getSex()+"\n");
        }*/
        byte[] buffer = new byte[4];
        int num = 0;
        while(-1 != (num = r.read(buffer)))
                  {
                       r.write(buffer,0,num);
               }
        }
    }






