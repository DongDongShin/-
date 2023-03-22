package Test;

import java.util.Scanner;

public class Scanner_BufferReader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
        sc = new Scanner(System.in);
        String str2 = sc.nextLine();
        System.out.println(str2);

    }
}
