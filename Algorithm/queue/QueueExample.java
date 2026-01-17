import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 삽입(9) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
		queue.offer(9);
		queue.offer(2);
		queue.offer(3);
		queue.offer(7);
		queue.poll();
		queue.offer(1);
		queue.offer(4);
		queue.poll();
		// 먼저 들어온 원소부터 추출
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
