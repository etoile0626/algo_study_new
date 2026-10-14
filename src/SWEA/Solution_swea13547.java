package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    소정이와 세정이는 점심 값을 누가 낼 지 정하기 위해 팔씨름을 하기로 했다. 공정하고 재밌는 경기를 위해 둘은 15번 팔씨름을 하여 8번 이상 이기는 사람이 점심 값을 면제받기로 하였다.
    둘은 지금까지 k번의 팔씨름을 진행했다.
    이 결과는 길이가 k인 ‘o’ 또는 ‘x’로만 구성된 문자열 S[1..k]로 나타낼 수 있다.
    S[i]가 ‘o’면 소정이가 i번째 경기에서 승리했다는 것이고, ‘x’면 패배했다는 것이다.
    소정이는 앞으로 팔씨름을 15번째 경기까지 진행했을 때 자신이 점심값을 면제받을 "가능성"이 있는지 알고자 한다. 이를 대신해 주는 프로그램을 작성하라.
 */

public class Solution_swea13547 {                                       //팔씨름
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int cnt = 0;                                //x갯수

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == 'x'){
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ");

            if(cnt < 8){
                sb.append("YES");
            }else {
                sb.append("NO");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
