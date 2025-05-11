import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_2800 {

    static String expression;
    static List<Pair> bracketPairs = new ArrayList<>();
    static Set<String> result = new TreeSet<>();

    static class Pair {
        int open, close;
        Pair(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine();

        // 1단계: 괄호 쌍 찾기
        findBracketPairs();

        // 2단계: 모든 가능한 조합 생성 (제거할 괄호 쌍 선택)
        boolean[] selected = new boolean[bracketPairs.size()];
        generateCombinations(0, selected);

        // 4단계: 결과 출력
        for (String exp : result) {
            System.out.println(exp);
        }
    }

    static void findBracketPairs() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                int openIndex = stack.pop();
                bracketPairs.add(new Pair(openIndex, i));
            }
        }
    }

    static void generateCombinations(int index, boolean[] selected) {
        if (index == bracketPairs.size()) {
            // 3단계: 선택된 괄호를 제거한 식 생성
            generateExpression(selected);
            return;
        }

        // 현재 괄호 쌍을 제거하는 경우
        selected[index] = true;
        generateCombinations(index + 1, selected);

        // 현재 괄호 쌍을 유지하는 경우
        selected[index] = false;
        generateCombinations(index + 1, selected);
    }

    static void generateExpression(boolean[] selected) {
        // 선택된 결과가 모두 false인 경우(괄호를 하나도 제거하지 않은 경우) 건너뛰기
        boolean anySelected = false;
        for (boolean s : selected) {
            if (s) {
                anySelected = true;
                break;
            }
        }

        if (!anySelected) {
            return;  // 원래 식과 동일한 경우는 제외
        }

        // 괄호를 제거할 위치를 표시할 boolean 배열 생성
        boolean[] toRemove = new boolean[expression.length()];
        for (int i = 0; i < bracketPairs.size(); i++) {
            if (selected[i]) {  // 현재 괄호 쌍을 제거하는 경우
                Pair pair = bracketPairs.get(i);
                toRemove[pair.open] = true;   // 여는 괄호 제거 표시
                toRemove[pair.close] = true;  // 닫는 괄호 제거 표시
            }
        }

        // 제거 표시된 괄호를 제외하고 새로운 식 생성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (!toRemove[i]) {
                sb.append(expression.charAt(i));
            }
        }

        result.add(sb.toString());
    }
}
