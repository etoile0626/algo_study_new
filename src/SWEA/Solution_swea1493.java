package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    제 1사분면 위의 격자점 (x,y)에 위 그림과 같이 대각선 순서로 점에 수를 붙인다.
    ex) #(1,1) = 1, #(2,1)=3, #(2,2) = 5, #(4,4) = 25 *오른쪽 아래 대각선 방향순으로 숫자 부여
    반대로 수 p가 할당된 점을 &(p)로 나타낸다.
    ex) &(1) = (1,1), &(3) = (2,1), &(5) = (2,2), &(25) = (4,4)
    점 (x,y)와 점 (z,w)를 더하면 점 (x+z, y+w)가 된다.
    p★q는 #(&(p)+&(q))으로 나타낼때, p*q 구하기.
    *&(1)=(1,1), &(5) = (2,2)이므로, 1★5 = #(&(1)+&(5)) = #((1,1)+(2,2)) = #(3,3) = 13
 */

public class Solution_swea1493 {                        //수의 새로운 연산
    //다시 풀어보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());


            //대각선에 위치한 점의 개수 -> 1, 2, 3, 4, 5, ...k 개 => k번째 대각선의 마지막 번호 = 1부터 K까지 더한 값
            //p가 몇번째 대각선에 위치해 있는지 구하기
            int k1 = 1;
            while (k1 * (k1 + 1) / 2 < p) {
                k1++;
            }

            //q가 몇번째 대각선에 위치해 있는지 구하기
            int k2 = 1;
            while (k2 * (k2 + 1) / 2 < q) {
                k2++;
            }

            int diff1 = p - (((k1-1)*k1 / 2) + 1);              //k1번째 대각선 시작번호로부터 얼마나 떨어져 있는가 구하기
            int x1 = diff1 + 1;
            int y1 = k1 - diff1;

            int diff2 = q - (((k2-1)*k2 / 2) + 1);
            int x2 = diff2 + 1;
            int y2 = k2 - diff2;

            int x3 = x1 + x2;
            int y3 = y1 + y2;
            int k3 = x3 + y3 - 1;                       //새로 구한 좌표가 몇번째 대각선에 위치해 있는지
            int num = ((k3-1) * k3 / 2) + x3;           //k3-1번째 대각선 마지막 번호에서 x3번 다음 번호가 새로 구할 수

            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
