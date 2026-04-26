package BaekJoon;

/*
    N개의 정수로 이루어진 배열 A가 주어진다.
    이때, 배열에 들어있는 '정수의 순서를 적절히 바꿔서' 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
    |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ10819 {                                          //차이를 최대로
    static int n, answer;
    static boolean[] visit;
    static List<Integer> list;

    static void dfs(int prev, int sum, int cnt) {
        // 값의 차를 n-1번만큼 더했을 경우 최댓값 비교 후 리턴
        if (cnt == n - 1) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }

        // 체크하지 않은 부분이면 prev와의 차이만큼 sum에 더함
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int curr = list.get(i);
                visit[i] = true;

                sum += Math.abs(prev - curr);
                dfs(curr, sum, cnt + 1);
                sum -= Math.abs(prev - curr);

                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++){
            visit[i] = true;
            dfs(list.get(i),0,0);
            visit[i] = false;
        }

        System.out.println(answer);
    }
}
