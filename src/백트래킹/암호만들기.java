package 백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기{
    
    static int L;//문자열의 길이 -> 작성이 되어야 할.
    static int C;//주어지는 문자의수
    static char[] inputs;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static boolean[] visited;
    static ArrayList<String> answers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        inputs = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = st.nextToken().charAt(0);//형변환이 필요로 함. 
        }
        Arrays.sort(inputs);
        backtracking(0,"");

        for (String answer : answers) {
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static void backtracking(int depth,String str) {
        if (depth == L) {
            if(isVowels(str)&&str.length()>=3) {//자음돠 있어야 함.
                answers.add(str);
            }
            return;// 재귀를 종료함.
        }
        for (int i = 0; i < C; i++) {
            if(!visited[i]){
                visited[i]= true;
                if(depth!=0){//이미 쌓여있는 문자가 임음..다음에 들어가질 문자는 오름차순이 되어야함.
                    if (inputs[i] > str.charAt(str.length() - 1)) {
                        backtracking(depth+1,str+inputs[i]);
                    }
                }
                else{//무조건 다음 재귀를 진행함.
                    backtracking(depth+1,str+inputs[i]);
                }

                visited[i]=false;
            }
        }
    }
    public static boolean isVowels(String temp){
        int vowel =0;
        //모음이 1개 이상이어야 하고 자음은 두개 이상이어야 한다. 즉 구 글자의 뺄셈이 1개 이상이어야 한다
        //vowel도 1이상이 되어야함.
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            for(int j=0;j<vowels.length;j++){
                if(vowels[j]==c) vowel++;
            }
        }

        if (vowel != 0 && temp.length() - vowel >= 2) {
            return true;
        }
        else return false;
    }
}
