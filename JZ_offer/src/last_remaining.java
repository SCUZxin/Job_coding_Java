/**
 * 孩子们的游戏（圆圈中最后剩下的数）：
 * 随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class last_remaining {
    public static void main(String[] args){
        int n = 7, m = 3;
        int result = new last_remaining().LastRemaining_Solution(n, m);
        System.out.println("remain number is : " + result);
    }

    //令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]。
    //递推公式:
    //f[1]=0;
    //f[i]=(f[i-1]+m)%i;  (i>1)
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0 || m<=0){
            return -1;
        }
        if(n==1){
            return 0;
        }
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
