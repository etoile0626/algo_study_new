package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 수로 이뤄진 수열과 n-1개의 연산자 존재
    주어진 수의 순서를 바꾸지 않고 연산자를 수 사이에 넣어 수식을 만들 때, 식의 결과가 최대인 것과 최소인 것을 구하기
    *연산자 우선순위는 무시
    *나눗셈은 정수 나눗셈으로 몫만 취하기
    *음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 음수로 바꾸기
 */

public class Main_BJ14888 {                             //연산자 끼워넣기

    static int n, min, max;
    static int[] arr, oper;

    static void dfs(int idx, int value){
        if(idx == n){                           //모든 숫자를 쓰면
            max = Math.max(max, value);
            min = Math.min(min, value);

            return;
        }

        for(int d = 0; d < 4; d++) {
            int next = 0;

            if(oper[d] > 0) {
                if (d == 0) {
                    next = value + arr[idx];
                } else if (d == 1) {
                    next = value - arr[idx];
                } else if (d == 2) {
                    next = value * arr[idx];
                } else {
                    if (value < 0) {
                        next = value * -1;
                        next /= arr[idx];
                        next *= -1;
                    } else {
                        next = value / arr[idx];
                    }
                }

                oper[d]--;
                dfs(idx + 1, next);
                oper[d]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        arr = new int[n];
        oper = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);             //초기화 값으로 0번 인덱스 값 넣고 1번 인덱스부터 탐색 시작

        System.out.println(max);
        System.out.println(min);
    }
}
