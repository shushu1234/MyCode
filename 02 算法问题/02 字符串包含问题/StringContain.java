package com.liuyao.test1;

import java.util.Arrays;

/**
 * Created By liuyao on 2017/11/20 18:02.
 * First, there are no bugs; then, it's simple and efficient.
 */
public class StringContain {

    /**
     * 判断字符串b中的字符是否都在字符串a中，
     * 则轮询字符串b中的每一个字符，逐个与字符串a中的每个
     * 字符进行比较
     * <p>
     * 设n为字符串a的长度，m为字符串b的长度
     *
     * @param a 在a中检查是否包含b
     * @param b b为要检查的字符
     * @return 返回是否包含
     */
    public static boolean method1(String a, String b) {
        for (int i = 0; i < b.length(); i++) {
            int j;
            for (j = 0; (j < a.length()) && (a.charAt(j) != b.charAt(i)); j++) {
            }
            if (j >= a.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 如果允许排序的话，可以先对这两个字符串进行排序，
     * 然后再对这两个字符串进行轮询
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean method2(String a, String b) {
        char[] aa = a.toCharArray();
        Arrays.sort(aa);
        char[] bb = b.toCharArray();
        Arrays.sort(bb);
        for (char c :
                bb) {
            System.out.println(c);
        }

        for (int i = 0, j = 0; j < bb.length; ) {
//            当i没有超过aa的长度，并且aa中的值还没有超过bb中的值的时候
            while ((i < aa.length) && (aa[i] < bb[j])) {
                ++i;
            }
//            当i已经超过aa的长度，或者aa这个当前的值已经超过bb中的最大值了，那么返回false
            while ((i >= aa.length) || (aa[i] > bb[j])) {
                return false;
            }
//            继续检查下一个bb中的值
            ++j;
        }
        return true;
    }

    /**
     * 将26个字母分别对应一个素数，然后将字符串a中的字母对应的素数相乘，得到一个值
     * 然后用f中的值去取余b中字母的对应的素数，如果其中一个有余数的话，那么，b中就有字母a中不存在
     *
     * 但是如果a中的不同字母太多的话，前16个字母的对应的素数相乘就会超过long long对应的最大整数范围
     * @param a
     * @param b
     * @return
     */
    public static boolean method3(String a, String b) {
        int[] p = new int[]{2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        int f = 1;
        for (int i = 0; i < a.length(); i++) {
            int x = p[a.charAt(i) - 'A'];
//            如果当前的字母在a的前面已经存在的话，就不需要乘了
            if (f % x != 0) {
                f *= x;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            int x = p[a.charAt(i) - 'A'];
            if (f % x != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用位运算，每一位表示一个字母，为字母a计算出一个“签名”，然后再将b放到a中去查找
     * 机智呀
     * @param a
     * @param b
     * @return
     */

    public static boolean method4(String a,String b){
        int hash=0;
        for (int i = 0; i < a.length(); i++) {
//            h表示当前字母与字母A相差多个字母，
            int h=(a.charAt(i)-'A');
//            根据相差的个数来左移多少位1，左移多少位就表示在相应的位上标记字母存在
            int temp=1<< h;
//            然后用hash和temp进行按位或运算
            hash =hash| temp;
        }
        for (int i = 0; i < b.length(); i++) {
//            temp表示当前字母表示在哪一位
            int temp=1 << (b.charAt(i)-'A');
//            然后hash与temp按位进行与，如果a中不存在的话，那个就为0，返回false
            if ((hash & temp) ==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(method4("ACCD", "AF"));
    }
}
