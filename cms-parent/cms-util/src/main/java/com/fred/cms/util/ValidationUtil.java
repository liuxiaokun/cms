/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 19, 2015 7:22:28 PM
 */
package com.fred.cms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean isNumerical(final String number) {

        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(number);

        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isEmail(final String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }

        String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))"
                + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern mailPattern = Pattern.compile(emailPattern);
        Matcher mailMatcher = mailPattern.matcher(email);
        return mailMatcher.matches();
    }

    public static boolean isMobilePhoneNumber(final String mobilePhoneNumber) {
        if (StringUtils.isEmpty(mobilePhoneNumber)) {
            return false;
        }

        String phonePatternStr = "^1[0-9]{10}$";
        Pattern phonePattern = Pattern.compile(phonePatternStr);
        Matcher phoneMatcher = phonePattern.matcher(mobilePhoneNumber);

        return phoneMatcher.matches();
    }

    public static boolean isPhoneNumber(final String phoneNumber) {

        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }

        String phonePatternStr = "^([0-9]{3,5})-([0-9]{7,8})(-[0-9]+)?$";
        Pattern phonePattern = Pattern.compile(phonePatternStr);
        Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

        return phoneMatcher.matches();
    }

    public static boolean isFullURL(final String url) {
        boolean flag = false;

        if (!StringUtils.isEmpty(url)) {
            flag = url.toLowerCase().startsWith("http");
        }

        return flag;
    }

    public static List<String> formatBindingResult(final BindingResult result) {
        List<String> errorMessages = new ArrayList<String>();

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError objectError : errors) {
                errorMessages.add(objectError instanceof FieldError ? ((FieldError) objectError).getField() + " "
                        + objectError.getDefaultMessage() : objectError.toString());
            }
        }
        return errorMessages;
    }

    public static boolean isQQNumber(final String qqNumber) {
        if (StringUtils.isEmpty(qqNumber)) {
            return false;
        }

        String qqPatternStr = "^[1-9][0-9]{4,}$";
        Pattern qqPattern = Pattern.compile(qqPatternStr);
        Matcher qqMatcher = qqPattern.matcher(qqNumber);
        return qqMatcher.matches();
    }

    public static boolean isInteger(final String str) {
        Pattern pattern = Pattern.compile("^[-+]?[0-9]*$");
        Matcher isInteger = pattern.matcher(str);
        if (!isInteger.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isDate(final String str) {
        Pattern pattern = Pattern
                .compile("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$");
        Matcher isDate = pattern.matcher(str);
        if (!isDate.matches()) {
            return false;
        }
        return true;
    }
}
