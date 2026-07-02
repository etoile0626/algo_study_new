package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
    100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하기.
    ex)ABA도 회문이며, ABBA도 회문이다. A또한 길이 1짜리 회문이다.
    *가로, 세로 각각에 대해서 직선으로만 판단한다.
 */

public class Solution_swea1216 {                                //[S/W 문제해결 기본] 3일차 - 회문2

    //가로 펠린드롬 검사
    private static boolean isRowPalindrome(char[][] arr, int row, int start, int len){
        int left = start;
        int right = start + len - 1;

        while (left < right) {
            if (arr[row][left] != arr[row][right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    //세로 펠린드롬 검사
    private static boolean isColPalindrome(char[][] arr, int col, int start, int len){
        int left = start;
        int right = start + len - 1;

        while (left < right) {
            if (arr[left][col] != arr[right][col]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());                              //테스트 케이스 번호 입력

            char[][] arr = new char[100][100];
            int len = 1;
            boolean found = false;

            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            //펠린드롬 검사
            for (int l = 100; l >= 1; l--) {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - l; j++) {
                        if (isRowPalindrome(arr, i, j, l) || isColPalindrome(arr, i, j, l)) {
                            len = Math.max(l, len);
                            found = true;
                            break;
                        }
                    }
                }

                if(found) {
                    break;
                }
            }

            if(t < 10) {
                sb.append("#").append(T).append(" ").append(len).append("\n");
            } else {
                sb.append("#").append(T).append(" ").append(len);           //마지막에 줄바꿈 잇으니까 틀리더라 ㅎ...
            }
        }

        System.out.println(sb.toString());
    }
}
