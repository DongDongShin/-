package 자료구조;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같이하기 {

    public static void main(String[] args) {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        System.out.println( solution(queue1,queue2));

    }
    /**
     * 두개의 queue를 받아서 연산을 하나하나 하면서. 최소의 연산을 return하는 거임
     * 일단 큰 queue를 작은 큐에 넘겨주고 그러면 될것 같은데...
     * 종료조건 일단 모든 원소의 합이 홀수이면.. 안됨. 그리고 한 queue의 size가 0이되면 -1 return.
     * @param queue1
     * @param queue2
     * @return
     */
    public static int solution(int[] queue1, int[] queue2) {
        int answer =0;
        long cnt =0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for (int i : queue1) {
            cnt+=i;
        }
        for (int i : queue2) {
            cnt+=i;
        }
        if(cnt%2!=0){ //모든 원소의 합이 홀수라면 두개의 queue로 구성할수 없음.
            return -1;
        }
        long ans1=0;
        long ans2=0;
        for (int i : queue1) {
            q1.add((long) i);
            ans1+=i;

        }//각각의 q를 구성
        for (int i : queue2) {
            q2.add((long) i);
            ans2+=i;
        }
        cnt = cnt/2;
        int size = (q1.size() + q2.size())*2;
        while(ans1!=ans2){//이 조건 하나의 큐가 이제 같은 값을 가지면 루프 종료! 여기에서 무한루프가 돌대가 있음 안걸러지는 경우가 있는구나
            long temp;
            if(ans1<ans2){//q2의 원소 값이 더욱 더 크면 그 값을 q1에 더 가져가야함
                temp = q2.poll();
                q1.add(temp);
                ans2-=temp;
                ans1+=temp;

            }
            else{
                temp = q1.poll();
                q2.add(temp);
                ans2+=temp;
                ans1-=temp;
            }
            answer++;
            if(size < answer)
                return -1;
        }
        return answer;
    }

}
