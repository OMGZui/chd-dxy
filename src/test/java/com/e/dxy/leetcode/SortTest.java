package com.e.dxy.leetcode;

import com.e.dxy.leetcode.easy.sort.Sort01;
import com.e.dxy.utils.PrintUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 2/16/22 10:23 PM
 */
public class SortTest {
    @Test
    public void bubbleSort(){
        Sort01 sort01 = new Sort01();
        int[] arr = {3,5,4,1,2,6};
        sort01.bubbleSort(arr);
        PrintUtil.printArray(arr);
    }
}
