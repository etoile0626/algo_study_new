package Programmers;

public class Solution_Pro133502 {                   //햄버거 만들기
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < ingredient.length; i++) {
                sb.append(ingredient[i]);

                //sb의 길이가 4 이상이고, 마지막 4개의 재료가 빵-야채-고기-빵인 경우
                if (sb.length() > 3 && sb.substring(sb.length() - 4, sb.length()).equals("1231")) {
                    answer++;
                    sb.delete(sb.length() - 4, sb.length());        //마지막 4개의 재료 삭제
                }
            }

            return answer;
        }
    }
}
