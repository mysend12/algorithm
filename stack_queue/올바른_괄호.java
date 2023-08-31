package stack_queue;

import java.util.Stack;

public class 올바른_괄호 {

    public boolean solution(String s) {
        Stack<Boolean> stack = new Stack<>();
        for (int index=0; index<s.length(); index++) {
            if (s.charAt(index) == '(') {
                stack.push(true);
            } else {
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

}
