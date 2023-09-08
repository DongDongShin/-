package 분할탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int size;
    static int[][] papers;
    static  int answer1 = 0;//-1로 이루어진 얘들
    static  int answer2 = 0;//0으로 이루어진 애들.

    static  int answer3 = 0;//1로 이루어진 애들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        papers = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < size; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,size);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);

    }

    //이제 해야 하는거.. 9분할을 해서 이제 계속이어가게 하는 거지.. 처음 \
    public static void divide(int a,int b,int size){ //얘를 이제 계속 사용을 하는 거얌
        //지금의 시작 인덱스에서 일단 검사를 하는 거임
        if(same_paper(a,b,size)){
            return; //분할된 종이가 다 같은 색깔을 가지고 있으면 지금부터는 검사를 계속 할 필요가 없음
        }

        //만약 종이가 같다면...그러면 분할이 들어가기 전에 이미 같은 종이만 가지고 있다면 return

        int newsize = size /3;
        divide(a,b,newsize);
        divide(a,b+newsize,newsize);
        divide(a,b+newsize*2,newsize);
        divide(a+newsize,b,newsize);
        divide(a+newsize,b+newsize,newsize);
        divide(a+newsize,b+newsize*2,newsize);
        divide(a+newsize*2,b,newsize);
        divide(a+newsize*2,b+newsize,newsize);
        divide(a+newsize*2,b+newsize*2,newsize);
    }

    public  static boolean same_paper(int a,int b , int size){
        int key = papers[a][b];
        for(int i=a;i<a+size;i++){
            for(int j=b;j<b+size;j++){
                if(papers[i][j]!=key)
                    return false;
            }
        }
        if(key==-1)
            answer1++;
        else if(key==0)
            answer2++;
        else
            answer3++;
        return true;

    }
}
