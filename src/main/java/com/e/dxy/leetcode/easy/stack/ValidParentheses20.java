package com.e.dxy.leetcode.easy.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

    public static boolean isValid111(String s) {
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

    public static boolean isValid222(String s) {
        Stack<Character> stack = new Stack<>();

        // 等同于stackOf()
        Map<Character, Character> stackOf  = new HashMap<>();
        stackOf.put(')', '(');
        stackOf.put('}', '{');
        stackOf.put(']', '[');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stackOf.get(c) == stack.peek()) {
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
        Boolean isValid1 = isValid111(s1);
        Boolean isValid2 = isValid222(s2);
        System.out.println(isValid1);
        System.out.println(isValid2);
    }
}
