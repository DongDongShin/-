package 백트래킹;

import java.util.Scanner;

public class 스타트와링크 {


    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        }
        combination(0,0);
        System.out.println(min);
    }

    public static void combination(int depth,int index) {//조합을하고 된거를 계산을 하면되겄지요?
        if(depth == arr.length/2){//다 찼으니깐. 이제 계산을 하면 되는
            score();
        }
        for (int i=index;i<arr.length;i++){
            if(!visit[i]){//해당 인덱스가 아직 탐색이 되지 않았다면
                visit[i]= true;
                combination(depth+1,i+1);
            }
            visit[i]= false;
        }

    }

    public static void score(){
        int start_team=0;
        int ent_team =0;
        int diff =0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){//현재 visit 배열의 모든 요소들을 검색..
                if (visit[i]&&visit[j]) {
                    start_team += arr[i][j];
                    start_team += arr[j][i];
                }
                else if (!visit[i]&&!visit[j]) {
                    ent_team += arr[i][j];
                    ent_team += arr[j][i];
                }
            }
        }
         diff = Math.abs(start_team-ent_team);

        if(diff==0){
            System.out.println(0);
            System.exit(0);

        }
        min = Math.min(min,diff);



    }
}

