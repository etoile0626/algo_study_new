package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ6603 {              //로또
    static int n;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb;

    static void bfs(int start, int cnt) {
        if (cnt == 6) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[cnt] = arr[i];
                bfs(i, cnt + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb = new StringBuilder();
            result = new int[6];
            visit = new boolean[n];
            bfs(0, 0);

            System.out.println(sb);
        }

    }
}
