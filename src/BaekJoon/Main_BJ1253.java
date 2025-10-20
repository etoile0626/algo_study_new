package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    n개의 수 중 어떤 수가 다른 두 수의 합으로 나타낼 수 있다면 그 수를 좋다(GOOD)고 함.
    n개의 수 중 좋은 수는 몇개인지 구하기
    *합이 같아도 수의 위치가 다르면 다른 수
 */

public class Main_BJ1253 {                          //좋다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int mid = arr[left] + arr[right];

                if (arr[i] == mid) {
                    if(i != left && i != right) {           //i번째 인덱스가 좋다임을 판별하는데 mid 값에 arr[i]가 반영되면 이상함
                        cnt++;
                        break;                              //왜 break를 하지? -> 좋은 수임이 확정나면 더 볼 필요가 없음, 좋은 수의 조합 수를 보는게 아님!
                    } else if(i == left){
                        left++;
                    } else{
                        right--;
                    }
                }
                else if (mid > arr[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }


        System.out.println(cnt);
    }
}
