package Algorithm02_스택;

/**
 * 출처 : 프로그래머스 - 12909, 올바른 괄호
 * 일시 : 24.06.11(화)
 * 풀이 시간 : 1분
 */

import java.util.*;

public class 올바른_괄호 {
    public static void main(String[] args) {
        // input data
        String[] strings = {
                "()()",
                "(())()",
                ")()(",
                "(()("
        };

        // output data
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i])? "true" : "false");
        }
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
