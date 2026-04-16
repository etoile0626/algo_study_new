package BaekJoon;

/*
    n칸으로 나누어진 스크린 아래쪽에 m칸을 차지하는 바구니가 존재.
    게임 하는 중 바구니를 왼쪽이나 오른쪽으로 이동 가능하나, 바구니가 스크린의 경계를 넘어가면 안됨.
    바구니는 스크린 가장 왼쪽 m칸을 차지한채로 시작.
    사과는 n칸 중 한 칸의 상단에서 떨어지기 시작하며, 스크린의 바닥에 닿을때까지 직선으로 떨어짐. 한 사과가 다 떨어지면, 다음 사과가 떨어짐.
    사과를 모두 담으려고 할 때, 바구니의 이동 거리의 최솟값을 구하기.
    *1 ≤ M < N ≤ 10, 1 ≤ 사과의 개수 j ≤ 20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2828 {                                              //사과 담기 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int dist = 0;
        int left = 1;
        int right = m;

        for(int i = 0; i < j; i++){
            int num = Integer.parseInt(br.readLine());          //사과가 떨어지는 위치

            if(num >= left && num <= right) {
                continue;
            } else{
                while(num < left || num > right) {
                    if (num > right) {
                        left++;
                        right++;
                        dist++;
                    } else if (num < left) {
                        left--;
                        right--;
                        dist++;
                    }
                }
            }
        }

        System.out.println(dist);
    }
}
