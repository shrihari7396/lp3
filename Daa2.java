import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class Daa2 {

    private static void print(Node root, String s) {
        if(root == null) {
            return ;
        }
        if(root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + s);
            return ;
        }

        print(root.left, s + '0');
        print(root.right, s + '1');
    }

    private static void process(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.freq, b.freq));
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node('\0', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        Node root = pq.poll();

        print(root, "");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String For which you have to Hoffman Encoding: ");
        String s = sc.nextLine();
        process(s);
        sc.close();
    }
}