package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
    우승자는 주어진 숫자판들 중에 두 개를 선택에서 정해진 횟수만큼 서로의 자리를 위치를 교환할 수 있다.
    예를 들어, 다음 그림과 3, 2, 8, 8, 8 의 5개의 숫자판들이 주어지고 교환 횟수는 2회라고 하자.
    숫자를 두번 바꾸어 88832으로 바꾸고, 이 수만큼 상금을 얻을 수 있다.
    주의할 것은 반드시 횟수만큼 교환이 이루어져야 하고 동일한 위치의 교환이 중복되어도 된다.
    *ex) 94를 2번 교환해서 94로 만들기 가능
    정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액을 계산하기.
    *최대 자릿수는 6자리이며, 최대 교환 횟수는 10번이다.
 */

public class Solution_swea1244 {            //[S/W 문제해결 응용] 2일차 - 최대 상금
    //다시 풀기
    static int n, max;
    static HashSet<String> set;

    private static void dfs(int cnt, String str){
        if(cnt == n){
            max = Math.max(max, Integer.parseInt(str));
            return;
        }

        if(set.contains(str + ":" + cnt)){          //이미 있는 값이면 제외
            return;
        } else{
            set.add(str + ":" + cnt);
        }

        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                char[] arr = str.toCharArray();
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(cnt + 1, new String(arr));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            n = Integer.parseInt(st.nextToken());
            max = 0;
            set = new HashSet<>();

            dfs(0, str);

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
