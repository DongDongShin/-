package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축하기 {


    static int[] arr;//원래의 배열
    static int[] arr2;//복사를 하고
    static int[] answer;
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        arr = new int[n];
        arr2 = new int[n];
        //내림차순으로 정렬을 했기에 자기보다 작은 애들은 자신의 인덱스가 자기보다 작음 그렇기때문에 그냥 자기 인덱스를 넣어주면 될듯

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i]= num;
            arr2[i]= num;
        }
        int rank=0;
        Arrays.sort(arr2);//애를 정렬을 일단하고
        for (int num : arr2) {
            if (!map.containsKey(num)) {//해당의 키가 없다면
                map.put(num, rank);
                rank++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            sb.append(" ");
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());


    }


}
