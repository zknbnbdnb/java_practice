package code;

public class lianxi6 {
    int count;
    double money;
    String name;
    lianxi6() {
    }
    lianxi6 (int count, double money, String name) {
        this.count = count;
        this.money = money;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public double getRealMoney(double money) {
        if (money > 80) {
            return money * 0.6;
        }else if (money > 70) {
            return money * 0.7;
        }else {
            return money * 0.8;
        }
    }
}

