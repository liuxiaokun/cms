/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:00:08 AM
 */
package com.fred.cms.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.fred.cms.constant.CommonConstant;
import com.fred.cms.vo.Pagination;

public class DataUtil {

    private DataUtil() {
        // empty
    }

    @SuppressWarnings("unchecked")
    public static Object formatApiResponse(final Object response) {
        Object result = null;

        if (response == null) {
            return null;
        }
        Class<?> responseClass = response.getClass();

        if (response instanceof Map) {
            Map<String, Object> responseMap = (Map<String, Object>) response;
            Map<String, Object> resultMap = new HashMap<String, Object>();

            for (Entry<String, Object> entry : responseMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Object formatValue = formatApiResponse(value);

                if (formatValue != null) {
                    resultMap.put(key, formatValue);
                }
            }
            result = resultMap;
        } else if (response instanceof List) {
            List<Object> responseList = (List<Object>) response;
            List<Object> resultList = new ArrayList<Object>();

            for (Object obj : responseList) {
                Object formatedObj = formatApiResponse(obj);

                if (formatedObj != null) {
                    resultList.add(formatedObj);
                }
            }
            result = resultList;
        } else if (response instanceof Set) {
            Set<Object> responseList = (Set<Object>) response;
            Set<Object> resultList = new HashSet<Object>();

            for (Object obj : responseList) {
                Object formatValue = formatApiResponse(obj);

                if (formatValue != null) {
                    resultList.add(formatValue);
                }
            }
            result = resultList;
        } else if (response instanceof Pagination) {
            int count = ((Pagination<?>) response).getCount();
            List<?> list = ((Pagination<?>) response).getList();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("count", count);
            resultMap.put("list", formatApiResponse(list));
            result = resultMap;
        } else if (responseClass.getName().endsWith("VO")) {
            result = formatVO(response);
        } else if (response instanceof String) {

            if (StringUtils.isEmpty((String) response)) {
                result = "";
            } else {
                result = response;
            }
        } else if (response instanceof Double || response instanceof Float) {
            result = formatNumber(response, false, 2);
        } else if (response instanceof BigDecimal) {
            result = ((BigDecimal) response).setScale(2, BigDecimal.ROUND_HALF_UP);
            result = formatNumber(result, false, 2);
        } else if (response instanceof Date) {
            result = DateUtil.formatDate((Date) response, CommonConstant.UTC_FORMAT);
        } else {
            result = response;
        }

        return result;
    }

    public static String formatString(final String str) {

        if (null != str) {
            StringBuffer sb = new StringBuffer();

            for (int i = 0, length = str.length(); i < length; i++) {
                char c = str.charAt(i);

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
            return str;
        }
    }

    public static List<String> translateToList(final String str) {

        List<String> list = new ArrayList<String>();
        String[] sArr = str.split(",");

        for (String temp : sArr) {
            list.add(temp);
        }
        return list;
    }

    public static String toUpperCaseFirstCharacter(final String s) {
        return new StringBuffer().append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    private static Object formatVO(final Object vo) {

        Map<String, Object> obj = new HashMap<String, Object>();
        Class<?> classz = vo.getClass();

        Method[] methods = classz.getDeclaredMethods();
        List<String> methodNames = new ArrayList<String>();

        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        Field[] fields = classz.getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            Method method = null;

            try {
                String methodSuffix = fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1, fieldName.length());
                if (methodNames.contains("is" + methodSuffix)) {
                    method = classz.getMethod("is" + methodSuffix);
                } else {
                    method = classz.getMethod("get" + methodSuffix);
                }
            } catch (NoSuchMethodException e) {
                method = null;
            } catch (SecurityException e) {
                method = null;
            }

            if (method != null) {
                Object value = null;
                try {
                    value = method.invoke(vo);
                } catch (IllegalAccessException e) {
                    value = null;
                } catch (IllegalArgumentException e) {
                    value = null;
                } catch (InvocationTargetException e) {
                    value = null;
                }
                if (value != null) {
                    obj.put(fieldName, formatApiResponse(value));
                }
            }

        }
        return obj;
    }

    public static String formatNumber(final Object f, final boolean commas, final int decimalPlaces) {
        StringBuilder rule = new StringBuilder();
        if (commas) {
            rule.append("#,##0");
        } else {
            rule.append("0");
        }
        if (decimalPlaces > 0) {
            rule.append(".");
            for (int i = 0; i < decimalPlaces; i++) {
                rule.append("0");
            }
        }
        NumberFormat nf = new DecimalFormat(rule.toString());
        return nf.format(f);
    }
}