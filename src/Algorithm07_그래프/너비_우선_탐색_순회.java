package Algorithm07_그래프;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 35 너비 우선 탐색 순회
 * 일시 : 24.06.18(화)
 * 풀이 시간 : 20분
 */

import java.util.*;

public class 너비_우선_탐색_순회 {
    public static void main(String[] args) {
        // input data
        // 그래프 [출발 노드, 도착 노드]
        int[][][] graph = {
                {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}},
                {{1, 3}, {3, 4}, {3, 5}, {5, 2}}
        };
        // 시작 노드
        int[] start = {
                1,
                1
        };
        // 노드 개수
        int[] n = {
                9,
                6
        };

        // output data
        for (int i = 0; i < n.length; i++) {
            System.out.println(Arrays.toString(
                    new 너비_우선_탐색_순회().solution(graph[i], start[i], n[i])
            ));
        }
    }

    private static ArrayList<Integer>[] graphList;
    private static boolean[] visited;

    public int[] solution(int[][] graph, int start, int n) {
        graphList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graphList[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            graphList[graph[i][0]].add(graph[i][1]);
        }

        return BFS(start);
    }

    public static int[] BFS(int start) {
        ArrayList<Integer> visitSeq = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int visit = queue.poll();
            visitSeq.add(visit);
            for (int i = 0; i < graphList[visit].size(); i++) {
                int next = graphList[visit].get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return visitSeq.stream().mapToInt(i -> i).toArray();
    }
}
