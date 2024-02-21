package greedy;

import java.io.*;

public class 잃어버린_괄호 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter sw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer= Integer.MAX_VALUE;


        String[]str = br.readLine().split("-");

        for (int i = 0; i < str.length; i++) {
            String[] append = str[i].split("\\+");//더하기 애들로 나눠줌
            int temp=0;
            for (String s : append) {
                temp+=Integer.parseInt(s);
            }
            if(answer==0) answer = temp;
            else
                answer-=temp;
        }
        sw.write(String.valueOf(answer));
        sw.flush();
        sw.close();
        br.close();



    }
}
