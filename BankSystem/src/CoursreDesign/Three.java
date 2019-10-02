package CoursreDesign;

public class Three {
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
    private static void show(node n) {
        System.out.println("_____________________________________________________________________________________________");
        System.out.print("学生姓名" + n.name + "\n");
        System.out.print("学生学号" + n.num + "\n");
        System.out.print("学生性别" + n.sex + "\n");
        System.out.print("中文成绩" + n.Chinese_grade + "\n");
        System.out.print("英语成绩" + n.Englishi_grade + "\n");
        System.out.print("数据结构成绩" + n.data_grade + "\n");
    }
    public static void find_by_name(node t, String name) {
        if (t != null) {
            find_by_name(t.left, name);
            if (name == t.name) {
                show(t);
            }
            find_by_name(t.right, name);
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

    public static void main(String[] args) {
        node n = new node();
       add(n, "王", 10, 0, 0, 0, "女");
        add(n, "田浩川", 9, 10, 10, 10, "男");
         add(n, "hello", 12, 10, 10, 10, "女");
        LDR(n);
        find_by_name(n,"田浩川");
    }
}
