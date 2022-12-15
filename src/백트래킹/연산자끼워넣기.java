package 백트래킹;

import java.util.Scanner;

public class 연산자끼워넣기 {


    public static boolean[] visit;
    public static int[] numbers;//숫자들
    public static char[] operator;
    public static int min = Integer.MAX_VALUE;//최솟값
    public static int max = Integer.MIN_VALUE;//최대값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numbers = new int[n];
        operator = new char[n - 1];
        visit = new boolean[n - 1];//전체 연산자의 갯수는.?
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        //뭔가 문자열 받는거를 다시 생각해봐야 할것 같다능.
        int[] operators = new int[4];
        for (int i = 0; i < operators.length; i++) {
            operators[i] = sc.nextInt();
        }
        int index = 0;
        for (int i = 0; i < operators.length; i++) {
            if (i == 0) {
                for (int j = 0; j < operators[i]; j++) {
                    operator[index] = '+';
                    index++;
                }
            } else if (i == 1) {
                for (int j = 0; j < operators[i]; j++) {
                    operator[index] = '-';
                    index++;
                }

            } else if (i == 2) {
                for (int j = 0; j < operators[i]; j++) {
                    operator[index] = 'x';
                    index++;
                }
            } else {
                for (int j = 0; j < operators[i]; j++) {
                    operator[index] = '/';
                    index++;
                }
            }
        }

        bt(numbers[0], 0);
        System.out.println(max);
        System.out.println(min);

    }

    public static void bt(int num, int index) {
        if (index == numbers.length - 1) {//다음 인덱스로는 넘어가지 않는다.
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {//다음 숫자를 더하는 방식으로 가는거자나
            if(!visit[i]){//모든 경우의 수를 가정을 해야하기 때문에 이거를 어떻게 생각을 해야하는 것일까.?
                visit[i]=true;
                switch (operator[i]) {
                    case '+':
                        num += numbers[index + 1];
                        bt(num, index+1);
                        num -= numbers[index + 1];
                        break;
                    case '-':
                        num -= numbers[index + 1];
                        bt(num, index+1);
                        num += numbers[index + 1];
                        break;
                    case 'x':
                        num *= numbers[index + 1];
                        bt(num, index+1);
                        num /= numbers[index + 1];
                        break;
                    case '/':
                        num /= numbers[index + 1];
                        bt(num, index+1);
                        num *= numbers[index + 1];
                        break;
                }
                visit[i]=false;
            }
        }
    }
}



