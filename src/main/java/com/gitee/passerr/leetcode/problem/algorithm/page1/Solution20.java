package com.gitee.passerr.leetcode.problem.algorithm.page1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * @author xiehai
 * @date 2019/07/03 13:56
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution20 {
    /**
     * 括号对缓存
     */
    private static final Map<Character, Character> BRACKET_PAIR = new HashMap<>(3);

    static {
        BRACKET_PAIR.put('(', ')');
        BRACKET_PAIR.put('{', '}');
        BRACKET_PAIR.put('[', ']');
    }

    public boolean isValid(String s) {
        // 用于暂时存放未匹配完的开括号
        Stack<Character> container = new Stack<>();
        for(int i = 0, length = s.length(); i < length; i ++) {
            Character bracket = s.charAt(i);
            // 弹出括号为闭括号
            if(!BRACKET_PAIR.containsKey(bracket)
                // 若待匹配栈为空或待匹配开括号与弹出闭括号不能配对
                && (container.isEmpty() || !bracket.equals(BRACKET_PAIR.get(container.pop())))) {
                return false;
            }

            // 开括号 暂存待匹配
            if(BRACKET_PAIR.containsKey(bracket)) {
                container.push(bracket);
            }

            // 否则 弹出的闭括号能和暂存的开括号配对 弹出并跳过
        }

        return container.isEmpty();
    }

    public boolean isValid2(String s) {
        // 括号原子是成对存在的 直接通过替换的方式快速处理
        // 效率较低
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.isEmpty();
    }
}
