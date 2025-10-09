package BaekJoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
    1번부터 n번까지 n명의 사람이 원을 이루며 앉아 있고, 순서대로 k번째 사람을 계속해서 제거함.
    n명의 사람들이 모두 제거될 때까지 반복, 제거된 순서를 (n, k)-요세푸스 순열이라고 함.
    *ex)(7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>
 */

public class Main_BJ1158 {                      //요세푸스 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        System.out.print("<");
        int idx = 0;
        while(!q.isEmpty()){
            int tmp = q.poll();
            idx++;

            if(idx == k){                           //이번에 뽑은게 k번째면
                System.out.print(tmp);
                idx = 0;

                if(!q.isEmpty()){
                    System.out.print(", ");
                }
            } else {                                //k번째 이전 것들은 다시 큐로
                q.offer(tmp);
            }
        }
        System.out.print(">");
    }
}
