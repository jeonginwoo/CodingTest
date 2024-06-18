package Algorithm06_집합;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 30 간단한 유니온-파인드 알고리즘 구현하기
 * 일시 : 24.06.17(월)
 * 풀이 시간 : 50분
 */

import java.util.*;

public class 간단한_유니온_파인드_알고리즘_구현하기 {
    public static void main(String[] args) {
        // input data
        int[][][] arrays = {
                {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}},
                {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}}
        };

        // output data
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(
                    new 간단한_유니온_파인드_알고리즘_구현하기().solution(arrays[i])
            ));
        }
    }

    public Boolean[] solution(int k, int[][] operations) {
        int[] nodes = new int[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = i;
        }
        ArrayList<Boolean> booleanList = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 0) {
                union(nodes, operations[i][1], operations[i][2]);
            } else {
                booleanList.add(find(nodes, operations[i][1]) == find(nodes, operations[i][2]));
            }
        }

        return booleanList.toArray(new Boolean[0]);
    }

    public static void union(int[] nodes, int x, int y) {
        int rootX = find(nodes, x);
        int rootY = find(nodes, y);
        if (rootX > rootY) {
            nodes[rootY] = rootX;
        } else {
            nodes[rootX] = rootY;
        }
    }

    public static int find(int[] nodes, int x) {
        if(nodes[x] == x) {
            return x;
        }
        return find(nodes, nodes[x]);
    }
}
