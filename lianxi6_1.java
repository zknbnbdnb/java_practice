package code;

public class lianxi6_1 {
    public static void main(String[] args) {
        lianxi6 shampoo = new lianxi6(99, 99.77, "shampoo");
        String name_s = shampoo.getName();
        int count_s = shampoo.getCount();
        double money_s = shampoo.getMoney();
        double real_s = shampoo.getRealMoney(money_s);

        lianxi6 rice = new lianxi6(88, 88.88, "rice");
        String name_r = rice.getName();
        int count_r = rice.getCount();
        double money_r =rice.getMoney();
        double real_r =rice.getRealMoney(money_r);

        lianxi6 water = new lianxi6(77, 77.99, "water");
        String name_w = water.getName();
        int count_w = water.getCount();
        double money_w = water.getMoney();
        double real_w = water.getRealMoney(money_w);

        System.out.println(name_s + "有" + count_s + "瓶" + "原价为" + money_s + "现在打折价为" + real_s);
        System.out.println(name_r + "有" + count_r + "瓶" + "原价为" + money_r + "现在打折价为" + real_r);
        System.out.println(name_w + "有" + count_w + "瓶" + "原价为" + money_w + "现在打折价为" + real_w);
    }
}
