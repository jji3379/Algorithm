import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class NO_21944 {
    private static class Problem implements Comparable<Problem> {
        int problemNumber;
        int level;
        int group;

        private Problem(int problemNumber, int level, int group) {
            this.problemNumber = problemNumber;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) {
                return Integer.compare(problemNumber, o.problemNumber);
            }

            return Integer.compare(level, o.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> problemTreeSet = new TreeSet<>();
        Map<Integer, TreeSet<Problem>> groupProblemSet = new HashMap<>();
        Map<Integer, Integer> problemToLevelMap = new HashMap<>();
        Map<Integer, Integer> problemToGroupMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problemNumber = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(problemNumber, level, group);

            problemTreeSet.add(problem);
            groupProblemSet.computeIfAbsent(group, k -> new TreeSet<>()).add(problem);
            problemToLevelMap.put(problemNumber, level);
            problemToGroupMap.put(problemNumber, group);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command) {
                case "recommend":
                    int group = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    // 알고리즘 group 중 가장 어려운 문제
                    if (x == 1) {
                        System.out.println(groupProblemSet.get(group).last().problemNumber);
                    } else {
                        System.out.println(groupProblemSet.get(group).first().problemNumber);
                    }
                    break;
                case "recommend2":
                    int x2 = Integer.parseInt(st.nextToken());

                    // 알고리즘 상관없이 가장 어려운 문제
                    if (x2 == 1) {
                        System.out.println(problemTreeSet.last().problemNumber);
                    } else {
                        System.out.println(problemTreeSet.first().problemNumber);
                    }

                    break;
                case "recommend3":
                    int x3 = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());

                    if (x3 == 1) {
                        // 알고리즘 분류 상관없이 난이도가 L 보다 크거나 같은 문제중 가장 쉬운 문제
                        // 조건을 만족하는게 여러개라면 그 중 문제 번호가 작은 것
                        // 조건을 만족하는 번호가 없다면 -1 출력
                        Problem ceiling = problemTreeSet.ceiling(new Problem(0, level, 0));

                        if (ceiling == null) {
                            System.out.println(-1);
                        } else {
                            System.out.println(ceiling.problemNumber);
                        }
                    } else {
                        // 알고리즘 분류 상관없이 난이도가 L 보다 크거나 같은 문제중 가장 어려운 문제
                        // 조건을 만족하는게 여러개라면 그 중 문제 번호가 큰 것
                        // 조건을 만족하는 번호가 없다면 -1 출력

                        Problem floor = problemTreeSet.floor(new Problem(0, level, 0));

                        if (floor == null) {
                            System.out.println(-1);
                        } else {
                            System.out.println(floor.problemNumber);
                        }
                    }

                    break;
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    int g = Integer.parseInt(st.nextToken());

                    Problem problem = new Problem(p, l, g);

                    problemTreeSet.add(problem);

                    groupProblemSet.computeIfAbsent(g, k -> new TreeSet<>()).add(problem);
                    problemToLevelMap.put(p, l);
                    problemToGroupMap.put(p, g);
                    break;
                case "solved":
                    int removeProblemNumber = Integer.parseInt(st.nextToken());
                    Integer removeLevel = problemToLevelMap.get(removeProblemNumber);
                    Integer removeGroup = problemToGroupMap.get(removeProblemNumber);

                    Problem removeProblem = new Problem(removeProblemNumber, removeLevel, removeGroup);

                    problemTreeSet.remove(removeProblem);
                    groupProblemSet.get(removeGroup).remove(removeProblem);
                    problemToLevelMap.remove(removeProblemNumber);
                    problemToGroupMap.remove(removeProblemNumber);

                    break;
                default:
                    break;
            }
        }
    }
}
