package InsertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            char res = chars[i];
            int k = i;
            for (; k > 0 && chars[k-1] > res; k--) {
                chars[k] = chars[k-1];
            }
            chars[k] = res;
        }
    }
    public static void main(String[] args) {
        char[] var1 = new char[]{'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
        System.out.println(Arrays.toString(var1));
        insertionSort(var1);
        System.out.println(Arrays.toString(var1));
    }
}
