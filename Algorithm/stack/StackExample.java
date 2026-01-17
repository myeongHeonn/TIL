import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// 삽입(9) - 삽입(2) - 삽입(3) - 삽입(5) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
		stack.push(9);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.pop();
		stack.push(1);
		stack.push(4);
		stack.pop();
		// stack의 최상단 원소부터 출력
		while (!stack.empty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
		
	}
}