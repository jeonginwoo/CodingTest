package Algorithm01_배열;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 04 모의고사
 * 일시 : 24.06.11(화)
 * 풀이 시간 : 15분
 */

import java.util.*;

public class 코테완정_문제04 {
    public static void main(String[] args) {
        // input data
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {1, 3, 2, 4, 2}
        };

        // output data
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(solution(arrays[i])));
        }
    }

    private static int[] solution(int[] answer) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] point = {0, 0, 0};
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if (answer[i] == arrays[j][i % arrays[j].length]) {
                    point[j]++;
                }
            }
        }
        int maxPoint = 0;
        for (int i = 0; i < point.length; i++) {
            maxPoint = Math.max(maxPoint, point[i]);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < point.length; i++) {
            if (point[i] == maxPoint) {
                answerList.add(i+1);
            }
        }
        int[] answerArray = new int[answerList.size()];
        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = answerList.get(i);
        }
        return answerArray;
    }
}
