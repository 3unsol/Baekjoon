import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Node head;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        head = new Node(sc.nextInt(), null, null);

        while(sc.hasNext()) {
            head.insert(sc.nextInt());
        }

        postOrder(head);
    }

    static void postOrder(Node node) {

        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);

    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int value) {

            if(value < this.value) {
                if(this.left == null) this.left = new Node(value);
                else this.left.insert(value);
            } else {
                if(this.right == null) this.right = new Node(value);
                else this.right.insert(value);
            }

        }
    }
}