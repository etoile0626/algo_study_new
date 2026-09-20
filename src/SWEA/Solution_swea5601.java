package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    N명의 사람이 1리터의 쥬스를 나누어 각자 잔에 따라서 마시고자 한다.
    첫번째 사람이 원하는 만큼 한잔 따르고, 두번째 사람이 원하는 만큼  한잔 따르고, ..., N번째 사람이 남은만큼 한잔 따른다.
    그 후 N번째 사람이 N개의 잔 중에 하나를 가져가고, N-1번째 사람이 남은 잔 중에 하나를 가져가고, 최종적으로 첫번째 사람이 마지막으로 남은 잔을 가져간다.
    "모든 사람"은 목이 마른 상태이기 때문에, 최대한의 쥬스를 마시고자 최선의 전략을 쓴다고 가정하자.
    또한 이들은 서로 모르기 때문에, 담합 혹은 협력 등은 없다고 가정하자.
    이때 첫번째 사람부터 N번째 사람까지 각각 쥬스를 얼마씩 마시게 되는지 구하도록 하자.
    *쥬스의 양은 정수가 아니기 때문에, 기약분수로 만들어 "p/q" 꼴로 출력하도록 한다.
 */

public class Solution_swea5601 {                                //[Professional] 쥬스 나누기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(t);
            for(int i = 0; i < n; i++) {
                sb.append(" 1/").append(n);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
