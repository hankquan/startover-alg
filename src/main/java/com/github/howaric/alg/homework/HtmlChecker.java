package com.github.howaric.alg.homework;

import java.util.*;

public class HtmlChecker {

    private List<String> lines;
    private Deque<String> tagStack;

    public HtmlChecker(String content) {
        String[] split = content.split("\n");
        lines = Arrays.asList(split);
        tagStack = new LinkedList<>();
    }

    public String check() {
        List<String> result = new ArrayList<>();
        int testcase = 1;
        int i = 0;
        while (i < lines.size()) {
            String lineString = lines.get(i);
            int num = -1;
            try {
                num = Integer.valueOf(lineString.trim());
            } catch (NumberFormatException e) {
                //not number
            }
            if (num != -1) {
                //i - i+num
                result.add("Testcase " + testcase++);
                int index = 1;
                boolean hasError = false;
                for (int j = i + 1; j <= i + num; j++) {
                    String checkResult = checkLine(lines.get(j), index++);
                    if (checkResult != null) {
                        hasError = true;
                        result.add(checkResult);
                        break;
                    }
                }
                if (!hasError) {
                    result.add("OK");
                }
                i = i + num ;
            }
        }
        return result.toString();
    }

    private String checkLine(String content, int line) {
        //line
        int index = 0;
        int n = content.length();
        while (index < n) {
            if ('<' == content.charAt(index)) {
                //find <>
                index++;
                StringBuilder tagBuilder = new StringBuilder();
                while (index < n && content.charAt(index) != '>') {
                    tagBuilder.append(content.charAt(index));
                    index++;
                }
                if (index >= n || content.charAt(index) != '>') {
                    return "line " + line + ": bad character in tag name.";
                }
                String tag = tagBuilder.toString();
                if (tag.length() > 10 || tag.length() < 1) {
                    return "line " + line + ": too many/few characters in tag name.";
                }
                if (tag.charAt(0) == '/') {
                    //back
                    String peek = tagStack.peek();
                    if (!tag.substring(1).equals(peek)) {
                        if (tagStack.isEmpty()) {
                            return "line " + line + ": no matching begin tag.";
                        } else {
                            return "line " + line + ": expected </" + tagStack.pop() + ">";
                        }
                        //no backward
                    } else {
                        tagStack.pop();
                    }
                } else {
                    tagStack.push(tag);
                }
            }
            index++;
        }
        return null;
    }

}
