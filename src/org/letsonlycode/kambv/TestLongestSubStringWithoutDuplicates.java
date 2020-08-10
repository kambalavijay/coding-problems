package org.letsonlycode.kambv;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLongestSubStringWithoutDuplicates{

    private static LongestSubStringWithoutDuplicates longestSubStringWithoutDuplicates;

    @BeforeClass
    public static void construct(){
        longestSubStringWithoutDuplicates = new LongestSubStringWithoutDuplicates();
    }

    @Test
    public void testcase1(){
        String str = "abcdddefghj";
        int len = longestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(6, len);
    }

    @Test
    public void testcase2(){
        String str = "abcccabc";
        int len = longestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(3, len);
    }

    @Test
    public void testcase3(){
        String str = "abcdec";
        int len = longestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(5, len);
    }


}
