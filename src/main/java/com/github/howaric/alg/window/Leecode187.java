package com.github.howaric.alg.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
DNA序列由一系列核苷酸组成，缩写为'A','C','G'和'T'.。

例如，"ACGAATTCCG"是一个 DNA序列 。
在研究 DNA 时，识别 DNA 中的重复序列非常有用。

给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的长度为10的序列(子字符串)。你可以按 任意顺序 返回答案。
 */
public class Leecode187 {


    /*
    输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    输出：["AAAAACCCCC","CCCCCAAAAA"]
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        HashMap<String, Integer> countSet = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i + 10 <= n; i++) {
            String sub = s.substring(i, i + 10);
            Integer count = countSet.getOrDefault(sub, 0);
            if (count == 1) {
                result.add(sub);
            }
            countSet.put(sub, count + 1);
        }
        return result;
    }

    //window+bit
    public List<String> findRepeatedDnaSequences2(String s) {
        ArrayList<String> result = new ArrayList<>();

        return result;
    }

}
