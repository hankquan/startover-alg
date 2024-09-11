package com.github.howaric.alg.homework;

public class TestMain {

    public static void main(String[] args) {
        String input = "6 \n" +
                "This is some ordinary text. \n" +
                "<BEGIN> This is included in the BEGIN tag </BEGIN> \n" +
                " <START> Here's some stuff \n" +
                "and so is this \n" +
                " more stuff. </START> \n" +
                "2 \n" +
                " This has a null tag <> \n" +
                " And an extra line after the error \n" +
                "5 \n" +
                " This case starts out fine <OKAY> and has bad stuff later on. \n" +
                " <GOOD> All is still okay, but later an error is coming up. \n" +
                " </GOOD> We're still in the good to this point! <THISISTOOLONG> \n" +
                " This line will be skipped. \n" +
                " As will this one. \n" +
                "1 \n" +
                " This is an interesting error: <ERROR \n" +
                "2 \n" +
                " This test case has no problems \n" +
                " <IN> </IN> \n" +
                "1 \n" +
                " Mismatch on tags. <START> </STOP> \n" +
                "1 \n" +
                " Missing start symbol: <OK></OK></NOTOK> more garbage... \n" +
                "0";
        HtmlChecker htmlChecker = new HtmlChecker(input);
        String message = htmlChecker.check();
        System.out.println(message);
    }

}
