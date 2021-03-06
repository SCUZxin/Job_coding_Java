/**
 * 翻转单词顺序：
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class reverse_word_requence {
    public static void main(String[] args){
        String str = "student. a am I";
        String result = new reverse_word_requence().ReverseSentence(str);
        System.out.println(result);
    }

    public String ReverseSentence(String str) {
        String[] strs = str.split("\\s+");//以一个或者多个空格为间隔
        int len = strs.length;
        if(len <= 0){
            return str;//输入只有空格的情况
        }
        String ret = "";
        for (int i = len-1; i >= 0 ; i--) {
            ret += (strs[i]+" ");
        }
        return ret.substring(0, ret.length()-1);
    }

}
