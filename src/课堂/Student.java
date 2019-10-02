package 课堂;

public class Student {
    String  name;
    String  sex;
    int age;
    double score;
    public Student(){
    }
    public Student(String name,String sex){
        this.name = name;
        this.sex =sex;
    }
    void setAge(int a){
        age = a;
    }
    double getScore(){
        return score;
    }
}
