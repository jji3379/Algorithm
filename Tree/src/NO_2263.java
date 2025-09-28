import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NO_2263 {
    private static int[] in, post, pre;
    private static Map<Integer, Integer> inOrderIndex;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        in = new int[n + 1];
        post = new int[n + 1];
        pre = new int[n + 1];

        inOrderIndex = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(st.nextToken());
            in[i] = value;
            inOrderIndex.put(value, i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(1, n, 1, n);
    }

    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        // 범위가 정상적일 때
        if (inStart <= inEnd && postStart <= postEnd) {
            // 1. post 에서 root 값 찾고(범위 내 끝 값),
            int root = post[postEnd];
            System.out.print(root + " ");

            // 2. in 에서 root 값이 있는 인덱스 찾고
            int inOrderRootIndex = inOrderIndex.get(root);

            // 3. in 의 root 인덱스를 기점으로 left, right 나누기
            int leftTreeSize = inOrderRootIndex - inStart;

            // 4. in 의 left size 와 right size 에 맞게 post 범위 나누기 (인덱스 기록)

            // post 를 기점으로 찾을 것이기 때문에
            // 4-1. left 서브트리 재귀 (left 시작, root 전 인덱스, post 는 left 시작이기에 postStart, postStart 부터 leftTreeSize 수 이기 때문에 -1로 개수 맞추기)
            getPreOrder(inStart, inOrderRootIndex - 1, postStart, postStart + leftTreeSize - 1);

            // 4-2. right 서브트리 재귀 (root 옆 인덱스, in 끝, postStart + leftTreeSize, post 끝에서 기존 root 제거)
            getPreOrder(inOrderRootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
        }
    }
}
