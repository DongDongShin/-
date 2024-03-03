package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 한줄로서기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];//처음에는 다 0으로 초기화를 함.
        ArrayList<Integer> list = new ArrayList<>();
        //0이 아니면 이미 자리를 차지한 것을 의미함.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = size - 1; i >= 0; i--) {
            //큰 수부터 자기가 들어갈 자리를 찾아가면 됨.
            list.add(arr[i],i+1);
        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }


    }
}
