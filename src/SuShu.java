public class SuShu {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            boolean zhishu = true;
            //每个数除以它之前的数，是否能整出
            for (int j = 2; j < i - 1; j++) {
                if (i % j == 0) {
                    zhishu = false;
                    break;//可以省去，但是效率会下降
                }
            }
            if (zhishu) {
                System.out.println(i);
            }
        }
    }
}
