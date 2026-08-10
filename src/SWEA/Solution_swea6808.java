package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.
    한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.
    한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.
    높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
    낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
    이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
    두 사람의 총점이 같으면 무승부이다.
    규영이가 내는 카드의 순서를 고정하면, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하기.
 */

public class Solution_swea6808 {                                    //규영이와 인영이의 카드게임
    static int[] gyu;
    static int[] inyoung;
    static boolean[] selected;
    static int win;
    static int lose;

    static void dfs(int cnt, int gyuScore, int inyoungScore){
        if(cnt == 9){
            if(gyuScore > inyoungScore) {
                win++;
            } else {
                lose++;
            }

            return;
        }

        for(int i = 0; i < 9; i++){
            if(selected[i]) {
                continue;
            }

            selected[i] = true;

            int score = gyu[cnt] + inyoung[i];

            if(gyu[cnt] > inyoung[i]){
                dfs(cnt + 1, gyuScore + score, inyoungScore);
            } else {
                dfs(cnt + 1, gyuScore, inyoungScore + score);
            }

            selected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            gyu = new int[9];
            inyoung = new int[9];
            selected = new boolean[9];
            boolean[] used = new boolean[19];
            win = 0;
            lose = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9; i++){
                gyu[i] = Integer.parseInt(st.nextToken());
                used[gyu[i]] = true;
            }

            int idx = 0;
            for(int card = 1; card <= 18; card++){
                if(!used[card]){
                    inyoung[idx++] = card;
                }
            }

            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb.toString());
    }
}
