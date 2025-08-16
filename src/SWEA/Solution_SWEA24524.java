package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 체크포인트를 순서대로 방문해야 레벨을 하나 올릴 수 있는 게임에서
    이벤트를 개최하여 2 ~ n-1번 체크포인트 중 정확히 한 곳은 방문하지 않아도 됨
    이때, 레벨을 올리기 위해 이동해야할 거리의 최솟값을 구하기
    *Xi = i 번째 체크포인트의 좌표
    *i번째 체크포인트와 j번째 체크포인트로 가기 위한 거리 = |Xi-Xj|
 */
public class Solution_SWEA24524 {                           //레벨업
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] check = new int[n];
            for(int i = 0; i < n; i++){
                check[i] = Integer.parseInt(st.nextToken());
            }

            //기존 통과 시간
            long base = 0;
            for (int i = 0; i < n - 1; i++) {
                base += Math.abs(check[i + 1] - check[i]);
            }

            //하나 절약했을 때의 시간 중 최솟값
            long bestSave = 0;
            for (int k = 1; k < n - 1; k++) {
                long save = Math.abs(check[k] - check[k - 1]) + Math.abs(check[k + 1] - check[k])
                        - Math.abs(check[k + 1] - check[k - 1]);
                if (save > bestSave) {
                    bestSave = save;
                }
            }

            long answer = base - bestSave;
            System.out.println(answer);
        }
    }
}
