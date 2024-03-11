package 정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템_programmers {

    public static void main(String[] args) {

        solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});





    }

    public static int solution(int[][] targets) {
        int answer = 0;
        int curr = 0;
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);
        for (int i = 0; i < targets.length; i++) {
            if (curr <= targets[i][0]) {//격추가능한 범위를 벗어난다면?
                curr = targets[i][1];//격추가능한 범위를 업데이트
                answer++;
            }
        }

        return answer;
    }




}
