package company.src.ByteDance4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*

给定一个文档(Unix-style)的完全路径，请进行路径简化。
样例
"/home/", => "/home"
"/a/./b/../../c/", => "/c"

/home/
/a/././b//../../c/
*/
public class main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        System.out.println(list.toString());
        return "/" + String.join("/", list);
    }
}
