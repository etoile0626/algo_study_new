package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    단어 수학 문제는 n개의 알파벳 대문자로 이루어져있다. 알파벳 대문자를 0부터 9까지 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제를 풀고자 함.
    같은 알파벳은 같은 숫자로, 두 개 이상의 알파벳이 같은 숫자로 바뀔 수는 없음
    N개의 단어가 주어질 때, 그 수의 합을 최대로 만드는 프로그램 구하기
    1 <= N <= 10, 단어의 알파벳은 최대 10개, 수의 최대 길이는 8
 */

public class Main_BJ1339 {                              //단어 수학
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] cnt = new int[26];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            int tmp = (int)Math.pow(10, arr[i].length()-1);             //arr[i] 문장의 자릿수

            for (int j = 0; j < arr[i].length(); j++){
                cnt[(int)arr[i].charAt(j) - 'A'] += tmp;                //알파벳의 위치에 자릿수 값 더해주기
                tmp /= 10;
            }
        }

        Arrays.sort(cnt);                                               //값이 가장 많은 순으로 정렬
        int idx = 9;
        int answer = 0;

        for(int i = cnt.length - 1; i >= 0; i--){
            if(cnt[i] == 0){
                break;
            }

            answer += cnt[i] * idx;                                     //값이 가장 많은 애(단어 중 가장 자릿수가 큰 애 + 많이 나온)부터 9부터 순서대로 부여
            idx--;
        }

        System.out.println(answer);
    }
}
