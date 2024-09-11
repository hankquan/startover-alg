package com.github.howaric.alg.offer;

/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n %= length;
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, length - 1);
        reverse(charArray, 0, length - n - 1);
        reverse(charArray, length - n, length - 1);
        return new String(charArray);
    }

    private void reverse(char[] charArray, int i, int j) {
        while (i < j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
    }

}
