package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    //把二维数组变成一维数组
    public List<Integer> transformToOneDimesional() {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < array.length; i ++){
            for (int j = 0; j < array[i].length; j ++){
                res.add(array[i][j]);
            }
        }

        return res;
    }

    // 把二维数组变成一维数组,消除重复,按照第一次出现的顺序排列最后的输出结果
    public List<Integer> transformToUnrepeatedOneDimesional() {

        List<Integer> res = new ArrayList<>();
        List<Integer> record = new ArrayList<>();

        for (int i = 0; i < array.length; i ++){
            for (int j = 0; j < array[i].length; j ++){
                if (!record.contains(array[i][j])) {
                    res.add(array[i][j]);
                    record.add(array[i][j]);
                }
            }
        }

        return res;
    }
}
