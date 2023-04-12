package code;

class point {
    int x, y;
    void setXY(int m, int n) {
        x = m;
        y = n;
    }
}
public class ch4_1 {
    public static void main(String[] args) {
        point p1, p2;
        p1 = new point();
        p2 = new point();
        System.out.println(p1); // 打印引用（地址）
        System.out.println(p2);
        p1.setXY(111, 222);
        p2.setXY(333, 444);
        System.out.println(p1.x + " " + p1.y);
        System.out.println(p2.x + " " + p2.y);
        p1 = p2;
        System.out.println(p1);
        System.out.println(p2);
    }
}
