import java.util.Scanner;

public class Compare2 {
    static void Compare_2(int a[]){
        int temp;
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-i-1 ; j++) {
                if (a[j]>a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        int a[] = new int[10];
        Scanner s  = new Scanner(System.in);
        for (int i = 0; i <a.length ; i++) {
            a[i] = s.nextInt();
        }
        Compare_2(a);
    }
}
