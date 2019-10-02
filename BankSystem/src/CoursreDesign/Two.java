package CoursreDesign;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Two {
    //设置树结点
    public static class node {
        String name;
        int num;
        int Chinese_grade;
        int Englishi_grade;
        int data_grade;
        String sex;
        node left;
        node right;
    }

    //设置开始根结点为null
    node root = null;

    //添加结点（添加数据）
    public static node add(node r, String n, int nu, int c, int e, int d, String sex) {
        if (r == null) {
            r = new node();
            r.Chinese_grade = c;
            r.data_grade = d;
            r.Englishi_grade = e;
            r.name = n;
            r.num = nu;
            r.left = null;
            r.right = null;
            r.sex = sex;
        } else {
            //如果有根结点，则在根结点下插入孩子结点
            //如果插入的学号比根结点的学号小，则放在左孩子结点
            if (nu < r.num) {
                r.left = add(r.left, n, nu, c, e, d, sex);
            }
            //如果插入的学号比根结点的学号大，则放在右孩子结点
            else if (nu > r.num) {
                r.right = add(r.right, n, nu, c, e, d, sex);
            } else if (nu == r.num) {
                System.out.println("插入失败");
            }
        }
        return r;
    }

    /**
     * 先序遍历树
     */
    public static void DLR(node n) {
        if (n != null) {
            show(n);
            DLR(n.left);
            DLR(n.right);
        }
    }

    /**
     * 中序遍历树
     */
    public static void LDR(node n) {
        if (n != null) {
            LDR(n.left);
            show(n);
            LDR(n.right);
        }
    }

    public static node FindMin(node s) {
        if (s == null) { //空的二叉树，返回NULL
            return null;
        } else {
            if (s.left == null)
                return s; //找到最左叶的结点并返回
            else {
                return FindMin(s.left); //沿着左分支继续查找
            }
        }
    }

    /**
     * 打印节点数据，显示学生信息
     */
    private static void show(node n) {
        System.out.println("_____________________________________________________________________________________________");
        System.out.print("学生姓名" + n.name + "\n");
        System.out.print("学生学号" + n.num + "\n");
        System.out.print("学生性别" + n.sex + "\n");
        System.out.print("中文成绩" + n.Chinese_grade + "\n");
        System.out.print("英语成绩" + n.Englishi_grade + "\n");
        System.out.print("数据结构成绩" + n.data_grade + "\n");
    }

    //实现查找功能
    //根据学号
    public static void find_by_num(node t, int num) {
        if (t != null) {
            if (num == t.num) {
                show(t);
            }
            if (num < t.num) {
                find_by_num(t.left, num);
            }
            if (num > t.num) {
                find_by_num(t.right, num);
            }
        } else {
            System.out.println("请插入数据");
        }

    }

    //2.根据姓名查找（可以找到相同名字的人的成绩）
    public static void find_by_name(node t, String name) {
        if (t != null) {
            find_by_name(t.left, name);
            if (name.equals(t.name)) {
                show(t);
            }
            find_by_name(t.right, name);
        }
    }

    //3.根据性别查找
    public static void find_by_sex(node t, String sex) {
        if (t != null) {
            find_by_sex(t.left, sex);
            if (sex.equals(t.sex)) {
                show(t);
            }
            find_by_sex(t.right, sex);
        }
    }

    public static void change_by_num(node t, int num) {
        if (t != null) {
            if (num == t.num) {
                change(t);
            }
            if (num < t.num) {
                change_by_num(t.left, num);
            }
            if (num > t.num) {
                change_by_num(t.right, num);
            }
        } else {
            System.out.println("请插入数据");
        }

    }

    public static void change(node t) {
        temp:
        while (true) {
            System.out.println("请选择想改变的内容：");
            System.out.println("（1:学生姓名 2.学生学号 3.学生性别 4.学生中文成绩 5.学生英语成绩 6.学生数据结构成绩 0.输出最新的学生信息 9.结束修改信息）");
            Scanner g = new Scanner(System.in);
            int h = g.nextInt();

            switch (h) {
                case 1: {
                    System.out.println("请输入新的学生姓名：");
                    String na = g.next();
                    t.name = na;
                    show(t);
                    break;

                }
                case 2: {
                    System.out.println("请输入新的学生学号：");
                    int no = g.nextInt();
                    t.num = no;
                    break;

                }
                case 3: {
                    System.out.println("请输入新的学生性别");
                    String se = g.next();
                    t.sex = se;
                    break;

                }
                case 4: {
                    System.out.println("请输入新的中文成绩：");
                    int c = g.nextInt();
                    t.Chinese_grade = c;
                    break;

                }
                case 5: {
                    System.out.println("请输入新的英语成绩：");
                    int e = g.nextInt();
                    t.Englishi_grade = e;
                    break;

                }
                case 6: {
                    System.out.println("请输入新的数据结构成绩");
                    int d = g.nextInt();
                    t.data_grade = d;
                    break;

                }
                case 0: {
                    show(t);
                    break;
                }
                case 9: {
                    break temp;
                }
            }
        }
    }

    //删除学生信息
    /*------------------------------删除操作----------------------------------------------*/
    public static void DeleteByNumber(node T, node PRT, int n) { //采用递归的方式进行遍历删除
        if (T != null) {
            DeleteByNumber(T.left, T, n);
            if (T.num == n) {
                if (T.left != null && T.right != null) { //同时拥有左子树和右子树
                    node student = FindMin(T.left);
                    T.num = student.num;
                    T.name = student.name;
                    T.Englishi_grade = student.Englishi_grade;
                    T.Chinese_grade = student.Chinese_grade;
                    T.sex = student.sex;
                    T.data_grade = student.data_grade;
                    DeleteByNumber(T.right, T, student.num);
                } else {
                    if (PRT == null) {
                        if (T.left != null) {
                            T = T.left;
                        } else {
                            T = T.right;
                        }
                    } else {
                        if (T == PRT.left) {
                            if (T.left != null) { //有右孩子结点无子结点
                                PRT.left = T.left;
                            } else {
                                PRT.left = T.right;
                            }
                        } else {
                            if (T.left != null) {
                                PRT.right = T.left;
                            } else {
                                PRT.right = T.right;
                            }
                        }
                    }
                }
            }
            DeleteByNumber(T.right, T, n);
        }
    }

    //建立txt文件存储学生信息
    public static void Store(String e) throws IOException {
        //创建文件
        File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
        writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
        FileOutputStream out = new FileOutputStream(writeName, true);
        out.write(e.getBytes());
    }

    //将信息写入txt文件
    public static void Store1(String name, int num, int Chinese_grade, int Englishi_grade, int data_grade, String sex) throws IOException {
        Store("姓名：" + name + "~~~" + "学号：" + num + "~~~" + "中文成绩：" + Chinese_grade + "~~~" + "英语成绩：" + Englishi_grade + "~~~" + "数据结构成绩：" + data_grade + "~~~" + "性别：" + sex + "\r\n");
    }

    //测试程序5
    public static void main(String[] args) throws IOException {
        node n = new node();
        node p = new node();
        add(n, "王", 10, 0, 0, 0, "女");
        add(n, "田浩川", 9, 10, 10, 10, "男");
        add(n, "hello", 12, 10, 10, 10, "女");
        Store1("王", 10, 0, 0, 0, "女");
        Store1("田浩川", 9, 10, 10, 10, "男");
        Store1("hello", 12, 10, 10, 10, "女");
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("欢迎使用长川学生信息管理系统");
            System.out.println("请选择您想要进行的业务");
            System.out.println("1.添加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.查询学生信息");
            System.out.println("5.显示所有学生信息");
            System.out.println("6.退出");
            System.out.println("----------------------------------------------------");
            int a = 0;

            Scanner z = new Scanner(System.in);
            a = z.nextInt();
            one:
            switch (a) {
                case 1: {
                    System.out.println("请输入你想输入学生的人数：");
                    Scanner s = new Scanner(System.in);
                    int RenShu = s.nextInt();
                    for (int i = 0; i < RenShu; i++) {
                        System.out.println("请输入第" + (i + 1) + "个学生的姓名");
                        String name = s.next();
                        System.out.println("请输入第" + (i + 1) + "个学生的学号");
                        int num = s.nextInt();
                        System.out.println("请输入第" + (i + 1) + "个学生的中文成绩");
                        int chinese = s.nextInt();
                        System.out.println("请输入第" + (i + 1) + "个学生的英语成绩");
                        int english = s.nextInt();
                        System.out.println("请输入第" + (i + 1) + "个学生的数据结构成绩");
                        int data = s.nextInt();
                        System.out.println("请输入第" + (i + 1) + "个学生的性别");
                        String sex = s.next();
                        n = add(n, name, num, chinese, english, data, sex);
                        Store1(name, num, chinese, english, data, sex);
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入你想修改的学生的学号");
                    Scanner s = new Scanner(System.in);
                    int x = s.nextInt();
                    change_by_num(n, x);
                    break;
                }
                case 3: {
                    System.out.println("请输入你想删除的学生的学号");
                    Scanner e = new Scanner(System.in);
                    int x = e.nextInt();
                    DeleteByNumber(n, p, x);
                    break;
                }
                case 4: {
                    System.out.println("请选择查询方式：");
                    System.out.println("1.学号查询");
                    System.out.println("2.姓名查询");
                    System.out.println("3.性别查询");
                    Scanner y = new Scanner(System.in);
                    int k = y.nextInt();

                    switch (k) {
                        case 1: {
                            System.out.println("请输入学生的学号：");
                            int s = y.nextInt();
                            find_by_num(n, s);
                            break;
                        }
                        case 2: {
                            System.out.println("请输入学生的姓名：");
                            String h = y.next();
                            find_by_name(n, h);
                            break;
                        }
                        case 3: {
                            System.out.println("请输入学生的性别：");
                            String j = y.next();
                            find_by_sex(n, j);
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("中序遍历所有学生信息");
                    LDR(n);
                    break;
                }
                case 6: {
                    System.out.println("系统已退出，感谢您的使用");
                    break one;
                }
            }
        }

    }
}
