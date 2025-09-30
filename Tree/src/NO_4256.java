import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4256
 */
public class NO_4256 {
    private static int[] pre, in, post;
    private static HashMap<Integer, Integer> inOrderIndexMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        /**
         * 전위, 중위로 -> 후위 순위 구하기
         *
         * 전위로 root 찾기
         * 중위로 size 찾기
         */

        for(int i =0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            inOrderIndexMap = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            pre = new int[n];
            in = new int[n];
            post = new int[n];

            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                pre[j] = value;
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                in[j] =value;
                inOrderIndexMap.put(value, j);
            }

            // post 로직
            postOrder(0, n - 1, 0, n - 1);
            System.out.println();
        }
    }

    private static void postOrder(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart <= preEnd && inStart <= inEnd) {
            int rootValue = pre[preStart];
            Integer rootIndex = inOrderIndexMap.get(rootValue);

            int leftSize = rootIndex - inStart;

            // pre 를 기점으로 찾아야됨.
            // root - left - right
            // left
            postOrder(preStart + 1, preStart + leftSize, inStart, rootIndex - 1);

            // right
            postOrder(preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);

            // root
            System.out.print(rootValue + " ");
        }
    }
}
