package 문자열;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> l_stack = new Stack<>();
        Stack<Character> r_stack = new Stack<>();
        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            l_stack.push(str.charAt(i));
        }
        int cnt = Integer.parseInt(br.readLine());
        while (cnt-- > 0) {

            String[] commands = br.readLine().split(" ");

            if (commands[0].equals("P")) {//추가를 함
                l_stack.push(commands[1].charAt(0));

            } else if (commands[0].equals("L")) {//커서가 왼쪽으로 이동
                if (!l_stack.isEmpty()) {
                    r_stack.push(l_stack.pop());
                }

            } else if (commands[0].equals("D")) {//커서가 오른쪽으로 이종
                if (!r_stack.isEmpty()) {
                    l_stack.push(r_stack.pop());
                }

            } else {
                if (!l_stack.isEmpty()) {
                    l_stack.pop();
                }
            }
        }
        while (!l_stack.isEmpty()) {
            r_stack.push(l_stack.pop());
        }
        while (!r_stack.isEmpty()) {
            bw.write(r_stack.pop());
        }
        br.close();
        bw.flush();
        bw.close();


    }
}
