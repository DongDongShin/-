package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 쿠키런_신체_측정 {
    static char[][] arr;
    static int headX=0;
    static int headY=0;
    static int heartX=0;
    static int heartY=0;

    static int rArmLength=0;
    static int lArmLength=0;
    static int waistLength=0;
    static int rLegLength=0;
    static int lLegLength=0;
    static int rLeg=0;
    public static void main(String[] args) throws IOException {

        int lLen=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        arr= new char[size+1][size+1];
        for (int i = 1; i < arr.length; i++) {
            char[] temp= br.readLine().toCharArray();
            for (int j = 1; j < arr.length; j++) {
                arr[i][j] = temp[j - 1];//일단 저장.
            }
        }
        findHead();
        findArmLength();
        findLegLength();
        System.out.println(heartY+" "+heartX);
        System.out.println(lArmLength+" "+rArmLength+" "+waistLength+" "+lLegLength+" "+rLegLength);

    }

    public static void findHead() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[i][j]=='*'){
                    heartY=i+1;
                    heartX=j;
                    return;
                }
            }
        }
    }

    public static void findArmLength() {
        int idx = heartX-1;
        while (idx >= 1 && arr[heartY][idx]!= '_') {//왼쪽 길이를 구함
            lArmLength++;
            idx--;
        }
        idx = heartX+1;
        while (idx <= arr.length-1 && arr[heartY][idx]!= '_') {//오른쪽 길이를 구함
            rArmLength++;
            idx++;
        }
    }

    public static void findLegLength() {
        int waist = heartY;
        while (arr[waist][heartX] != '_') {
            waist++;//허리의 좌표를 찾아봅시다.
            waistLength++;
        }
        waistLength--;
        int idx = waist;
        while (idx <= arr.length-1 && arr[idx][heartX-1]!= '_') {//왼쪽 길이를 구함
            lLegLength++;
            idx++;
        }
        idx = waist;
        while (idx <= arr.length-1 && arr[idx][heartX+1]!= '_') {//오른쪽 길이를 구함
            rLegLength++;
            idx++;
        }
    }
}
