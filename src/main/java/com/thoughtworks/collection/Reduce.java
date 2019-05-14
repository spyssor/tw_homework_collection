package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    // 获取数组中的最大值
    public int getMaximum() {

        int max = Integer.MIN_VALUE;
        for (int num : arrayList) {
            if (num > max){
                max = num;
            }
        }
        return max;
    }

    //获取数组中的最小值
    public double getMinimum() {

        int min = Integer.MAX_VALUE;
        for (int num : arrayList) {
            if (num < min){
                min = num;
            }
        }
        return min;
    }

    // 获取数组的平均值
    public double getAverage() {

        double sum = 0;
        for (int num : arrayList) {
            sum += num;
        }

        return sum / arrayList.size();
    }

    // 获取数组中位数
    public double getOrderedMedian() {

        arrayList.sort((x, y) -> (x-y));
        if ((arrayList.size() & 1) == 1){
            return arrayList.get(arrayList.size() / 2);
        } else {
            return (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2.0;
        }
    }

    //获取数组中第一个偶数
    public int getFirstEven() {

        for (int num : arrayList) {
            if ((num & 1) == 0){
                return num;
            }
        }

        return -1;
    }

    //获取数组中第一个偶数的下标
    public int getIndexOfFirstEven() {

        for (int i = 0; i < arrayList.size(); i ++) {
            if ((arrayList.get(i) & 1) == 0){
                return i;
            }
        }

        return -1;
    }

    //获取数组中最后一个奇数
    public int getLastOdd() {

        for (int i = arrayList.size()-1; i >= 0; i --){
            if ((arrayList.get(i) & 1) == 1){
                return arrayList.get(i);
            }
        }

        return -2;
    }

    //获取数组中最后一个奇数的下标
    public int getIndexOfLastOdd() {

        for (int i = arrayList.size()-1; i >= 0; i --){
            if ((arrayList.get(i) & 1) == 1){
                return i;
            }
        }

        return -1;
    }

    //判断两个数组是否相等
    public boolean isEqual(List<Integer> arrayList) {

        Integer[] arr = new Integer[]{1, 1, 4, 4, 4, 9, 11, 15, 20, 27};
        List<Integer> originList = Arrays.asList(arr);

        if (originList.size() != arrayList.size()) {
            return false;
        } else {
            arrayList.sort((x, y) -> (x - y));
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).compareTo(originList.get(i)) != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    //当数组偶数大小或奇数大小时，计算中位数(利用mock走的when...thenReturn...的代理方法)
    public Double getMedianInLinkList(SingleLink singleLink) {

        arrayList.sort((x, y) -> (x-y));
        if ((arrayList.size() & 1) == 1){
            double res = Double.parseDouble(singleLink.getNode(arrayList.size() / 2 + 1) + "");
            return res;
        } else {
            Integer num1 = (Integer) singleLink.getNode(arrayList.size() / 2);
            Integer num2 = (Integer) singleLink.getNode(arrayList.size() / 2 + 1);

            return Double.parseDouble((num1 + num2) / 2.0 +"");
        }
    }
}
