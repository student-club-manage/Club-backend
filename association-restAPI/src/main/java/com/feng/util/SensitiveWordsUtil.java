package com.feng.util;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SensitiveWordsUtil {

    /**
     * 敏感词转化为字符串数组
     */
    public static final String[] str = readFile().split(",");

    /**
     * 敏感词库路径
     */
    public static final String pathname = "D:\\Project\\School_Project\\Last Practical Training for Third Year College Students\\association\\association-restAPI\\src\\main\\java\\com\\feng\\util\\sensitive-words.txt";

    public static void main(String[] args) {
        String a= SensitiveWordsUtil.outWords("某某某爱sm");
        System.err.println(a);
    }
    /**
     * @Description 将敏感词全部替换为等长度的"*"号。
     */
    public static String outWords(String put) {
        for (int i = 0; i < str.length; i++) {
            if (put.contains(str[i])) {
                StringBuilder text = new StringBuilder();
                for (int j = 0; j < str[i].length(); j++) {
                    text.append("*");
                }
                put = put.replace(str[i], text);
            }
        }
        return put;
    }

    /**
     * @Description 返回是否有敏感词
     */
    public static boolean isSensitive(String put) {
        boolean status = false;
        for (int i = 0; i < str.length; i++) {
            if(put.contains(str[i])) {
                status=true;
                break;
            }
        }
        return status;
    }

    /**
     * @Description 读入TXT文件
     */
    public static String readFile() {
        StringBuilder sb=new StringBuilder();
        try {
            InputStream in = new FileInputStream(pathname);
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据//该步即不会第一位有逗号，也防止最后一位拼接逗号！
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
