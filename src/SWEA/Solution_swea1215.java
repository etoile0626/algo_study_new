package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    회문 = 앞으로 읽으나 뒤로 읽으나 같은 글자 / 스위스, 기러기 등
    8x8 평면 글자판에서 제시된 길이를 가진 회문의 개수 구하기.
    *ABA도 회문이며, ABBA도 회문이다. A 또한 길이 1짜리 회문
    *가로 또는 세로로 이어진 회문의 개수만 세기.
 */

public class Solution_swea1215 {                //[S/W 문제해결 기본] 3일차 - 회문1

    private static boolean isEqaul(String str){
        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){          //대칭으로 같은지 점검
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            String[] arr = new String[8];

            for(int i = 0; i < 8; i++){
                arr[i] = br.readLine();
            }

            //가로
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8-n+1; j++){
                    StringBuilder row = new StringBuilder();
                    StringBuilder col = new StringBuilder();

                    for(int k = 0; k < n; k++){
                        row.append(arr[i].charAt(j + k));
                        col.append(arr[j + k].charAt(i));
                    }

                    if(isEqaul(row.toString())){
                        cnt++;
                    }

                    if(isEqaul(col.toString())){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
