package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea6109 {                            //추억의 2048게임
    //다시 풀기, move와 merge 로직에 염두하기.
    static int d;                                       //방향 정하기 용도
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};                   //left, right, up, down 순

    // d 방향에 맞춰 각 행(left/right) 또는 열(up/down)에 압축+병합 적용
    static void move(int[][] arr, int n) {
        // d 방향 기준, 벽 쪽 인덱스부터 훑도록 진행 방향(step)을 구함
        // left: dy=-1 -> step=1, right: dy=1 -> step=-1, up: dx=-1 -> step=1, down: dx=1 -> step=-1
        int step = (d == 0 || d == 1) ? -dy[d] : -dx[d];
        // 벽에 해당하는 시작 인덱스 (step이 +1이면 0번, -1이면 n-1번이 벽)
        int start = (step == 1) ? 0 : n - 1;

        if (d == 0 || d == 1) {                 // left, right : 행 단위 처리
            for (int i = 0; i < n; i++) {
                int[] line = new int[n];
                for (int j = 0; j < n; j++) {
                    line[j] = arr[i][j];
                }
                line = compactAndMerge(line, start, step);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = line[j];
                }
            }
        } else {                                // up, down : 열 단위 처리
            for (int j = 0; j < n; j++) {
                int[] line = new int[n];
                for (int i = 0; i < n; i++) {
                    line[i] = arr[i][j];
                }
                line = compactAndMerge(line, start, step);
                for (int i = 0; i < n; i++) {
                    arr[i][j] = line[i];
                }
            }
        }
    }

    // start에서 시작해 step 방향으로 훑으며 0을 제거(압축)하고, 벽 쪽부터 동일한 값을 1회만 병합
    static int[] compactAndMerge(int[] line, int start, int step) {
        int n = line.length;

        int[] values = new int[n];
        int cnt = 0;
        for (int k = 0, idx = start; k < n; k++, idx += step) {
            if (line[idx] != 0) {
                values[cnt++] = line[idx];
            }
        }

        int[] merged = new int[n];
        int mCnt = 0;
        int k = 0;
        while (k < cnt) {
            if (k + 1 < cnt && values[k] == values[k + 1]) {
                merged[mCnt++] = values[k] * 2;
                k += 2;
            } else {
                merged[mCnt++] = values[k];
                k += 1;
            }
        }

        int[] result = new int[n];
        for (int i = 0, idx = start; i < n; i++, idx += step) {
            result[idx] = (i < mCnt) ? merged[i] : 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String order = st.nextToken();

            if(order.equals("left")){
                d = 0;
            } else if(order.equals("right")){
                d = 1;
            } else if(order.equals("up")){
                d = 2;
            } else if(order.equals("down")){
                d = 3;
            }

            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            move(arr, n);

            sb.append("#").append(t).append("\n");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
