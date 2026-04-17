package BaekJoon;

/*
    N×N인 격자로 나누어진 모래밭에서 토네이도를 연습하고자 함.
    *위치 (r, c)는 격자의 r행 c열을, A[r][c]는 (r, c)에 있는 모래의 양
    격자의 가운데 칸부터 토네이도의 이동이 시작, 토네이도는 한 번에 한 칸 이동.
    토네이도가 한 칸 이동하면, 모래가 일정한 비율로 흩날리게 됨.(문제의 그림 참고)
        *토네이도가 x에서 y로 이동하면, y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동
        *α로 이동하는 모래의 양은 비율이 적혀있는 칸으로 이동하지 않은 남은 모래의 양(55%)
        *모래가 이미 있는 칸으로 모래가 이동하면, 모래의 양은 더해진다.
    토네이도가 소멸되었을 때, 격자의 밖으로 나간 모래의 양을 구하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ20057 {                         //마법사 상어와 토네이도
    //다시 풀기

    static int n;
    static int[][] map;
    static int[] dx = {0,1,0,-1};   //토네이토의 x 이동 방향
    static int[] dy = {-1,0,1,0};   //토네이토의 y 이동 방향
    static int[] dc = {1,1,2,2};   // 토네이도의 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};

    //현재위치에서 이동 -> 이동한 위치의 모래 뿌리기 -> 이동한위치를 현재위치로 업데이트
    static int calculateOutSand(int x, int y){
        int totalOutSand = 0;

        int currentX = x;
        int currentY = y;

        while (true) {
            for(int d = 0; d<4; d++){
                for(int moveCount = 0; moveCount<dc[d]; moveCount++){
                    //현재위치에서 이동
                    int nextX = currentX+dx[d];
                    int nextY = currentY+dy[d];

                    if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n){
                        return totalOutSand;
                    }

                    //이동한 위치의 모래 뿌리기
                    int sand = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                    int spreadTotal = 0;


                    for(int spread = 0; spread<9; spread++){
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spreadAmount = (sand*sandRatio[spread])/100;

                        if(sandX < 0 || sandX >= n || sandY < 0 || sandY >= n){
                            totalOutSand += spreadAmount;
                        }
                        else{
                            map[sandX][sandY]+=spreadAmount;
                        }
                        spreadTotal+= spreadAmount;
                    }

                    //알파
                    int alphaX = nextX+dx[d];
                    int alphaY = nextY+dy[d];
                    int alphaAmount = sand -spreadTotal;
                    if(alphaX < 0 || alphaX >= n || alphaY < 0 || alphaY >= n){
                        totalOutSand +=alphaAmount;
                    }
                    else{
                        map[alphaX][alphaY] +=alphaAmount;
                    }


                    //이동한 위치를 현재위치로 업데이트
                    currentX = nextX;
                    currentY = nextY;
                }
            }

            //횟수 업데이트
            for(int index = 0; index<4; index++){
                dc[index] +=2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine().trim());
        map = new int[n][n];

        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());

            for(int c = 0; c < n; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = calculateOutSand(n/2, n/2);

        System.out.println(result);
    }
}
