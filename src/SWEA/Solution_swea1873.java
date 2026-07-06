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
    static int h, w, n, x, y;
    static char[][] arr;

    //전차의 명령 수행 함수
    private static void moving(char c){
        if(c == 'S') {
            shooting(arr[x][y]);
        }
        else if(c == 'U') {
            arr[x][y] = '^';

            int nx = x - 1;
            if (0 <= nx && nx < h && arr[nx][y] == '.') {
                arr[x][y] = '.';
                x = nx;
                arr[x][y] = '^';
            }
        }
        else if(c == 'D') {
            arr[x][y] = 'v';

            int nx = x + 1;
            if(0 <= nx&&nx < h && arr[nx][y] == '.'){
                arr[x][y] = '.';
                x = nx;
                arr[x][y] = 'v';
            }
        }
        else if(c == 'L') {
            arr[x][y] = '<';

            int ny = y - 1;
            if (0 <= ny && ny < w && arr[x][ny] == '.') {
                arr[x][y] = '.';
                y = ny;
                arr[x][y] = '<';
            }
        }
        else if(c == 'R') {
            arr[x][y] = '>';
            
            int ny = y + 1;
            if (0 <= ny && ny < w && arr[x][ny] == '.') {
                arr[x][y] = '.';
                y = ny;
                arr[x][y] = '>';
            }
        }
    }

    //총알이 벽을 부수는지 검증하는 메서드
    private static void shooting(char c){
        if(c == '^'){
            for(int i = x - 1; i >= 0; i--){
                if(arr[i][y] == '#'){
                    break;
                } else if(arr[i][y] == '*'){
                    arr[i][y] = '.';
                    break;
                }
            }
        } else if(c == 'v'){
            for(int i = x + 1; i < h; i++){
                if(arr[i][y] == '#'){
                    break;
                } else if(arr[i][y] == '*'){
                    arr[i][y] = '.';
                    break;
                }
            }
        } else if(c == '<'){
            for(int j = y - 1; j >= 0; j--){
                if(arr[x][j] == '#'){
                    break;
                } else if(arr[x][j] == '*'){
                    arr[x][j] = '.';
                    break;
                }
            }
        } else if(c == '>'){
            for(int j = y + 1; j < w; j++){
                if(arr[x][j] == '#'){
                    break;
                } else if(arr[x][j] == '*'){
                    arr[x][j] = '.';
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            x = 0;
            y = 0;                                          //현재 탱크의 위치

            for(int i = 0; i < h; i++){
                String str = br.readLine();
                for(int j = 0; j < w; j++){
                    arr[i][j] = str.charAt(j);

                    if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' ||arr[i][j] == '>'){
                        x = i;
                        y = j;
                    }
                }
            }

            n = Integer.parseInt(br.readLine());
            String order = br.readLine();

            for(int i = 0; i < n; i++){
                char c = order.charAt(i);

                moving(c);
            }

            //출력
            sb.append("#").append(t).append(" ");
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    sb.append(arr[i][j]);
                }

                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
