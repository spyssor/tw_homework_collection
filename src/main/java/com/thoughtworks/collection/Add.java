package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Add {
    //求leftBorder 和rightBorder之间的偶数和
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0, index = 0, end = 0;
        if (leftBorder < rightBorder) {
            index = leftBorder;
            end = rightBorder;
        } else {
            index = rightBorder;
            end = leftBorder;
        }

        while (index <= end) {
            if ((index & 1) == 0) {
                sum += index;
            }
            index++;
        }

        return sum;
    }

    //求leftBorder 和rightBorder之间的奇数和
    public int getSumOfOdds(int leftBorder, int rightBorder) {

        int sum = 0, index = 0, end = 0;
        if (leftBorder < rightBorder) {
            index = leftBorder;
            end = rightBorder;
        } else {
            index = rightBorder;
            end = leftBorder;
        }

        while (index <= end) {
            if ((index & 1) == 1) {
                sum += index;
            }
            index++;
        }

        return sum;
    }

    //求数组中每个元素的3倍加2的和
    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (Integer index : arrayList){
            sum += index*3 + 2;
        }

        return sum;
    }

    //求数组中奇数元素的3倍加2，偶数元素不变的数组
    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) & 1) == 1) {
                arrayList.set(i, arrayList.get(i)*3 + 2);
            }
        }

        return arrayList;
    }

    //求数组中奇数元素的3倍加5的和
    public int getSumOfProcessedOdds(List<Integer> arrayList) {

        int sum = 0;
        for (Integer index : arrayList){
            if ((index & 1) == 1) {
                sum += index*3 + 5;
            }
        }

        return sum;
    }

    //求数组中所有偶数组成的数组的中位数
    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> oddArray = new ArrayList<>();
        for (Integer num : arrayList) {
            if ((num & 1) == 1){
                oddArray.add(num);
            }
        }
        oddArray.sort((x, y) -> (x-y));

        if ((oddArray.size() & 1) == 0) {
            return (double) (oddArray.get(oddArray.size() / 2) + oddArray.get(oddArray.size() / 2 - 1)) / 2;
        } else {
            return (double) oddArray.get(oddArray.size() / 2);
        }
    }

    //求数组中所有偶数的平均数
    public double getAverageOfEven(List<Integer> arrayList) {

        int sum = 0, count = 0;
        for (Integer num : arrayList) {
            if ((num & 1) == 0) {
                sum += num;
                count ++;
            }
        }

        return (double) sum / count;
    }

    // 求数组中所有偶数组成的数组是否包含某特定的数specialElment
    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        if ((specialElment & 1) == 1) {
            return false;
        } else {
            for (Integer num : arrayList) {
                if (num.equals(specialElment)) {
                    return true;
                }
            }
            return false;
        }
    }

    //找出数组中的所有偶数，从中剔除重复数据并返回
    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {

        List<Integer> res = new ArrayList<>();

        for (Integer num : arrayList) {
            if ((num & 1) == 0 && !res.contains(num)) {
                res.add(num);
            }
        }

        return res;
    }

    //排序数组 结果使数组偶数在递增在前，奇数递减在后
    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {

        int oddIndex = arrayList.size();
        int cur = 0;
        while(cur < oddIndex){
            if ((arrayList.get(cur) & 1) == 0) {
                cur ++;
            }else{
                swap(arrayList, cur, --oddIndex);
            }
        }

        //插入排序
        for (int i = 1; i < oddIndex; i ++){
            Integer e = arrayList.get(i);
            int j = i;
            for (; j > 0 && arrayList.get(j-1).compareTo(e) > 0; j --){
                arrayList.set(j, arrayList.get(j-1));
            }
            arrayList.set(j, e);
        }

        for (int k = oddIndex; k < arrayList.size(); k ++){
            Integer e = arrayList.get(k);
            int l = k;
            for (; l > 0 && arrayList.get(l-1).compareTo(e) < 0; l --){
                arrayList.set(l, arrayList.get(l-1));
            }
            arrayList.set(l, e);
        }

        return arrayList;
    }

    private void swap(List<Integer> array, int x, int y) {
        Integer temp = array.get(x);
        array.set(x, array.get(y));
        array.set(y, temp);
    }

    // 数组中前一个元素和后一个元素的和的3倍的数组
    public List<Integer> getProcessedList(List<Integer> arrayList) {

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i ++){
            res.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }

        return res;
    }
}
