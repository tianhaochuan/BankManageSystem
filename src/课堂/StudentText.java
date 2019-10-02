package 课堂;

public class StudentText {
    public static void main(String args[]) {
        //对象1小明
        Student xiaoming = new Student();
        xiaoming.setAge(10);
        System.out.println("小明的分数为"+  xiaoming.getScore());
        System.out.println("小明的年龄为"+xiaoming.age);
        System.out.println();
        //对象2小红
        Student xiaohong = new Student("小红","女生");
        System.out.println("小红的名字是"+xiaohong.name);
        System.out.println("小红的性别是"+xiaohong.sex);
        System.out.println("小红的分数是"+xiaohong.score);
        System.out.println("小红的年龄是"+xiaohong.age);
    }
}
