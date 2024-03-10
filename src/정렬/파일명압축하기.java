package 정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명압축하기 {

    static class Data{
        String head;
        String number;
        String tail;

        public Data(String head, String number,String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    public static void main(String[] args) {
        solution(new String[]{"muzi 1.png1234", "MUZI1.png2", "MUZI1.png3", "muzi1.png4"});

    }
    public static  String[] solution(String[] files) {
        Data[] inputs = new Data[files.length];
        boolean tail = false;
        for (int i = 0; i < files.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            boolean find = false;
            tail = false;
            StringBuilder sb2 = new StringBuilder();
            int idx=0;
            for (int j = 0; j<files[i].length(); j++) {
                if(!Character.isDigit(files[i].charAt(j))){//문자일때.
                    if (find) {
                        tail=true;
                        idx = j;
                        break;
                    }
                    sb1.append(files[i].charAt(j));
                }
                else{
                    //처음 숫자가 등장할 때
                    find = true;
                    sb2.append(files[i].charAt(j));
                }
            }
            String temp;
            if(tail)
                temp = files[i].substring(idx, files[i].length());
            else temp = "";

            //없을 경우도 생각을 해줘야함.
            inputs[i] = new Data(sb1.toString(), sb2.toString(),temp);//소문자로 통일을 시킴.
        }

        Arrays.sort(inputs, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.head.toLowerCase().compareTo(o2.head.toLowerCase())==0) {//head가 같을 경우에는
                    return Integer.valueOf(o1.number)-Integer.valueOf(o2.number);//오름차순으로 정렬을 함.
                }
                else {
                    return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());//소문자로 통합을 해서..풀어야하늗석임.
                }
            }
        });

        String[] answer = new String[files.length];
        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputs[i].head);
            sb.append(inputs[i].number);
            sb.append(inputs[i].tail);
            answer[i] = sb.toString();

        }
        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }



}
