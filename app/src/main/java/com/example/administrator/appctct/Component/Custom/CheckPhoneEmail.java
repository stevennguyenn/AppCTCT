package com.example.administrator.appctct.Component.Custom;

import com.example.administrator.appctct.Component.Constant.Strings;

public class CheckPhoneEmail {
    static public Boolean checkPhone(String phone){
        String match = "0[239][0-9]{8,9}";
        if (phone.matches(match)){
            return true;
        }
        return false;
    }

    static public Boolean checkEmail(String email){
        String math = "[a-zA-Z0-9][a-zA-Z0-9]*@[a-z]+(\\.[a-zA-Z]+)\\.[vV][nN]||[a-zA-Z0-9][a-zA-Z0-9]*@[a-z]+\\.com||[1][0-9]{6}@hcmut\\.edu\\.vn";
        if (email.matches(math)){
            return true;
        }
        return false;
    }
}
