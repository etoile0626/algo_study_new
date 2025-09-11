package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    뱀이 사과를 먹으면 뱀 길이가 늘어나고, 벽이나 자기 몸이랑 부딪히면 죽는 게임
    n*n크기 정사각형에서 진행, 몇몇 칸에 사과 존재. 뱀의 시작위치는 맨위 맨좌측(0, 0), 뱀의 시작 길이는 1, 오른쪽을 향하며 시작
    뱀의 이동 규칙
    1. 몸길이를 늘려 머리가 다음 칸에 위치
    2. 벽이나 자기 몸과 부딪히면 게임 종료
    3. 이동한 칸에 사과가 있다면 사과는 없어지고 꼬리는 움직이지 않음. (몸길이 1 증가)
    4. 이동한 칸에 사과가 없으면 몸길이를 줄여 꼬리가 위치한 칸 비워줌. (몸길이 변하지 않음)
    뱀의 이동 경로가 주어질 때, 게임이 끝나는 시간 계산하기
    * 2 <= n <= 100, 0 <= k <= 100, 1 <= l <= 100
 */

public class Main_BJ3190 {                      //뱀

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Snake{
        int time;
        String dir;

        public Snake(int time, String dir){
            this.time = time;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int k = Integer.parseInt(br.readLine());                //사과 갯수
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            arr[r][c] = 1;                                      //1 = 사과
        }

        int l = Integer.parseInt(br.readLine());
        Snake[] snakes = new Snake[l];
        for(int i = 0; i < l; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            snakes[i] = new Snake(time, dir);
        }

        int cnt = 0;                                            //게임 진행 시간
        int d = 0;                                      //게임 초기 뱀 방향(오른쪽)
        int r = 0;
        int c = 0;                                      //뱀 이동 좌표(머리)
        Queue<int[]> q = new ArrayDeque<>();            //뱀 담는 큐
        q.offer(new int[] {r, c});
        arr[r][c] = 2;                                  //2 = 뱀
        int idx = 0;                                    //뱀 이동 배열 인덱스

        while(true){
            int dr = r + dx[d];
            int dc = c + dy[d];                         //머리 뻗을 위치

            cnt++;                                      //시간 증가

            //맵을 벗어나는 경우 게임 종료
            if(dr < 0 || dr >= n || dc < 0 || dc >= n){
                break;
            }

            //내 몸에 닿아도 게임 종료
            if(arr[dr][dc] == 2){
                break;
            }

            //사과가 없으면? -> 꼬리 길이 줄이기
            if(arr[dr][dc] == 0){
                int[] site = q.poll();          //뱀 큐에서 꼬리 빼내고
                arr[site[0]][site[1]] = 0;      //빈 칸으로 만들기
            }

            //뱀 머리 위치 갱신
            arr[dr][dc] = 2;
            q.offer(new int[] {dr, dc});
            r = dr;
            c = dc;

            //방향 전환
            if(idx < l && cnt == snakes[idx].time){
                //왼쪽으로 90도
                if(snakes[idx].dir.equals("L")){
                    if(d == 0){
                        d = 3;
                    } else{
                        d--;
                    }
                }

                //오른쪽으로 90도
                if(snakes[idx].dir.equals("D")){
                    if(d == 3){
                        d = 0;
                    } else{
                        d++;
                    }
                }

                idx++;
            }
        }

        System.out.println(cnt);
    }
}
