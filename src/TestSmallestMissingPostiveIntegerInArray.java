import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.letsonlycode.kambv.SmallestMissingPostiveIntegerInArray;

public class TestSmallestMissingPostiveIntegerInArray {

    private static SmallestMissingPostiveIntegerInArray smallestMissingPostiveIntegerInArray;

    @BeforeClass
    public static void construct(){
        smallestMissingPostiveIntegerInArray = new SmallestMissingPostiveIntegerInArray();
    }

    @Test
    public void testcase1(){
        int a[] = {-3, 4, 7, -1};
        int num = smallestMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(1, num);
    }

    @Test
    public void testcase2(){
        int a[] = {3, 4, 7, 1};
        int num = smallestMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(2, num);
    }

    @Test
    public void testcase3(){
        int a[] = {10, 200, 300, 400};
        int len = smallestMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(1, len);
    }


}
