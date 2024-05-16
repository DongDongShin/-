package 그래프;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의_순회 {
    static  class Node{
        int left;
        int right;
        Node(int left,int right) {
            this.left = left;
            this.right = right;
        }
    }
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static Node[] nodes;
    static int lastIndex;
    static int cnt=0;
    static int parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        visited = new boolean[size + 1];//방문의 여부를 저장하는 배열
        nodes = new Node[size+1];
        parents= new int[size+1];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int edge = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes[edge] = new Node(left, right);
            if(left!=-1)
            parents[left]=edge;
            if(right!=-1)
            parents[right]=edge;
        }
        inorder(1);
        lastIndex = list.get(list.size() - 1);//중위순회의 마지막 인덱스를 저장을 함.
        similarInorder(1);
        System.out.println(cnt-1);
    }


    
    /*
    현재 위치한 노드의 왼쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 왼쪽 자식 노드로 이동한다.
    그렇지 않고 현재 위치한 노드의 오른쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 오른쪽 자식 노드로 이동한다.
    그렇지 않고 현재 노드가 유사 중위 순회의 끝이라면, 유사 중위 순회를 종료한다.
    그렇지 않고 부모 노드가 존재한다면, 부모 노드로 이동한다.
    유사 중위 순회를 종료할 때까지 1 ~ 4를 반복한다.
     */
    public static void similarInorder(int idx) {
        Node curr = nodes[idx];//현재의 노드를 저장을 함
        cnt++;
        //System.out.println("current: "+idx);
        if(curr.left!=-1&&!visited[curr.left]){
            visited[curr.left]= true;
            similarInorder(curr.left);
        } else if (curr.right!=-1&&!visited[curr.right]) {
            visited[curr.right] = true;
            similarInorder(curr.right);
            
        } else if (idx == lastIndex) {
            return;
        } else if (parents[idx] != 0) {//부모가 존재하는 것을 의미함.
            similarInorder(parents[idx]);
        }



    }


    /*
      중위순회를 하는 로직 중위 순회의 끝 노드가 유사 중위 순회의 마지막 노드..
     */
    public static void inorder(int idx){

        int Lchild = nodes[idx].left;
        int Rchild = nodes[idx].right;

        if (Lchild!=-1) {
            inorder(Lchild);
        }
        list.add(idx);
        //System.out.println("current node: "+idx);

       //System.out.println(idx);
        if (Rchild!=-1) {
            inorder(Rchild);
        }

    }
}
