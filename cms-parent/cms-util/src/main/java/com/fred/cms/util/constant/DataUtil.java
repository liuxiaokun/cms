package com.fred.cms.util.constant;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    private DataUtil() {
        // empty
    }

    public static String formatString(final String string) {

        if (null != string) {
            StringBuffer sb = new StringBuffer();

            for (int i = 0, length = string.length(); i < length; i++) {
                char c = string.charAt(i);

                switch (c) {
                case '&':
                    sb.append("&amp;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                default:
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return string;
        }
    }

    public static List<String> translateToList(final String s) {

        List<String> list = new ArrayList<String>();
        String[] sArr = s.split(",");

        for (String temp : sArr) {
            list.add(temp);
        }
        return list;
    }

    public static String toUpperCaseFirstCharacter(final String s) {
        return new StringBuffer().append(Character.toUpperCase(s.charAt(0))).append(s.substring(1))
                .toString();
    }

}