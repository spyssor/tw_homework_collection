package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class Filter {


    List<Integer>  array;


    public Filter(List<Integer> array) {
     this.array = array;
    }


    //求数组中3的倍数
    public List<Integer> filterMultipleOfThree() {

        List<Integer> res = new ArrayList<>();
        for (Integer e : array) {
            if (e % 3 == 0){
                res.add(e);
            }
        }

        return res;
    }

    //求两数组的公共元素
    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {

        List<Integer> firstArray = new ArrayList<>(firstList);
        List<Integer> secondArray = new ArrayList<>(secondList);
        List<Integer> res = new ArrayList<>();

        for (Integer first : firstArray){
            for (Integer second : secondArray){
                if (first.compareTo(second) == 0 && !res.contains(first)) {
                    res.add(first);
                }
            }
        }

        return res;
    }

    //求数组中的偶数
    public List<Integer> filterEven() {

        List<Integer> res = new ArrayList<>();
        for (Integer e : array) {
            if ((e & 1) == 0){
                res.add(e);
            }
        }

        return res;
    }

    //去除数组中的重复元素
    public List<Integer> getDifferentElements() {
        List<Integer> record = new ArrayList<>();
        List<Integer> list = new ArrayList<>(array);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i ++){
            for (int j = i+1; j < list.size(); j ++){
                if (list.get(i).compareTo(list.get(j)) == 0 && !record.contains(j)){
                    record.add(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i ++){
            if (!record.contains(i)){
                res.add(list.get(i));
            }
        }

        return res;
    }
}