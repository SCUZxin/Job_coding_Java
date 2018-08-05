package company.src.ALiBaBa;

import java.util.Scanner;

/**
 * 阿里编程测验题
 */
public class aliTest {
    static final Point START = new Point(0,0);
    static int minpath = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine().trim());
        //点的集合
        Point[] points = new Point[num];
        for(int i = 0; i < num; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculate(START, points, 0, 0);
        System.out.println(min);
    }

    public static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum + start.distance(START));
            return minpath;
        }
        for(int i = 0; i < points.length; i++){
            if(points[i].visited == false){
                sum += points[i].distance(start);
                if(sum < minpath){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count+1);
                }
                sum -= points[i].distance(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }
}

class Point{
    int x;
    int y;
    boolean visited;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    public int distance(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}
