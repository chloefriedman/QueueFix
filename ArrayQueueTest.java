import java.util.Queue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<String> a = new ArrayQueue<String>();
        a.add("A");
        a.add("B");
        a.add("C");
        System.out.println(a.peek());
        System.out.println(a.remove());
    }
}
