package code;
import javax.swing.*;

interface interShape {
    abstract double getArea();
    abstract double getFerence();
}

class Point {
    double l;

    Point(double l) {
        this.l = l;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }
}

class Tri implements interShape {
    double a;
    double b;
    double c;

    Tri(Point a, Point b, Point c) {
        this.a = a.getL();
        this.b = b.getL();
        this.c = c.getL();
    }


    public double getArea() {
        double p = (this.a + this.b + this.c) / 2;
        return Math.pow(p * (p - this.a) * (p - this.b) * (p - this.c), 0.5);
    }

    public double getFerence(){
        return this.a + this.b + this.c;
    }
}



public class Exa
{
    public static void main(String args[ ])
    {
        Point a = new Point(3);
        Point b = new Point(4);
        Point c = new Point(5);

        Tri tri = new Tri(a, b ,c);
        System.out.println(tri.getArea());
        System.out.println(tri.getFerence());


    }
}
