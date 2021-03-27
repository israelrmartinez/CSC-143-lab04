package Testing;
import java.util.*;
import utility.MyStack;


public class StackTests {
    public static void main(String[] args) {
        String[] data = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
        Stack<String> s = new Stack<>();
        System.out.println(s);

        for (String str : data) {
            s.push(str);
        }
        System.out.println("stack = " + s);
    }

    public static void rearrange(Queue<Integer> q) {
        Stack<Integer> s = new Stack<Integer>();
        int size = q.size();

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < size; i++) {
                if (q.peek() % 2 == 0) {
                    q.add(q.remove());
                } else {
                    s.push(q.remove());
                }
            }
            while (!s.isEmpty()) {
                q.add(s.pop());
            }
        }
    }
}
