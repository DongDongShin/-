package map;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class 듣보잡{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < size1; i++) {
            String temp = br.readLine();
            map.put(temp,map.getOrDefault(temp,0)+1);

        }

        for (int i = 0; i < size2; i++) {
            String temp = br.readLine();
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()==2) list.add(entry.getKey());
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String temp : list) {
            System.out.println(temp);
        }

    }
}
