//package code;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//
//public class shuzu {
//   public static void main(String args[]){
//       float a[] = new float[22];
//       int b[][] = new int[3][6];
//       int boy[] = {1, 2, 3, 5, 6};
//       int girl[] = {9, 8, 7, 6, 5, 4};
//       System.out.println("数组boy的个数为" + boy.length);
//       System.out.println("数组girl的个数为" + girl.length);
//       System.out.println("数组boy的应用为" + boy);
//       System.out.println("数组girl的应用为" + girl);
//       System.out.println("两个数组是否相等" + (boy == girl));
//       boy = girl;
//       System.out.println("数组boy的个数为" + boy.length);
//       System.out.println("数组girl的个数为" + girl.length);
//       System.out.println("数组boy的应用为" + boy);
//       System.out.println("数组girl的应用为" +girl);
//       System.out.println("两个数组是否相等" + (boy == girl));
//
//       int [] c = {1, 2, 3, 4, 5, 6};
//       System.out.println("c数组的元素为：" + Arrays.toString(c));
//       int [] d = Arrays.copyOfRange(c, 2, 6);
//       System.out.println("d数组的元素为：" + Arrays.toString(d));
//
//       int [] e = {23, 56, 12, 599, 1, 8, 4, 2, 7};
//       System.out.println("e的原数组：" + Arrays.toString(e));
//       Arrays.sort(e);
//       System.out.println("e的排序数组：" + Arrays.toString(e));
//       int num = 599;
//       int index = Arrays.binarySearch(e, num);
//       if(index >= 0){
//           System.out.println("num的索引为" + index);
//       }else {
//           System.out.println("num不存在与e中");
//       }
//       System.out.println(a[1]);
//
//       Weekday x = Weekday.星期三;
//       if (x == Weekday.星期三) {
//           System.out.println(x + "我有34的数据挖掘和89的统计学习方法");
//       }
//   }
//}
