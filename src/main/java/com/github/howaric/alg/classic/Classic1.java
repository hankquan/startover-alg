package com.github.howaric.alg.classic;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
public class Classic1 {

    public static void main(String[] args) {
        boolean unique = new Classic1().isUnique("123435");
        System.out.println(unique);
    }

    public boolean isUnique(String astr) {
        long low = 0;
        long high = 0;
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = chars[i];
            if (value <= 64) {
                if ((low & 1 << value) != 0) {
                    return false;
                }
                low |= 1 << value;
            } else {
                if ((high & 1 << (value - 64)) != 0) {
                    return false;
                }
                high |= 1 << (value - 64);
            }
        }
        return true;
    }


}
