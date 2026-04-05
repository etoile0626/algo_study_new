package Programmers;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/*
    너비 w, 높이 h의 사각형 모양의 블록이 있을 때, blocks 배열안의 값을 반드시 모두 방문하는 최소 거리를 구하고자 함.
    *왔던 곳을 돌아갈 수 있음, 가장 왼쪽 위부터 1번 2번, 3번,,, 순으로 번호 부여
 */

public class Solution_Pro_exam1 {                            //최단 경로 구하기
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1 ,0, 0};
    static int[][] map;

    public class Tmp{
        int[] arr;
        HashSet<Integer> set;

        public Tmp(int[] arr, HashSet<Integer> set){
            this.arr = arr;
            this.set = set;
        }
    }

    public int bfs(int w, int h, int[] blocks){
        Queue<Tmp> q = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < blocks.length; i++){
            set.add(blocks[i]);
        }

        q.offer(new Tmp(new int[] {0, 0, 0}, set));

        while(!q.isEmpty()){
            Tmp tmp = q.poll();
            int[] t_arr = tmp.arr;
            int num = map[t_arr[0]][t_arr[1]];
            HashSet<Integer> t_set = new HashSet<>(tmp.set);                        //이렇게 복사해서 안 쓰면 같은 set을 건드려서 결과가 안나옴 반드시 새로 생성자에 넣을 것!

            if(t_set.contains(num)){
                t_set.remove(num);
            }

            if(t_set.isEmpty()){
                return t_arr[2];
            }

            for(int d = 0; d < 4; d++){
                int ni = t_arr[0] + di[d];
                int nj = t_arr[1] + dj[d];

                if(0 <= ni&&ni < h && 0 <= nj&&nj < w){
                    q.offer(new Tmp(new int[] {ni, nj, t_arr[2] + 1}, t_set));
                }
            }
        }

        return -1;
    }

    public class Solution {
        public int solution(int w, int h, int[] blocks) {
            int answer = 0;
            map = new int[h][w];
            int num = 1;

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    map[i][j] = num++;
                }
            }

            answer = bfs(w, h, blocks);

            return answer;
        }
    }
}
