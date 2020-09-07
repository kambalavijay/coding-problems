package org.letsonlycode.kambv;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLongestSubStringWithoutDuplicates{

    @Test
    public void testcase1(){
        String str = "abcdddefghj";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(6, len);
    }

    @Test
    public void testcase2(){
        String str = "abcccabc";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(3, len);
    }

    @Test
    public void testcase3(){
        String str = "abcdec";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(5, len);
    }

    @Test
    public void testcase4(){
        String str = "ABDEFGABEFTRSA";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(8, len);
    }

    @Test
    public void testcase5(){
        String str = "ABCDEFGHIJAKLMNOPQRSTUV";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(22, len);
    }

    @Test
    public void testcase6(){
        String str = "ABCADEFGH";
        int len = LongestSubStringWithoutDuplicates.longestUniqueSubsttr(str);
        Assert.assertEquals(8, len);
    }
}
