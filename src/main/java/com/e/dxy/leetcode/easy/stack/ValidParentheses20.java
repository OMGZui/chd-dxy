package com.e.dxy.leetcode.easy.stack;


import java.util.Stack;

public class ValidParentheses20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stackOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static char stackOf(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            default:
                return '[';
        }
    }

    public static void main(String[] args) {
        // s = "()[]{}"
        String s1 = "()[]{}";
        String s2 = "(){]{}";
        Boolean isValid1 = isValid(s1);
        Boolean isValid2 = isValid(s2);
        System.out.println(isValid1);
        System.out.println(isValid2);
    }
}
