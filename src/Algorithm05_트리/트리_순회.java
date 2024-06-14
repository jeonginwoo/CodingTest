package Algorithm05_트리;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 25 트리 순회
 * 일시 : 24.06.14(금)
 * 풀이 시간 : 25분
 */

import java.util.*;

public class 트리_순회 {
    public static void main(String[] args) {
        // input data
        int[][] arrays = {
                {1, 2, 3, 4, 5, 6, 7}
        };

        // output data
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(solution(arrays[i])));
        }
    }

    private static String[] solution(int[] nodes) {
        String[] answer = new String[3];
        answer[0] = preorder(nodes, 0).trim();
        answer[1] = inorder(nodes, 0).trim();
        answer[2] = postorder(nodes, 0).trim();

        return answer;
    }

    private static String preorder(int[] nodes, int k) {
        if (k >= nodes.length) {
            return "";
        }
        return nodes[k] + " " + preorder(nodes, k * 2 + 1) + preorder(nodes, k * 2 + 2);
    }

    private static String inorder(int[] nodes, int k) {
        if (k >= nodes.length) {
            return "";
        }
        return inorder(nodes, k * 2 + 1) + nodes[k] + " " + inorder(nodes, k * 2 + 2);
    }

    private static String postorder(int[] nodes, int k) {
        if (k >= nodes.length) {
            return "";
        }
        return postorder(nodes, k * 2 + 1) + postorder(nodes, k * 2 + 2) + nodes[k] + " ";
    }
}
