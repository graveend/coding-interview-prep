package stack.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/simplify-path/description/
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<>();
        stack.push("");
        for(String folder: folders) {
            if(folder.equals("..")) {
                if(stack.size() > 1) {
                    stack.pop();
                }
            } else if( !folder.equals("") && !folder.equals(".")) {
                stack.push(folder);
            }
        }
        int N = stack.size();
        String[] res = new String[N];
        for(int i = N-1; i >= 0;  i--) {
            res[i] = stack.pop();
        }
        return N == 1 ? "/" : String.join("/", res);
    }
}

class TestSimplifyPath {
    @Test
    public void testPath() {
        String path = "/home/";
        String expected = "/home";
        String output = SimplifyPath.simplifyPath(path);
        assertEquals(expected, output);
    }

    @Test
    public void testPath1() {
        String path = "/../";
        String expected = "/";
        String output = SimplifyPath.simplifyPath(path);
        assertEquals(expected, output);
    }
}
