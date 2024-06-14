package Algorithm03_큐;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 15 요세푸스 문제
 * 일시 : 24.06.13(목)
 * 풀이 시간 : 10분
 */

import java.util.*;

public class 요세푸스_문제 {
    public static void main(String[] args) {
        // input data
        int[][] arrays = {
                {5, 2}
        };

        // output data
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(solution(arrays[i][0], arrays[i][1]));
        }
    }

    private static int solution(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < K; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.isEmpty()? -1 : queue.peek();
    }
}
