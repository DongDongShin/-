package 조합;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class 서로_다른_문자열의_개수 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String,Integer> map  = new HashMap<>();
        String str = br.readLine();
        for (int len = 1; len<= str.length(); len++) { //문자의 갯수
            int index = 0;
            while (index+len <= str.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = index; i < index + len; i++) {
                    sb.append(str.charAt(i));
                }
                index+=1;//다음 인덱스로 넘어가기
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            }
        }
        int answer = map.size();
        bw.write(answer+"");
        bw.flush();
        br.close();

    }
}
