package BaekJoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
    형택구에 n명의 국회의원 후보가 존재하는 국회의원 선거가 있고, 유권자가 m명 존재.
    다솜이가 국회의원 후보 기호 1번으로 나와서 자신을 찍지 않는 사람들은 돈으로 매수하고자 함.
    *당선 = 다른 모든 사람의 득표수보다 많은 득표수를 가진 경우
    (ex. 1번-5표, 2번-7표, 3번 7표 => 2번, 3번을 찍은 사람들 각각 1명씩만 매수해서 당선 가능)
    매수 당한 사람은 무조건 다솜이를 찍는다고 가정.
    매수해야할 사람의 최솟값 구하기
    *0 < n <= 50, 0 < m <= 100

    **배열로 저장해서 일일히 검사 -> 실패
    ***우선순위 큐를 활용해서 가장 큰 득표를 가진 후보의 표를 하나씩 매수하기?
 */

public class Main_BJ1417 {                      //국회의원 선거
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        int no1 = sc.nextInt();                 //1번 후보

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i =0; i < n-1; i++){
            pq.offer(sc.nextInt());
        }

        if(n == 1){
            System.out.println(cnt);
            return;
        }

        while(!pq.isEmpty() && pq.peek() >= no1){
            int num = pq.poll();
            num--;
            no1++;
            cnt++;

            pq.offer(num);
        }

        System.out.println(cnt);
    }
}
