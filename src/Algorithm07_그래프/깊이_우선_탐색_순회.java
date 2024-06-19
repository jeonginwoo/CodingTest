package Algorithm07_그래프;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 34 깊이 우선 탐색 순회
 * 일시 : 24.06.18(화)
 * 풀이 시간 : 40분
 */

import java.util.*;

public class 깊이_우선_탐색_순회 {
    public static void main(String[] args) {
        // input data
        // 그래프 [출발 노드, 도착 노드]
        int[][][] graph = {
                {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}},
        };
        // 시작 노드
        int[] start = {
                1,
                1
        };
        // 노드 개수
        int[] n = {
                5,
                6
        };

        // output data
        for (int i = 0; i < n.length; i++) {
            System.out.println(Arrays.toString(
                    new 깊이_우선_탐색_순회().solution(graph[i], start[i], n[i])
            ));
        }
    }

    public int[] solution(int[][] graph, int start, int n) {
        ArrayList<Integer>[] graphList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graphList[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            graphList[graph[i][0]].add(graph[i][1]);
        }

        ArrayList<Integer> dfsVisited = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int visit = stack.pop();
            visited[visit] = true;
            dfsVisited.add(visit);
            for (int i = 0; i < graphList[visit].size(); i++) {
                if (!visited[graphList[visit].get(i)]) {
                    stack.push(graphList[visit].get(i));
                }
            }
        }

        return dfsVisited.stream().mapToInt(i -> i).toArray();
    }
}
