package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    암호코드에서의 숫자 하나는 7개의 비트로 암호화되어 주어진다. 따라서 암호코드의 가로 길이는 56.
    올바른 암호코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수가 되어야 한다.
    ex) 암호코드가 88012346일 경우,
    ( ( 8 + 0 + 2 + 4 ) x 3 ) + ( 8 + 1 + 3 + 6) = 60은 10의 배수이므로 올바른 암호코드다.
    ex) 암호코드가 19960409일 경우,
    ( ( 1 + 9 + 0 + 0 ) x 3 ) + ( 9 + 6 + 4 + 9) = 58은 10의 배수가 아니므로 잘못된 암호코드다.
    암호코드 1개가 포함된 직사각형 배열을 읽는다.
    직사각형 배열은 1, 0으로만 이루어져 있고, 암호코드 이외의 부분은 전부 0으로 주어진다.
    암호코드 정보가 포함된 2차원 배열을 입력으로 받아 올바른 암호코드인지 판별하기.
 */

public class Solution_swea1240 {            //[S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
    static String[] nums = {
            "0001101", "0011001", "0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] decimalNum = new int[8];

            String str = "";
            String sub = "";
            String tmp = "";
            boolean flag = false;

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                for (int j = m - 1; j >= 0 && !flag; j--) {
                    if (str.charAt(j) == '1') {                 //암호 코드 위치 찾으면 저장하고 탈춡
                        sub = str.substring(j - 55, j + 1);
                        flag = true;
                    }
                }
            }

            for (int i = 0; i < sub.length(); i = i + 7) {
                tmp = sub.substring(i, i + 7);

                for (int j = 0; j < nums.length; j++) {
                    if (tmp.equals(nums[j])) {
                        decimalNum[cnt++] = j;
                    }
                }
            }

            int answer = (decimalNum[0] + decimalNum[2] + decimalNum[4] + decimalNum[6]) * 3
                    + decimalNum[1] + decimalNum[3] + decimalNum[5] + decimalNum[7];

            if (answer % 10 == 0) {
                answer = 0;

                for (int j = 0; j < 8; j++) {
                    answer += decimalNum[j];
                }
            } else {
                answer = 0;
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
