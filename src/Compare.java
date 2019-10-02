import java.util.Scanner;

public class Compare {
    static void maopao(int[] shu) {
        int temp;
        for (int i = 0; i < shu.length-1; i++) {
            for (int j = 0; j < shu.length-i-1; j++) {
                if (shu[j] > shu[j + 1]) {
                    temp = shu[j ];
                    shu[j] = shu[j+1];
                    shu[j+1] = temp;
                }
            }
            System.out.println(shu[shu.length-i-1]);
    }
      //  for (int i = 0; i <shu.length ; i++) {

      //  }
    }

    public static void main(String args[]) {
    //    int integer[] = {1,9,5};
        int integer[]= new int[10];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            integer[i] = s.nextInt();
        }
        maopao(integer);
    }
}
