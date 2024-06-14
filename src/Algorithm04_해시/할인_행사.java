package Algorithm04_해시;

/**
 * 출처 : 프로그래머스 - 131127, 할인 행사
 * 일시 : 24.06.13(목)
 * 풀이 시간 : 10분
 */

import java.util.*;

public class 할인_행사 {
    public static void main(String[] args) {
        // input data
        String[][] want = {
                {"banana", "apple", "rice", "pork", "pot"},
                {"apple"}
        };
        int[][] number = {
                {3, 2, 2, 2, 1},
                {10}
        };
        String[][] discount = {
                {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"},
                {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
        };

        // output data
        for (int i = 0; i < want.length; i++) {
            System.out.println(solution(want[i], number[i], discount[i]));
        }
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        int days = 0;
        for (int i = 0; i < discount.length; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            if (i >= 9) {
                int count = 0;
                for (int j = 0; j < want.length; j++) {
                    if (map.getOrDefault(want[j], 0) >= number[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == want.length) {
                    days++;
                }
                map.put(discount[i - 9], map.get(discount[i - 9]) - 1);
            }
        }
        return days;
    }
}
