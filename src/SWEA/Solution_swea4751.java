package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문자열이 “D”라면 주위를 ‘#’로 이루어진 다이아몬드로 감싸서 다음과 같이 5x5크기로 장식한다.
    빈 곳은 ‘.’로 표시한다.
    만약 문자열의 길이가 1보다 더 크면, 인접한 문자는 ‘#’과 ‘.’을 공유하여 장식한다.
    예를 들어 문자열이 “APPLE”이면 다음과 같이 장식한다.
    ..#...#..
    .#.#.#.#.
    #.A.#.P.#
    ..#...#..
    주어진 문자열을 장식하기.
 */

public class Solution_swea4751 {                            //다솔이의 다이아몬드 장식
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T= Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            String[] arr = new String[3];
            for(int i = 0; i < 3; i++){
                arr[i] = "";
            }

            for(int i = 0; i < str.length(); i++){
                arr[0] += "..#.";
                arr[1] += ".#.#";
                arr[2] += ("#." + str.charAt(i)+".");
            }

            sb.append(arr[0]).append(".").append("\n")
                    .append(arr[1]).append(".").append("\n")
                    .append(arr[2]).append("#").append("\n")
                    .append(arr[1]).append(".").append("\n")
                    .append(arr[0]).append(".").append("\n");
        }

        System.out.println(sb.toString());
    }
}
