package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ19941 {


    static char[] map;
    static boolean[] visited;
    static int N;
    static int K;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer =0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N];
        visited = new boolean[N];

        String temp = br.readLine();
        for (int i = 0; i <N; i++) {
            map[i] = temp.charAt(i);

        }
        for (int i = 0; i < N; i++) {
            if(map[i]=='P'){//현재 사람이라면.
                for (int j = -K; j <= K; j++) {
                    if (i + j < 0) continue;
                    else if (i + j >= N)  break;//인덱스를 벗어날 때
                    else{
                        if (!visited[i + j]&&map[i+j]=='H') {
                            visited[i+j]=true;
                            answer++;
                            break;
                        }
                    }
                }
            }


        }
        System.out.println(answer);




    }
}
