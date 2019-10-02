import java.util.Scanner;

public class for_weight {
    public static void main(String args[]){
        //输入行李的重量
        Scanner w= new Scanner(System .in);
        float weight =w.nextFloat();
        float weight_derive = weight;
        while(weight>1){
            weight--;
        }
        if (weight>0&weight<1){
            weight_derive=(int)weight_derive+1;
        }
        System.out.println("需要的费用为"+(weight_derive-40));
    }
}
