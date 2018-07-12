/**
 * 替换空格:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 1：从前往后插入，这样移动·的次数多不建议
 * 2：从后往前插入
 */
public class replace_space {
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("We Are Happy");
        String result = new replace_space().replaceSpace(str);
        System.out.println(result);
    }

    public String replaceSpace(StringBuffer str) {
        int len = str.length();
        for (int i = len-1; i >=0; i--) {
            if(str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
}
