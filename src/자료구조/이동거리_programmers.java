package 자료구조;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class 이동거리_programmers {


    public static void main(String[] args) {
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs){
        HashSet<String> set = new HashSet<>();
        //들어가지는 명령문에 따라서 현재의 좌표를 달라지게 함.
        int currentX = 0;//최근의 X 좌표
        int currentY = 0;//최근의 Y 좌표
        for (int i = 0; i < dirs.length(); i++) {
            char curr = dirs.charAt(i);
            int nextX= currentX;
            int nextY = currentY;
            switch (curr){
                case 'U': //위로 한칸 감
                    nextY++;
                    break;
                case 'D': //아래로 한칸 감
                    nextY--;
                    break;
                case 'R': //오른쪽으로 한 칸 감
                    nextX++;
                    break;
                case 'L': //왼쪽으로 한 칸감
                    nextX--;
                    break;
            }
            //경우에 맞춰서 좌표를 이동시켜 준다,
            if(nextX<-5||nextY<-5||nextX>5||nextY>5){
                continue;
            }
            //인덱스 범위가 안 넘어가면 이제 set에 저장을 해야됨.
            int arr[][] = new int[][]{{currentX, currentY}, {nextX, nextY}};
            //일단 배열을 만들고 해당 배열의 x좌표 대소에 따라서 정렬을 해주도록 함
            Arrays.sort(arr, new Comparator<int[]>() {//두 가지 배열의 x좌표에 따라 오름차순으로 정렬을 해줌
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]>o2[0]) return 1;
                    else if (o1[0]==o2[0]) {
                        return o1[1]-o2[1];
                    }
                    else return -1;
                }
            });
            set.add(arr[0][0] + " " + arr[0][1] + " " + arr[1][0] + " " + arr[1][1]);
            currentX = nextX;
            currentY = nextY;

        }
        return set.size();

    }
}
