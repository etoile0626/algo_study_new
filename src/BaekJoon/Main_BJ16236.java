package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    n*n 크기의 공간에 물고리 m마리와 아기 상어 1마리가 존재.
    아기 상어와 물고리는 모두 크기를 가짐. 자연수, 아기 상어의 초기값은 2
    자기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 내 크기보다 작은 물고기만 먹을 수 있음. 크기가 같다면, 먹진 못해도 지나가는건 됨
    아기 상어의 이동법
    1. 먹을 수 있는 물고기가 공간에 없으면 엄마 상어에게 도움요청    (탈출 조건)
    2. 먹을 수 있는 물고기가 1마리라면 먹음
    3. 1마리보다 많으면, 거리가 가장 가까운 물고기 먹음
        3-1. 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동 시, 지나야하는 칸의 최솟값인 경우를 의미
        3-2. 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기, 그 중에서도 가장 왼쪽에 있는 물고기를 먹기
    자신의 크기와 같은 수 만큼 물고기를 먹으면 크기가 1 증가할 때, 몇 초동안 엄마에게 도움을 요청하지 않고 물고기를 먹을 수 있는지 구하기
    * 0 = 빈칸, 1, 2, 3, 4, 5, 6 = 칸에 있는 물고기의 크기, 9 = 아기 상어
    * 2 <= n <= 20
 */

public class Main_BJ16236 {                     //아기 상어

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] arr;
    static int n, size, cnt, time, r, c;

    static boolean bfs(){
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c, 0});
        visited[r][c] = true;

        int foundFeed = -1;                             //가장 가까운 거리의 먹이를 찾은 거리
        int ni = -1;
        int nj = -1;                                    //가까운 애들 중 가장 왼쪽 위에 있을 먹이의 위치 (상어가 먹을 먹이의 위치)
        while (!q.isEmpty()){
            int[] ij = q.poll();
            int i = ij[0];
            int j = ij[1];
            int dis = ij[2];
            
            //이미 물고기의 위치를 고르고 최소 거리를 넘어갔다면 탈출
            if(foundFeed != -1 && dis > foundFeed){
                break;
            }

            //먹을 수 있는 물고기면 후보 갱신
            if(arr[i][j] != 0 && arr[i][j] < size){
                if(foundFeed == -1){
                    foundFeed = dis;                    //최초 발견 거리 고정
                }
                
                //최초 발견이거나 이미 발견한것보다 더 위쪽에 있거나 행이 같은 경우 열값이 더 적은 경우 선택
                if((ni == -1 && nj == -1)|| i < ni || (i == ni && j < nj)){
                    ni = i;
                    nj = j;
                }
                continue;                               //같은 거리의 다른 후보도 확인
            }

            for(int d = 0; d < 4; d++){
                int di = i + dx[d];
                int dj = j + dy[d];

                if(0 <= di&&di < n && 0 <= dj&&dj < n && !visited[di][dj] && arr[di][dj] <= size){
                    visited[di][dj] = true;
                    q.offer(new int[] {di, dj, dis + 1});
                }
            }
        }

        //조건에 맞는 값이 없으면 종료
        if(foundFeed == -1){
            return false;
        }

        //배열 갱신
        arr[r][c] = 0;
        r = ni;
        c = nj;                      //아기 상어 위치 변경
        arr[r][c] = 0;               //이동한 곳 물고기도 먹음

        cnt++;
        time += foundFeed;          //시간 갱신

        if(cnt == size){
            size++;
            cnt = 0;
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        r = 0;
        c = 0;                                                          //아기 상어 위치

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 9){
                    r = i;
                    c = j;
                }
            }
        }

        time = 0;                               //걸리는 시간
        cnt = 0;                                //물고기 먹는 횟수
        size = 2;
        while (true){
            boolean flag = bfs();

            if(!flag){
                break;
            }
        }

        System.out.println(time);
    }
}
