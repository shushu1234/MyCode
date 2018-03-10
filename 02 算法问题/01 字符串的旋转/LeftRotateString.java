package com.liuyao1;


import java.util.Scanner;

/**
 * Created By liuyao on 2018/3/10 14:17.
 */

/**
 * 字符串的旋转  abcdef->defabc 从第三个位置开始旋转
 * 三步旋转法：
 * step1: 将字符串分成两部分 X:abc Y:def
 * step2: 将字符串abc和def分别旋转 X:cba Y:fed
 * step3: 将字符串整体旋转 cbafed->defabc
 */
public class LeftRotateString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        srcStr 源字符串
        String srcStr=scanner.nextLine();
//        LeftPost 从哪个位置选择
        int leftPost=scanner.nextInt();
        char[] src=srcStr.toCharArray();

        LeftRotate(src,leftPost);

        for (int i = 0; i < src.length; i++) {
            System.out.print(src[i]);
        }
    }

    public static void LeftRotate(char[] src,int leftPost){
        int len=src.length;
//        如要左移动大于n位，那么与%n是等价的
        leftPost = leftPost% len;

        ReverseString(src,0,leftPost-1);
        ReverseString(src,leftPost,len-1);
        ReverseString(src,0,len-1);
    }

    public static void ReverseString(char[] src,int from,int to){
        while (from < to){
            char c=src[from];
            src[from++]=src[to];
            src[to--]=c;
        }
    }
}
