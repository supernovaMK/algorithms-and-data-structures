package algorithm.recursion.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class permutation_basic {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        boolean[] used = new boolean[N + 1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        search(N, used, arrayDeque);
    }

    public static void search(int N, boolean[] used, ArrayDeque<Integer> arrayDeque) {
        if (arrayDeque.size() == N) {
            StringBuilder stringBuilder = new StringBuilder();
            for (var c : arrayDeque) {
                stringBuilder.append(c);
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (used[i]) {
                continue;
            }
            arrayDeque.add(i);
            used[i] = true;
            search(N, used, arrayDeque);
            arrayDeque.removeLast();
            used[i] = false;
        }
    }
}
