package com.cloud.setting.Controller;

/**
 * Description:sping-cloud-learn
 * Created by Administrator on 2020/2/4
 */
public class fn {

    public static void main(String[] args) {
        System.out.println(insert(2));
    }

    /**
     * 完成本方法实现功能: 将一个数字插入到给定的已经排好序的数组中，要求插入以后数组依然是有序的
     */
    public static int[] insert(int number) {
        int[] array = new int[]{1, 20, 50, 100};
        int len = array.length;
        int[] result = new int[len + 1];
        int index = len;

        for (int i = 0; i < len; i++) {
            if (array[i] > number) {
                index = i;
                break;
            }
        }

        System.arraycopy(array, 0, result, 0, index);
        result[index] = number;
        System.arraycopy(array, index, result, index + 1, len - index);

        return result;
    }

}
