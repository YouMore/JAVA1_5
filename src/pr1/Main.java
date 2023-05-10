package pr1;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<int[], String> mas = (massiv) -> {
            Arrays.sort(massiv);
            int k = 0;
            String res = "";

            for (int i = 0; i < massiv.length; i++) {
                if (i == 0 || massiv[i] != massiv[i - 1]) {
                    res += Integer.toString(massiv[i]);
                }
            }
            char[] resChar = res.toCharArray();
            if (resChar[0] == '0'){
                resChar[0] = resChar[1];
                resChar[1] = '0';
            }
            res = new String(resChar);
            return res;
        };
        System.out.println(mas.apply(new int[]{1, 3, 1}));
    }
}
