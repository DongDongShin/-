package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 부등호 {
    static boolean[] visited;
    static int[] temps;
    static char[] inputs;
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        visited = new boolean[10];//0부터 9까지
        temps = new int[size+1];//숫자가 들어가는 자리
        inputs = new char[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            inputs[i] = st.nextToken().charAt(0);
        }



        backtraking(0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));

    }

    public static void backtraking(int index){

        if (index == inputs.length+1) {//리턴 조건 마지막 인덱스의 크기에 따라 답들이 결정이 됨.
            StringBuilder sb = new StringBuilder();
            for (int temp : temps) {
                sb.append(temp);
            }
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {//아직 탐색을 하지 않은 숫자라면.?
                if(index==0){//탐색이 되지 않고 배열이 차있지 않는 경우라면 무조건 다음 백트래킹
                    visited[i]=true;
                    temps[index]=i;
                    backtraking(index+1);
                    visited[i]= false;
                }
                else {
                    if (inputs[index - 1] == '<') {//이전의 숫자보다 더 큰 수를 가ㅣㅈ고 있어야함
                        if(temps[index-1]<i){
                            visited[i]= true;
                            temps[index]= i;
                            backtraking(index+1);
                            visited[i]= false;
                        }
                    }
                    else{
                        if(temps[index-1]>i){
                            visited[i]= true;
                            temps[index]= i;
                            backtraking(index+1);
                            visited[i]= false;
                        }
                    }
                }
            }
        }
        //종료조건 index가 array length이면 종료조건



    }


}
