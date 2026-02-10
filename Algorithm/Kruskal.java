package lesson;
/** [ Kruskal 알고리즘 ]
 * 간선을 비용 오름차순으로 정렬해서, 사이클 안 생기게 하나씩 선택
 * 
 * < 동작 순서 >
 * 1. 모든 간선을 비용 기준으로 오름차순 정렬
 * 2. 가장 싼 간선부터 하나씩 확인
 * 3. 두 정점이 같은 집합(사이클)이면 skip, 다른 집합이면 선택
 * 4. 간선을 N-1개 선택하면 종료
 * 
 * 사이클 체크를 위해 Union-Find 사용
 * 
 * < Union-Find >
 * find(x): x의 대표(root) 찾기
 * union(a, b): 두 집합 합치기
 * 사이클 판별 : find(a) == find(b) -> 사이클
 */

import java.util.Arrays;

class Kruskal {
	
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		// 비용 기준 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int[] parent;
	
	// 대표 노드 찾기 (경로 압축)
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	// 두 집합 합치기
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return false; // 사이클 발생
		parent[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) {
		
		int V = 4; // 정점 개수
		int E = 5; // 간선 개수
		
		Edge[] edges = {
				new Edge(1, 2, 1),
				new Edge(1, 3, 3),
				new Edge(2, 3, 1),
				new Edge(2, 4, 6),
				new Edge(3, 4, 2)
		};
		
		// 1. 간선 정렬
		Arrays.sort(edges);
		
		// 2. 부모 배열 초기화
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		int mstCost = 0;
		int edgeCount = 0;
		
		// 3. 간선 선택
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				mstCost += e.cost;
				edgeCount++;
				
				if (edgeCount == V - 1) break;
			}
		}
		
		System.out.println("MST 총 비용: " + mstCost);
	}
	
}
