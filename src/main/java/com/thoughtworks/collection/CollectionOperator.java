package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionOperator {
    //选出给定区间中所有的数字
    public List<Integer> getListByInterval(int left, int right) {

        List<Integer> res = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                res.add(i);
            }
        } else {
            for (int i = left; i >= right; i --){
                res.add(i);
            }
        }

        return res;
    }

    //选出给定区间中所有的偶数
    public List<Integer> getEvenListByIntervals(int left, int right) {

        List<Integer> res = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                if ((i & 1) == 0){
                    res.add(i);
                }
            }
        } else {
            for (int i = left; i >= right; i --){
                if ((i & 1) == 0){
                    res.add(i);
                }
            }
        }

        return res;
    }

    //选出给定区间中所有的偶数
    public List<Integer> popEvenElments(int[] array) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < array.length; i ++){
            if ((array[i] & 1) == 0) {
                res.add(array[i]);
            }
        }

        return res;
    }

    //弹出集合最后一个元素
    public int popLastElment(int[] array) {

        return array[array.length - 1];
    }

    //弹出两个集合的交集
    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < firstArray.length; i ++){
            for (int j = 0; j < secondArray.length; j ++){
                if (firstArray[i] == secondArray[j] && !res.contains(firstArray[i])){
                    res.add(firstArray[i]);
                }
            }
        }

        return res;
    }

    // 将集合二中与集合一不同的元素加入集合一
    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> res = new ArrayList<>();

        Collections.addAll(res, firstArray);

        for (Integer e : secondArray){
            if (!firstList.contains(e)) {
                res.add(e);
            }
        }

        return res;
    }
}
