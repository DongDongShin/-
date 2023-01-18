package map;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k,tangerine));
    }
    /**
     *
     * @param k 포장을 해야해야할 갯수.
     * @param tangerine
     * @return 최소한의 종류를 return을 해야한다
     * 그럼 해당 map을 구성한 이후해 가장 많은 갯수를 가진  귤 종류부터 고르면 된다잉.
     * 이런 생각을 어떻게 잘하는 걸까 그리디 문제이군요.?
     */
    public static  int solution(int k, int[] tangerine) {
        Map<Integer,Integer> map = new HashMap();
        int answer = 0;
        for (int i : tangerine) {
            if(map.containsKey(i)){//해당키를 가질때
                map.put(i,map.get(i)+1);
            }
            else {
                map.put(i,1);
            }
        }
//        for (int i : tangerine) {
//          map.put(i,map.getOrDefault(i,0)+1); 위에꺼는 좀 막한거고 이걸로 하면 없으면 0을 리턴하고 아니면 그냥 있는거를 리턴하는 거임
//        }

        //현재 무슨 종류가 몇개씩 있는지 map에 저장이 되어있음
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer value : map.values()) {
            list.add(value);
        }

        Collections.sort(list);
        Collections.reverse(list); //가장 많이 있는 것 부터 저장이 되는 거임
        //중복이 개많으면..?
        for (Integer tangerines : list) {
            k-=tangerines;
            if(k<=0){
                answer++;
                return answer;
            }
            answer++;
        }
        return answer;
    }
}
