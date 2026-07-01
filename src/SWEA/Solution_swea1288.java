package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea1288 {                        //새로운 불면증 치료
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            int num = 0;
            boolean[] visited = new boolean[10];

            while (cnt < 10) {
                num += n;
                int tmp = num;
                while(tmp > 0){
                    int number = tmp % 10;
                    tmp = tmp / 10;

                    if (!visited[number]) {
                        visited[number] = true;
                        cnt += 1;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
