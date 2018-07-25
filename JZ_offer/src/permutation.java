import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列：
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

//基于回溯法的思想
public class permutation {
    public static void main(String[] args){
        String str = "bca";
        ArrayList<String> result = new permutation().Permutation(str);
        System.out.println(result.toString());
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strList = new ArrayList<>();
        if(str != null && str.length() != 0){
            PermutationHelper(str.toCharArray(), strList, 0);
            Collections.sort(strList);
        }
        return strList;
    }

    public void PermutationHelper(char[] cs, ArrayList<String> list, int i){
        if(i==cs.length-1){
            String val = String.valueOf(cs);
            if(!list.contains(val)){
                list.add(val);
            }
        }
        else{
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, list, i+1);
                swap(cs, j, i);
            }
        }
    }

    public void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
