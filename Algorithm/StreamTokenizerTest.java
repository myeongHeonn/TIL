package practice;
/* StreamTokenizer
 * : 문자  스트림을 토큰(단어, 숫자) 단위로 쪼개서 읽어주는 클래스
 * - 한 줄 읽고 쪼갠다 X
 * - 공백, 개행 상관없이 토큰 하나씩 읽는다
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class StreamTokenizerTest {
	
	static StreamTokenizer st;
	
	static int nextInt() throws Exception {
		st.nextToken();
		return (int) st.nval;
	}

	public static void main(String[] args) throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		// case 1 : 숫자 입력
		st.nextToken();
		int n1 = (int) st.nval;
		
		st.nextToken();
		int n2 = (int) st.nval;
		
		System.out.println(n1 + n2);
		
		// case 2 : 숫자 입력 (nextInt() 만들어서 사용하기)
		int n = nextInt();
		int m = nextInt();
		
		System.out.println(n + m);
		
		// case 3 : 문자 입력
		st.nextToken();
		String s1 = st.sval;
		
		System.out.println(s1);
	}

}
