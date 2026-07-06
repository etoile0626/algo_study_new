package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하기.
    *전차가 포탄을 발사하면, 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
    *만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
    *강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
    *게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.

    문자	의미
    .	평지(전차가 들어갈 수 있다.)
    *	벽돌로 만들어진 벽
    #	강철로 만들어진 벽
    -	물(전차는 들어갈 수 없다.)
    ^	위쪽을 바라보는 전차(아래는 평지이다.)
    v	아래쪽을 바라보는 전차(아래는 평지이다.)
    <	왼쪽을 바라보는 전차(아래는 평지이다.)
    >	오른쪽을 바라보는 전차(아래는 평지이다.)


    문자	동작
    U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
    D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
    L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
    R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
    S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 */

public class Solution_swea1873 {                            //상호의 배틀필드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


        }
    }
}
