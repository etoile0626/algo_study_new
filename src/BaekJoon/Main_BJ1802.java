package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    동호가 종이를 접는 방법은 2가지가 존재.
    1. 오른쪽 반을 반시계 방향으로 접어 왼쪽 반의 위로 접기
    2. 오른쪽 반을 시계 방향으로 접어 왼쪽 반의 아래로 접기
    종이를 접을 때 마다 두께는 2배가 되고 길이는 절반이 된다.
    원룡이는 동호의 규칙대로 종이를 접지 않는다. 이때, 원룡이가 접었다 핀 종이를 동호의 규칙대로 접을 수 있는지 궁금해졌다.
    종이가 접혀있는 정보가 주어질 때, 이 종이를 동호의 규칙대로 접을 수 있는지 없는지 구하기
    *시계 방향으로 접혀있으면 out(=1), 반시계 방향으로 접혀있으면 in(=0)
    =>가운데를 기준으로 좌우가 대칭이 아니여야 조건을 만족한다! (이거 이해하는데 한 세월이였음)
 */

public class Main_BJ1802 {                  //종이 접기
    //다시 풀기

    static String str;

    static boolean isFold(int start, int end){
        if(start == end){                                           //한 번 접었으면 무조건 조건 만족
            return true;
        }

        int mid = (start + end) / 2;
        for(int i = start; i < mid; i++){
            if(str.charAt(i) == str.charAt(end - i)){               //대칭이면 조건 불만족
                return false;
            }
        }

        return isFold(start, mid-1) && isFold(mid+1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++){
            str = br.readLine();

            if(isFold(0, str.length()-1)){
                System.out.println("YES");
            }  else{
                System.out.println("NO");
            }
        }
    }
}
