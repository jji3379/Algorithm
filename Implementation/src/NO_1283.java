import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO_1283 {
    static List<Character> shortCuts;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        shortCuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println(ShortCutOption(arr[i]));
        }
    }

    private static String ShortCutOption(String option) {
        StringTokenizer st = new StringTokenizer(option);

        String shortCutOption = option;

        int wordIndex = -1;

        // 첫글자 확인
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordIndex++;
            char[] wordArr = word.toCharArray();

            if (!isShortCut(wordArr[0])) {
                shortCuts.add(wordArr[0]);
                return convertShortCutOption(option, wordIndex, wordArr[0], 0);
            }
        }

        // 첫글자가 아닐 때
        st = new StringTokenizer(option);
        wordIndex = -1;
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordIndex++;
            char[] wordArr = word.toCharArray();

            for (int i = 0; i < wordArr.length; i++) {
                if (!isShortCut(wordArr[i])) {
                    shortCuts.add(wordArr[i]);
                    return convertShortCutOption(option, wordIndex, wordArr[i], i);
                }
            }
        }

        return shortCutOption;
    }

    private static boolean isShortCut(char alphabet) {
        return shortCuts.contains(Character.toUpperCase(alphabet)) ||
                shortCuts.contains(Character.toLowerCase(alphabet));
    }

    private static String convertShortCutOption(String option, int wordIndex, char shortCut, int shortCutIndex) {
        StringTokenizer st = new StringTokenizer(option);
        StringBuffer sb = new StringBuffer();
        int wordCount = st.countTokens();

        for (int i = 0; i < wordCount; i++) {
            if (i != 0) {
                sb.append(" ");
            }

            if (i == wordIndex) {
                String word = st.nextToken();
                char[] charArray = word.toCharArray();

                for (int j = 0; j < charArray.length; j++) {
                    if (j == shortCutIndex) {
                        sb.append(addBracket(shortCut));
                    } else {
                        sb.append(charArray[j]);
                    }
                }
            } else {
                sb.append(st.nextToken());
            }
        }

        return sb.toString();
    }

    private static String addBracket(char word) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(word);
        sb.append("]");

        return sb.toString();
    }
}
