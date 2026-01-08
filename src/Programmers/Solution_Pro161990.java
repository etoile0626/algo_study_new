package Programmers;

/*
    바탕화면의 상태를 나타낸 문자열 wallpaper가 주어짐
    빈칸은 . / 파일은 #
    드래그를 통해 파일 선택, 삭제 가능
    최소한의 이동거리를 가지는 드래그를 통해 파일을 한 번에 지우려고 함
    *드래그의 시작점과 끝점까지의 이동거리를 의미, |x2 - x1| + |y2 - y1|로 정의
    출력은 정수배열[x1, y1, x2, y2]의 형태로 출력
*/

public class Solution_Pro161990 {                   //바탕화면 정리
    class Solution {
        public int[] solution(String[] wallpaper) {
            int r = wallpaper.length;
            int c = wallpaper[0].length();

            int x1 = Integer.MAX_VALUE;
            int y1 = Integer.MAX_VALUE;
            int x2 = 0;
            int y2 = 0;

            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    char tmp = wallpaper[i].charAt(j);
                    if(tmp == '#'){
                        x1 = Math.min(x1, i);
                        y1 = Math.min(y1, j);
                        x2 = Math.max(x2, i);
                        y2 = Math.max(y2, j);
                    }
                }
            }

            int[] answer = {x1, y1, x2 + 1, y2 + 1};            //좌표 형태라서 줄 하나 더 있다고 생각?
            return answer;
        }
    }
}
