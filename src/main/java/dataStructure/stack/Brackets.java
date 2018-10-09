package dataStructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 利用栈解决四则运算问题
 * @date 2018-10-09
 * @time 12:37
 */
public class Brackets {
    private static final List LEFT_LIST = Arrays.asList('[', '{', '(');
    private static final List RIGHT_LIST = Arrays.asList(']', '}', ')');

    public boolean checkBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (Character c : brackets.toCharArray()) {
            if (LEFT_LIST.contains(c)) {
                stack.push(c);
            } else if (RIGHT_LIST.contains(c)) {
                if (stack.empty()) {
                    return false;
                }
                Character last = stack.peek();
                if ((c == ']' && last == '[') || (c == '}' && last == '{') ||
                        (c == ')' && last == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        System.out.println(brackets.checkBrackets("{}"));
    }

}
