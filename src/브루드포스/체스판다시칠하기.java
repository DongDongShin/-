package 브루드포스;

import java.util.Scanner;

public class 체스판다시칠하기 {

    public static boolean[][] arr ;
    public static int min =64;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();

        arr= new boolean[y][x];//일단은 저장을 해야함!

        for (int i=0;i<y;i++){
            String str = sc.next();//한줄을 저장을 해야한다.
            for (int j=0;j<x;j++){//white일때 true black이라면 false;
                if (str.charAt(j)=='W'){
                    arr[i][j]=true;
                }
                else
                    arr[i][j]=false;
            }
        }



        //이제부터 탐색을 하는  데 끊어서 계속 탐색을 해야함. ! 맨 첫빠따로 들어오는 얘의 기준으로 한줄씩 계속 검사를 해서 그친구랑 맞는지 아닌지 계속 판단을 해줘야함
        for (int i=0;i<y-7;i++){//최대 횟수로 계속 반복을 해서 찾아야겠지??

            for (int j=0;j<x-7;j++){
                solve(i,j);
            }
        }

        System.out.println(min);
    }
    public static void solve (int y,int x){//수정은 하지 않고 좌표로만 계산을 하는거지
        int cnt = 0;
        boolean key = arr[y][x];//첫빠따가 이거임. 만약 얘랑 다르다면 바꿔서 하는거지
        for (int i=y;i<y+8;i++){//최대 횟수로 계속 반복을 해서 찾아야겠지??

            for (int j=x;j<x+8;j++){//계속 탐색을 해서 가버렷!
                if (arr[i][j]!=key){//다르다면 cnt ++
                    cnt++;
                }
                key = !key;//다른 색깔로 바뀌어져야함.
            }
            key = !key;//다음꺼는 다시 바꿔 줘야함

        }

        cnt = Math.min(cnt,64-cnt);
        min = Math.min(min,cnt);


    }
}
