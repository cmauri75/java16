package com.company.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//intre
public class StrongPassword {

    public static boolean check(String pwd) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

}
