package Algorithm05_트리;

/**
 * 출처 : 프로그래머스 - 77468, 다단계_칫솔_판매
 * 일시 : 24.06.14(금)
 * 풀이 시간 : 35분
 */

import java.util.*;

public class 다단계_칫솔_판매 {
    public static void main(String[] args) {
        // input data
        String[][] enrolls = {
                {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
        };
        String[][] referrals = {
                {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
        };
        String[][] sellers = {
                {"young", "john", "tod", "emily", "mary"},
                {"sam", "emily", "jaimie", "edward"}
        };
        int[][] amounts = {
                {12, 4, 2, 5, 10},
                {2, 3, 5, 4}
        };

        // output data
        for (int i = 0; i < enrolls.length; i++) {
            System.out.println(Arrays.toString(solution(enrolls[i], referrals[i], sellers[i], amounts[i])));
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            idx.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * 100;
            while (a > 0 && !s.equals("-")) {
                result[idx.get(s)] += a - a / 10;
                s = referral[idx.get(s)];
                a /= 10;
            }
        }
        return result;
    }
}
