package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        StringBuilder sb = new StringBuilder();
        System.out.println(12121221);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);

            //추가를 하는 데 같으면 그 해당 문자열을 자르고.
            //그런 과정을 거치는데 단계를 거친 인덱스들은 다시 검사를 할 필요가 없뜸.
            boolean check = true; //같으냐 아니냐를 판단을 하는 거임.
            if (sb.length() >= boom.length()) {//이제 부터 시작을 하는 건데 인덱스를 하나하나
                for (int j = 0; j < boom.length(); j++) {
                    char key = sb.charAt(sb.length()-boom.length()+j);
                    char key2 = boom.charAt(j);
                    if (key != key2) {
                        check = false;
                        break;
                    }
                }
                if(check)
                sb.delete(sb.length() - boom.length(), sb.length());
            }
        }
        if (sb.length() == 0) {
            System.out.println("FRULA");
        }
        else
            System.out.println(sb.toString());


    }
}
