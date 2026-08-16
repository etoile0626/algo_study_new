package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    카드를 퍼펙트 셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것을 의미.
    *abcdef -> adbecf
    N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하기.
    *N이 홀수이면, 교대로 놓을 때 먼저 놓는 쪽에 한 장이 더 들어가게 하면 된다.
    **abcdefg -> aebfcgd?
    *1 <= n <= 1000
    *카드의 이름은 알파벳 대문자와 ‘-’만으로 이루어져 있으며, 길이는 80이하.
 */

public class Solution_swea3499 {                        //퍼펙트 셔플
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = st.nextToken();
            }

            StringBuilder shuffle = new StringBuilder();

            if(n % 2 == 0) {
                for (int i = 0; i < n / 2; i++) {
                    shuffle.append(" ").append(arr[i]).append(" ").append(arr[i + n / 2]);
                }
            }
            else if(n % 2 == 1){
                for (int i = 0; i < n / 2; i++) {
                    shuffle.append(" ").append(arr[i]).append(" ").append(arr[i+1 + n / 2]);
                }

                shuffle.append(" ").append(arr[n/2]);
            }

            sb.append("#").append(t).append(shuffle.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
