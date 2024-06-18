package Algorithm06_집합;

/**
 * 출처 : 프로그래머스 - 12981, 영어 끝말잇기
 * 일시 : 24.06.14(금)
 * 풀이 시간 : 0분
 */

import java.util.*;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        // input data
        int[] n = {
                3,
                5,
                2
        };
        String[][] words = {
                {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
                {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
                {"hello", "one", "even", "never", "now", "world", "draw"}
        };

        // output data
        for (int i = 0; i < n.length; i++) {
            System.out.println(Arrays.toString(
                    new 영어_끝말잇기().solution(n[i], words[i])
            ));
        }
    }

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char preLastChar = words[i-1].charAt(words[i-1].length() - 1);
            char nowFirstChar = words[i].charAt(0);
            if (preLastChar != nowFirstChar || set.contains(words[i])) {
                return new int[] {i % n + 1, i / n + 1};
            }
            set.add(words[i]);
        }
        return new int[] {0, 0};
    }
}
