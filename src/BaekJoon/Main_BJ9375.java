package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ9375 {                      //패션왕 신해빈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());	// 테스트 케이스

        while (t -- > 0) {

            HashMap<String, Integer> hm = new HashMap<>();	// <종류, 개수>

            int n = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");

                st.nextToken();	// 옷 이름은 필요 없음

                String kind = st.nextToken();	// 옷 종류

                if (hm.containsKey(kind)) {         //해당 종류의 옷이 있으면
                    hm.put(kind, hm.get(kind) + 1); //개수 1 증가
                }
                else {                              //없으면 추가
                    hm.put(kind, 1);
                }
            }

            int result = 1;

            for (int val : hm.values()) {
                result *= (val + 1);                //안 입을 경우 1가지를 추가해서 결과에 반영
            }

            sb.append(result - 1).append('\n');     //알몸인 경우 1가지 제외

        }
        System.out.println(sb);
    }
}
