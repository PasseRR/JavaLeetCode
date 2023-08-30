package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.Collections;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。
 * 此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * <p>
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * <p>
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * <p>
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * @author xiehai
 * @date 2019/07/16 17:28
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution71 {
    // #region snippet
    public String simplifyPath(String path) {
        // 替换多余/
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }

        // 记录入栈盘符不包含分隔符/
        Stack<String> stack = new Stack<>();
        // 盘符分隔
        String[] paths = path.split("/");
        // 需要返回上层的数量
        int upper = 0;
        for (int i = paths.length - 1; i >= 0; i--) {
            String catalog = paths[i];
            switch (catalog) {
                // 当前目录和空 都忽略
                case ".":
                case "": {
                    break;
                }
                // 返回上一层 记录返回数量
                case "..": {
                    upper++;
                    break;
                }
                // 目录
                default: {
                    // 如果存在返回上一层 返回上一层并递减数量
                    if (upper > 0) {
                        upper--;
                    } else {
                        // 加入盘符
                        stack.push("/" + catalog);
                    }
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            // 倒敘盘符
            Collections.reverse(stack);
        } else {
            // 若为空 返回根目录
            stack.add("/");
        }

        return String.join("", stack);
    }
    // #endregion snippet
}
