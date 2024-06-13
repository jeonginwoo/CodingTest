package Algorithm01_배열;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 01 배열 정렬하기
 * 일시 : 24.06.11(화)
 * 풀이 시간 : 1분
 */

import java.util.*;

public class 배열_정렬하기 {
    public static void main(String[] args) {
        // input data
        int[][] arrays = {
                {1, -5, 2, 4, 3},
                {2, 1, 1, 3, 2, 5, 4},
                {6, 1, 7}
        };

        // output data
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(Arrays.toString(solution(arrays[i])));
        }
    }

    private static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}