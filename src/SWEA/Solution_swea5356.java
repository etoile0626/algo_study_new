package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다.
    세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 다음에 두 번째 글자들을 세로로 읽는다.
    이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
    세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다.
    칠판에 붙여진 단어들이 주어질 때, 의석이가 세로로 읽은 순서대로 글자들을 출력하기.
 */

public class Solution_swea5356 {                    //의석이의 세로로 말해요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String[] arr = new String[5];
            StringBuilder answer = new StringBuilder();

            for(int i = 0; i < 5; i++){
                arr[i] = br.readLine();
            }

            int max = 0;
            for(int i = 0; i < 5; i++){
                max = Math.max(max, arr[i].length());
            }

            for(int idx = 0; idx < max; idx++) {
                for (int i = 0; i < 5; i++) {
                    if (idx < arr[i].length()) {
                        answer.append(arr[i].charAt(idx));
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(answer.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
