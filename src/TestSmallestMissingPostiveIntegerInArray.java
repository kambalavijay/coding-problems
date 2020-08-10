import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.letsonlycode.kambv.SmalletMissingPostiveIntegerInArray;

public class TestSmallestMissingPostiveIntegerInArray {

    private static SmalletMissingPostiveIntegerInArray smalletMissingPostiveIntegerInArray;

    @BeforeClass
    public static void construct(){
        smalletMissingPostiveIntegerInArray = new SmalletMissingPostiveIntegerInArray();
    }

    @Test
    public void testcase1(){
        int a[] = {-3, 4, 7, -1};
        int num = smalletMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(1, num);
    }

    @Test
    public void testcase2(){
        int a[] = {3, 4, 7, 1};
        int num = smalletMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(2, num);
    }

    @Test
    public void testcase3(){
        int a[] = {10, 200, 300, 400};
        int len = smalletMissingPostiveIntegerInArray.getMissingInt(a);
        Assert.assertEquals(1, len);
    }


}
