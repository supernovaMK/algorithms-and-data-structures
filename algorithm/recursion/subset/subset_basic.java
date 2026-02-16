package algorithm.recursion.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class subset_basic {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        search(1, N, arrayDeque);
    }

    public static void search(int k, int N, ArrayDeque<Integer> deque) {
        if (k == N + 1) {
            System.out.println(deque);
            return;
        }
        deque.add(k);
        search(k + 1, N, deque);
        deque.removeLast();
        search(k + 1, N, deque);
    }
}
