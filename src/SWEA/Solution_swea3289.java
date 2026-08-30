package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
    여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하기.
    *합집합은 0 a b의 형태로 입력이 주어짐, a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미.                    ->  유니온?
    *같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어짐, a와 b가 같은 집합에 포함되어 있는지를 확인한다는 의미. ->  파인드?
    *a와 b는 n 이하의 자연수이며 같을 수도 있다.
    *1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력.
 */

public class Solution_swea3289 {                            //서로소 집합

    static int[] parent;

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);                      //a, b의 부모 x, y 찾기

        if(x != y) {
            if (x <= y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }

        parent[a] = find(parent[a]);

        return parent[a];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }

            sb.append("#").append(t).append(" ");

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(order == 0){
                    union(a, b);
                } else {
                    if(find(a) == find(b)){
                        sb.append(1);
                    } else{
                        sb.append(0);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
