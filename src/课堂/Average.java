package 课堂;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入数字个数");
        int n = s.nextInt();
        int i;
        int sum = 0;
        int ave = 0;
        int[] a = new int[n];
        System.out.println("请输入数据：");
        for ( i = 0; i <a.length ; i++) {
            a[i] = s.nextInt();
            sum = sum +a[i];
        }
        ave = sum/n;
        System.out.println("平均值为" + ave);
        for (int j = 0; j <a.length ; j++) {
            if (a[j]>ave)
                System.out.println(a[j]);
        }
    }
}
