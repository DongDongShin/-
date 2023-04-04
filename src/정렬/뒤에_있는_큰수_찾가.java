package 정렬;

public class 뒤에_있는_큰수_찾가 {
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 5};

        solution(arr);

    }

    public static  int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i]= -1;
        }
        for (int i = 0; i < numbers.length-1; ) {
            for (int j = i + 1; j < answer.length-1; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }
}
