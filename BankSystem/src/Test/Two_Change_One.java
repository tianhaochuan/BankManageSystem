package Test;

public class Two_Change_One {
    public static void main(String[] args) {
        String[][] result = new String[6][10];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] =((331 + 33 * j)+ "," + (446 + 26 * i ));
                System.out.println(result[i][j]);
            }
        }
        String[] z = new String[120];
        int k = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                for (String retval : result[i][j].split(",")) {
                    z[k] = retval;
                    k++;
                }
            }
        }
        for (int i = 0; i < 120; i++) {
            System.out.println(z[i]);
        }
        int [] ints = new int[z.length];
        for (int i = 0; i <z.length ; i++) {
            ints[i] = Integer.parseInt(z[i]);
        }
    }
}
