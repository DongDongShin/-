package 브루드포스;


import java.util.Scanner;

public class 영화감독숌 {
    static int cnt=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 666;

        while(cnt!=n){//경우를 충족, 그리고 입력받은 수로 가면 .. while 종료.
           start++;
           if(String.valueOf(start).contains("666")){
            cnt++;
           }

        }

        System.out.println(start);


    }

}
