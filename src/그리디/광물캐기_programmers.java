package 그리디;

import java.util.Arrays;

public class 광물캐기_programmers {

    public static void main(String[] args) {

        int answer = Solution(new int[]{1, 2, 3}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
        System.out.println(answer);

    }


    static int[][] weight;//하나의 행은 5개 연속으로 광물을 캘때으 피로도가 저장이 됨.
    public static  int Solution(int[] picks, String[] minerals) {
        int size = Math.min(minerals.length / 5 + 1, (picks[0] + picks[1] + picks[2]));//이게 뭘까..
        int answer = 0;
        //해당 곡괭이로 캘때의 피로도들을 저장함.
        int diamond = 0;
        int iron = 0;
        int stone = 0;
        weight = new int[size][3];
        for (int i = 0; i < minerals.length; i += 5) {
            if (i / 5 == size) break;
            for (int j = i; j < i + 5; j++) {//5개씩 더하기 위해.
                if(j==minerals.length) break;
                String m = minerals[j];//현재 광물의 종류를 가져옴.
                if (m.equals("diamond")) {//다이아 몬드 일대
                    diamond += 1;
                    iron += 5;
                    stone+=25;

                } else if (m.equals("iron")) {
                    diamond +=1;
                    iron += 1;
                    stone+=5;
                } else {

                    diamond +=1;
                    iron += 1;
                    stone += 1;
                }
            }
            weight[i / 5][0]= diamond;
            weight[i / 5][1]= iron;
            weight[i / 5][2]= stone;
            diamond = iron = stone =0;//초기화.

        }
        Arrays.sort(weight, (o1, o2) -> (o2[2] - o1[2]));//철 곡괭이로 드는 피로도로 내림차순으로 정렬을함.
        for (int i = 0; i < size; i++) {
            if (picks[0] != 0) {//아직 다이아 곡괭이가 남아잇음
                picks[0]--;
                answer += weight[i][0];

            }
            else if (picks[1] != 0) {//아직 다이아 곡괭이가 남아잇음
                picks[1]--;
                answer += weight[i][1];

            }
            else{
                picks[2]--;
                answer+= weight[i][2];
            }
        }
        return answer;
    }

}
