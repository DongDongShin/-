package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
    static int[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        arr = new int[size + 1][size + 1];
        sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= size; j++) {
                arr[i][j] = temp.charAt(j - 1) - 48;
            }
        }

        divideArray(1, 1, size, size, size);
        System.out.println(sb.toString());
    }


    //분활정복.. 들어온 인덱스의 범위에서 모든수가 0이나 1이 아닌 경우에는 4분활로 탐색을 시키고 그과정을 반복
    //좌상 우상 좌하 우하. 범위로. 계속 재귀를 시키는 거고. 파라미터로 인덱스의 시작(좌상) 끝(우하)를 넘기고
    //그 범위로 탐색
    public static void divideArray(int sy, int sx, int ey, int ex, int length) {//현재 한 변의 길이
        int key = arr[sy][sx];
        boolean find = true;
        //일단 시작을 했으니. 괄호를 붙여줘야함
        loopOut:
        for (int i = sy; i <= ey; i++) {
            for (int j = sx; j <= ex; j++) {
                if (arr[i][j] != key) {//아닐 경우에는. 분할을 시작
                    //좌상
                    sb.append("(");
                    //동하야 자세히 생각을 해보자 좌표로 해서 분할을 생각해야함
                    divideArray(sy, sx, sy+length/2-1, sx+length/2-1, length / 2);

                    //우상
                    divideArray(sy, sx + length / 2, sy + length / 2 - 1, ex, length / 2);

                    //좌하
                    divideArray(sy + length / 2, sx, ey, sx + length / 2 - 1, length / 2);

                    //우하
                    divideArray(sy + length / 2, sx + length / 2 , ey, ex, length / 2);

                    sb.append(")");

                    find = false;
                    break loopOut;
                }
            }
        }
        if (find && key == 1) sb.append("1");
        else if (find && key == 0) {
            sb.append("0");
        }


        //이친구가 같으면


    }


}
