package main.java.com.ilearning.top20.test13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    int getUnselectedNum(int[] favorites, int[] presents) {
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int favorite : favorites) {
            queue.offerLast(favorite);
        }
        for (int present : presents) {
            stack.offerLast(present);
        }
        boolean tryFlag = true;
        int count = 0;
        while (!queue.isEmpty() && tryFlag) {
            if (queue.getFirst() == stack.peek()) {
                stack.pop();
                queue.pollFirst();
                count = 0;
            } else {
                queue.offerLast(queue.pollFirst());
                count++;
            }
            if (count == queue.size()) {
                tryFlag = false;
            }
        }
        return queue.size();
    }
}
