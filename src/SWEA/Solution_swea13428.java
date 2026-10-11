package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    9자리 이하의 음이 아닌 정수 N이 있다.
    이 수에서 한 쌍의 숫자를 골라 그 위치를 바꾸는 일을 최대 한 번 하여(안 하거나, 한 번만 하여) 새로운 수 M을 만들 수 있다.
    *단, 바꾼 결과 M의 맨 앞에 ‘0’이 나타나면 안 된다.
    M의 최솟값과 최댓값을 구하는 프로그램을 작성하라.
 */

public class Solution_swea13428 {                       //숫자 조작
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int min = Integer.parseInt(str);
            int max = Integer.parseInt(str);
            char[] c = str.toCharArray();

            for(int i = 0; i < c.length; i++){
                for(int j = i + 1; j < c.length; j++){
                    if(i == 0 && c[j] == '0') continue;     //맨 앞이 0이 되는 교환은 금지

                    //자리 변경
                    char tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;

                    int v = Integer.parseInt(new String(c));
                    min = Math.min(min, v);
                    max = Math.max(max, v);

                    //비교 후 원상복구
                    tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                }
            }

            sb.append("#").append(t).append(" ").append(min).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
