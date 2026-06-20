package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    주어지는 번호 K부터 1씩 증가하며 비밀번호 P를 확인해 볼 생각이다.
    예를 들어 비밀번호 P가 123 이고 주어지는 번호 K가 100 일 때, 100부터 123까지 24번 확인하여 비밀번호를 맞출 수 있다.
    P와 K가 주어지면 K부터 시작하여 몇 번 만에 P를 맞출 수 있는지 구하기.
 */

public class Solution_swea2043 {                            //서랍의 비밀번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(p-k+1);
    }
}
