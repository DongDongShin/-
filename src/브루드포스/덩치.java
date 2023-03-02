package 브루드포스;

import java.util.Scanner;

public class 덩치 {


    public static class person {
        private int height;
        private int weight;

        public person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        person[] parr = new person[n];
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            person temp = new person(weight, height);
            parr[i] = temp;
        }
        System.out.println(search(parr));

    }

    public static String search(person[] parr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parr.length; i++) {//현재 탐색하는얘가 i
            int cnt =0;
            for (int j = 0; j < parr.length; j++) {
                if (j == i)
                    continue;
                if (parr[j].weight > parr[i].weight&&parr[j].height > parr[i].height) {//비교하는 얘가 더 커버리면
                    cnt++;

                }
            }
            sb.append((cnt+1)+" ");
        }

        return sb.toString();
    }
}
