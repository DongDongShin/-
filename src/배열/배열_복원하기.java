package 배열;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.util.StringTokenizer;

public class 배열_복원하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] A= new int[H][W];
        int[][] B= new int[H+X][W+Y];

        for(int i =0;i<H+X;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                B[i][j]= Integer.parseInt(st.nextToken());//배열을 저장...
            }
        }
        for(int i =0;i<H;i++){
            for (int j = 0; j < W; j++) {
                //겹치는 부분일 때를 생각해보자
                if(i>=X&&j>=Y){
                    A[i][j]=B[i][j]-A[i-X][j-Y];
                }
                else
                    A[i][j]=B[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<H;i++){
            for (int j = 0; j < W; j++) {
             sb.append(A[i][j]+" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();





    }
}
