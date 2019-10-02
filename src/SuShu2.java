public class SuShu2 {
    public static void main(String[] args) {
        for (int i = 101;i<201;i++){
            for (int n = i;n>1;n--){
                if (i%(n-1)==0){
                    break;
                }
                if (n==2){
                    System.out.println(i);
                }
            }
        }
    }
}
