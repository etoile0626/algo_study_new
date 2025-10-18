package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ10815 {                     //숫자 카드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            if(set.contains(arr[i])){
                System.out.print(1 + " ");
            } else{
                System.out.print(0 + " ");
            }
        }
    }
}
