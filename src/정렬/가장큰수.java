package 정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    public static void main(String[] args) {

        solution(new int[]{6,10,2});


    }

    public static String solution(int[] numbers) {

        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2 + o1) - Integer.valueOf(o1 + o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) {
            return "0";
        }
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();

    }
}
