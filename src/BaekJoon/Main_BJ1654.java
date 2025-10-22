package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 랜선을 만들려고 하는데, 이미 길이가 제각각인 k개의 랜선이 존재.
    랜선을 모두 n개의 같은 길이의 랜선으로 만들고자 k개의 랜선을 잘라서 만드려고 함.
    n개보다 많이 만드는 것도 n개를 만드는 것에 포함된다고 할 때, 만들 수 있는 최대 랜선 길이 구하기.
 */

public class Main_BJ1654 {                      //랜선 자르기
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        long max = 0;                                       //k개의 랜선 중 최대 길이

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;                                  //0이면 에러 터짐
        long right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;                               //만들 수 있는 랜선의 개수

            for (long num : arr) {
                cnt += num / mid;                       //만들 수 있는 랜선 개수 구하기
            }

            if (cnt >= n) {                             //n개를 넘어가면 조건을 만족했으므로 길이 늘려서 최댓값 탐색하기
                answer = mid;
                left = mid + 1;
            } else {                                    //조건을 만족하지 못했으면 길이 줄이기
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
