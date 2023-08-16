package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {


    public static  int white;
    public static int blue;
    public static int[][] square;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];

        for (int i = 0; i < N; i++) { //바보가 되었구나 신동하
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide_search(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide_search(int row, int col, int size) {
        //계속 나눠서 거기에 대해 계속 검사하면 된다는
        if (same_color(row, col, size)) {//만약 색깔이 같더라면.
            if(square[row][col]==0)
                white++;
            else
                blue++;
            return; //더 이상 재귀를 할 이유 x
        }
        size = size/2;
        //1사분면
        divide_search(row , col+size, size);
        //2사분면
        divide_search(row , col, size);
        //3사분면
        divide_search(row + size, col, size);


        //4사분면
        divide_search(row + size, col+size, size);

    }

    //같으면 한장 아니면 같아질때 까지 계속 더
    public static boolean same_color(int row, int col, int size) { //이분 탐색을 해서.. 해보는 거지
        int key = square[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (key != square[i][j]) {
                    return false;
                }

            }
        }
        return true;

    }
}
