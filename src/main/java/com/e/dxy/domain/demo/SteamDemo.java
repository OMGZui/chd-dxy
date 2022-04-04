package com.e.dxy.domain.demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 3/28/22 9:48 PM
 */
public class SteamDemo {

    public static void main(String[] args) {
        String[] words = {"abc", "bbb", "v", "n", "ii", "mn"};

        int n = 0;
        for (String word : words){
            if (word.length() > 1){
                n++;
            }
        }
        System.out.println("单词长度大于1的个数是：" + n);

        // 流操作
        long y = Arrays.stream(words).filter(w -> w.length() > 1).count();
        System.out.println("单词长度大于1的个数是：" + y);

        List<String> letterList = Arrays.stream(words).map(s -> s.substring(0, 1)).collect(Collectors.toList());
        String letters = Arrays.stream(words).map(s -> s.substring(0, 1)).collect(Collectors.joining(","));
        System.out.println("words的所有首字母是：" + letterList.toString());
        letterList.forEach(System.out::println);
        System.out.println("words的所有首字母是：" + letters);

        Path path = Paths.get("/Users/omgzui");
        System.out.println(path);
        System.out.println(path.getParent());
        System.out.println(path.getRoot());

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("/Users/.chd-bd"));
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        Pattern pattern = Pattern.compile("[a-z]{3}");
        String wordString = Arrays.stream(words).collect(Collectors.joining(","));
        Matcher matcher = pattern.matcher(wordString);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
