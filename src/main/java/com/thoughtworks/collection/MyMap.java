package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    //将集合A中得元素映射成集合B中的元素
    public List<Integer> getTriple() {

        List<Integer> res = new ArrayList<>();
        for (Integer e : array) {
            res.add(e*3);
        }
        array = res;

        return array;
    }

    //数字映射为字母
    public List<String> mapLetter() {

        List<String> res = new ArrayList<>();
        for (Integer num : array) {
            if (num >= 1 && num <= 26) {
                res.add(letterList.get(num - 1));
            } else {
                throw new IllegalArgumentException("array's number is out of boundary");
            }
        }

        return res;
    }

    //字母表映射 只针对两位字母的映射
    public List<String> mapLetters() {

        List<String> res = new ArrayList<>();
        for (Integer num : array) {
            if (num >= 1 && num <= 26){
                res.add(letterList.get(num - 1));
            } else if (num > 26 && num <= 26*26+26) {
                int firstLetterNo = (num-1) / 26;
                int secondLetterNo = (num-1) % 26;
                res.add(letterList.get(firstLetterNo - 1) + letterList.get(secondLetterNo));
            } else {
                throw new IllegalArgumentException("array's number is out of boundary");
            }
        }

        return res;
    }

    //从大到小排序
    public List<Integer> sortFromBig() {

        array.sort((x, y) -> (y-x));

        return array;
    }

    //从小到大排序
    public List<Integer> sortFromSmall() {

        array.sort((x, y) -> (x-y));

        return array;
    }
}
