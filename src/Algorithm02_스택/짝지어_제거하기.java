package Algorithm02_스택;

/**
 * 출처 : 프로그래머스 - 12973, 짝지어 제거하기
 * 일시 : 24.06.12(수)
 * 풀이 시간 : 1분
 */

import java.util.*;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        // input data
        String[] strings = {
                "baabaa",
                "cdcd",
        };

        // output data
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
