package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2980 {                                  //도로와 신호등
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        int curPos = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            time += d - curPos; // 다음 위치 까지 가는데 걸리는 시간
            curPos = d; // 위치 이동

            int section = time % (r + g); // 신호등 사이클 확인
            if (section < r) // 빨간불 구간
                time += r - section;
        }

        // 남은 신호등 거리 계산 포함
        System.out.println(time + len - curPos);
    }
}
