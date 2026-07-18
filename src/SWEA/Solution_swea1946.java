package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    원본 문서는 너비가 10인 여러 줄의 문자열.
    문자열은 마지막 줄을 제외하고 빈 공간 없이 알파벳으로 채워져 있고 마지막 줄은 왼쪽부터 채워져 있다.
    압축한 문서는 알파벳과 그 알파벳의 연속된 개수로 이루어진 쌍들이 나열되어 있다. (예 : A 5  =  AAAAA)
    압축된 문서를 입력 받아 원본 문서를 만들기.
    *원본 문서의 너비는 10으로 고정
 */

public class Solution_swea1946 {                    //간단한 압축 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#").append(t).append("\n");

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;                                        //너비체크용

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                for(int j = 0; j < num; j++){
                    sb.append(str);
                    cnt++;

                    if(cnt == 10){
                        sb.append("\n");
                        cnt = 0;
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
