import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 第一个只出现一次的字符：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个
 * 只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class first_notRepeating_char {
    public static void main(String[] args){
        String str = "gooogle";
        int result = new first_notRepeating_char().FirstNotRepeatingChar(str);
        System.out.println(result);
    }

    //法二：使用ArrayList, 遇到重复就remove同时添加到重复list中, list和重复list都没有某char,则add到list中
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()==0) return -1;
        List<Character> list = new ArrayList<>();
        List<Character> repeatList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!list.contains(ch) && !repeatList.contains(ch)){
                list.add(ch);
            }else{
                list.remove(Character.valueOf(ch));
                repeatList.add(ch);
            }
        }
        if(list.size() <=0) return -1;
        return str.indexOf(list.get(0));
    }


    //法一：使用HashMap
    public int FirstNotRepeatingChar_1(String str) {
        if(str.length() == 0 || str==null)
            return -1;
        HashMap<Character, Integer> charNumMap = new HashMap<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!charNumMap.containsKey(cs[i])){
                charNumMap.put(cs[i], 1);
            }
            else{
                charNumMap.put(cs[i], charNumMap.get(cs[i])+1);
            }
        }

        int index = -1;

        for (int i = 0; i < cs.length; i++) {
            if(charNumMap.get(cs[i]) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}
