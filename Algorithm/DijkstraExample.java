/* [ 다익스트라(Dijkstra) 알고리즘 ]
 * 
 * 가중치가 있는 그래프에서 한 정점 -> 모든 정점까지의 최단 거리를 구하는 알고리즘
 * (단, 음수 간선이 있으면 안 된다.)
 * 
 * 시간 복잡도 : O((V + E)logV) (인접 리스트 + PriorityQueue 사용 시)
 * - 정점마다 PQ에 들어갈 수 있음 -> V번
 * - 간선마다 relax 가능 -> E번
 * - PQ 연산은  logV
 * 
 * 공간 복잡도 : O(V + E)
 * - 그래프 저장 : O(V + E)
 * - dist 배열 : O(V)
 * - PQ : 최악 O(E)
 */

import java.io.*;
import java.util.*;

public class DijkstraExample {

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용 오름차순
        }
    }

    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 정점 개수
        M = Integer.parseInt(br.readLine()); // 간선 개수

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        int start = Integer.parseInt(br.readLine());

        dijkstra(start);

        for (int i = 1; i <= N; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            // 이미 더 짧은 경로가 있으면 skip
            if (now.cost > dist[now.to]) continue;

            for (Node next : graph[now.to]) {

                int newCost = dist[now.to] + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}
