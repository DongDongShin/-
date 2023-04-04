package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.DoubleSummaryStatistics;
import java.util.StringTokenizer;

public class 트리순회 {

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public static void insertNode(Node temp, char value, char left, char right) {
        //temp가 root 일 때
        if (temp.value == value) {
            if (left != '.') {
                temp.left= new Node(left,null,null);
            }
            if (right != '.') {
                temp.right = new Node(right,null,null);

            }
        }
        else{
            if (temp.left != null) {//얘가 먼저 실행이됨
                insertNode(temp.left,value,left,right);
            }
            if (temp.right != null) {
                insertNode(temp.right,value,left,right);
            }
        }
        //아닐때. 다시 head 부터들어 가서 탐색을 해야겠지....
    }
    public static void preorder(Node node) {
        if(node ==null)
            return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node ==null)
            return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    static Node head;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        head = new Node('A',null,null);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head,root,left,right);

        }
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);


    }

}
