//package code;
//
//public class ch4 {
//    public static void main(String[] args) {
//        class Triangle {
//            double sideA;
//            double sideB;
//            double sideC;
//            void setSide(double a, double b, double c) {
//                sideA = a;
//                sideB = b;
//                sideC = c;
//            }
//            double getSideA() {
//                return sideA;
//            }
//            double getSideB() {
//                return sideB;
//            }
//            double getSideC() {
//                return sideC;
//            }
//            boolean isOrNotTriangle() {
//                if (sideA + sideB > sideC && sideA + sideC > sideB && sideC + sideB > sideA) {
//                    return true;
//                }else {
//                    return false;
//                }
//
//            }
//        }
//        xyj zbj; // 声明对象
//        xyj swk;
//        zbj = new xyj(); // 分配内存
//        swk = new xyj();
//        zbj.name = personName.八戒;
//        zbj.height = 1.83f;
//        zbj.weight = 83f;
//        zbj.head = "猪头";
//        swk.name = personName.悟空;
//        swk.height = 1.66f;
//        swk.weight = 1000f;
//        swk.head = "猴头";
//        System.out.println(zbj.name + "的身高体重和头分别是：" + zbj.height + zbj.weight + zbj.head);
//        System.out.println(swk.name + "的身高体重和头分别是：" + swk.height + swk.height + swk.head);
//        zbj.speak(zbj.name + "我想娶媳妇"); // 调用方法
//        System.out.println(zbj.name + "现在的头：" + zbj.head);
//        swk.speak(swk.name + "我重" + swk.weight + "公斤， 想骗猪八戒背我");
//        System.out.println(swk.name + "现在的头：" + swk.head);
//    }
//}
//class xyj {
//    personName name;
//    float height, weight;
//    String head;
//    void speak(String s) {
//        if (name == personName.八戒) {
//            head = "美男头";
//        }
//        else if (name == personName.悟空) {
//            head = "美女头";
//        }
//        System.out.println(s);
//    }
//}
