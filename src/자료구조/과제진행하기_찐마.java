package 자료구조;

import java.util.PriorityQueue;
import java.util.Stack;

public class 과제진행하기_찐마 {


    public static void main(String[] args) {

    }
    static class Subject implements Comparable<Subject>{
        String name;
        int start;//과제 시작시간
        int play;//과제 진행시간

        public Subject(String name, int start, int play) {
            this.name = name;
            this.start = start;
            this.play = play;
        }

        @Override
        public int compareTo(Subject o) {
            return this.start - o.start; //과제 시작시간으로 오름차순으로 정렬을 함.
        }
    }


    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        PriorityQueue<Subject> pq = new PriorityQueue<>();
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            String start = plans[i][1];
            String play = plans[i][2];
            pq.offer(new Subject(name, change_time(start),Integer.parseInt(play)));
        }

        Subject curr = pq.poll();//처리할 대상인 과제를 지정을 해줌.
        int curr_time = curr.start;//현재의 시각을 의미함
        Stack<Subject> stack = new Stack<>();//남아있는 과제를 저장하는 스택을 의미함.
        while(true){
            //s.playtime-(q.peek().start-now
            if(!pq.isEmpty()&&curr_time+curr.play>pq.peek().start)//과제를 진행하지 못하는 상태 -> 다음 과제의 시작 시간 보다 더욱 오래 걸림.
            {
                stack.push(new Subject(curr.name, curr.start,curr.play-(pq.peek().start-curr_time)));//새로운 항목을 스택에 추가해줌
                curr_time = pq.peek().start;
                curr = pq.poll();//다음 과제로 진행 대상을 변경해줌
            }
            else{
                //과제를 진행할 수 있음.
                answer[idx++]= curr.name;
                curr_time+=curr.play; //시간을 더 해줌.

                if (!pq.isEmpty() && curr_time == pq.peek().start) {//진행이 대기중이고, 들어오는 과제가 존재할 때.
                    curr = pq.poll();// 다음 진행되어야 할 과제로 선정을 함.
                } else if (!stack.isEmpty()) {//스택에 존재하는 과제가 있을때.
                    curr = stack.pop();
                } else if (!pq.isEmpty()) {//다음에 순번으로 pq에 존재하지 않고 스택에도 존재하지 않으면 강제적으로 pq에 있는 과제를 선택을 함
                    curr = pq.poll();
                    curr_time = curr.start;
                }
                else{
                    break;//진행할 과제가 아무것도 존재하지 않기 때문에 break를 함.
                }
            }

        }

        return answer;
    }


    public static int change_time(String time){
        String[] str = time.split(":");
        return Integer.valueOf(str[0])*60+Integer.valueOf(str[1]);

    }


}
