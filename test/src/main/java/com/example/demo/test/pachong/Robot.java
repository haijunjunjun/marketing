package com.example.demo.test.pachong;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 14:27
 */
public class Robot {

    public static void pyData() throws Exception {
        URL url = null;
        URLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        String regex = "https://[\\w+\\.?/?]+\\.[A-Za-z]+";//url匹配规则
        Pattern pattern = Pattern.compile(regex);
        url = new URL("http://www.qq.com/");
        urlConnection = url.openConnection();
        printWriter = new PrintWriter(new FileWriter("D://pydata/pydata.txt"), true);
        bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String buf = null;
        while ((buf = bufferedReader.readLine()) != null) {
            Matcher matcher = pattern.matcher(buf);
            while (matcher.find()) {
                printWriter.write(matcher.group() + "\n");
            }
        }
        System.out.println("数据爬取成功!");
        bufferedReader.close();
        printWriter.close();
    }

    public static void main(String[] args) {
        try {
            pyData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
