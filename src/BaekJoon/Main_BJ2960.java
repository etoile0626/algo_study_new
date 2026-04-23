package BaekJoon;

/*
    에라토스테네스의 체 알고리즘
        1. 2부터 N까지 모든 정수를 적는다.
        2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
        3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
        4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2960 {                                      //에라토스테네스의 체

    //에라토스테네스의 체
    static void primeNumber(int n, int k) {
        int[] arr = new int[n+1];  //n까지 저장된 배열

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue; //이미 지운 수는 건너뛰기

            //배수들 지우기
            for (int j = i; j <= n; j+=i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    k--;

                    //k번째로 지운 수 출력
                    if (k == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        primeNumber(n,k);
    }
}
