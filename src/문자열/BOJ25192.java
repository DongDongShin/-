package 문자열;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ25192 {


    public static int cnt =0;
    public static Set<String> set;
    //set은 중복을 관리하지 않았자나..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.equals("ENTER")) {//이거면 map 초기화
                cnt +=set.size();
                set.clear();
                continue;
            }
            set.add(key);
        }
        //마지막에 있는 애들은 더하는 과정이 없죠
        System.out.println(cnt+set.size());




    }
}
