package Algorithm05_트리;

/**
 * 출처 : 코딩 테스트 완전 정복 - 문제 27 다단계_칫솔_판매
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
            calculate(referral, result, idx, seller[i], amount[i] * 100);
        }
        return result;
    }

    public static void calculate(String[] referral, int[] result, Map<String, Integer> idx, String seller, int amount) {
        if (seller.equals("-")) {
            return;
        }
        result[idx.get(seller)] += amount - amount / 10;
        String nextSeller = referral[idx.get(seller)];
        calculate(referral, result, idx, nextSeller, amount / 10);
    }
}
