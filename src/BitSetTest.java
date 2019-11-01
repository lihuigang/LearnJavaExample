import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args)
    {

        BitSet bitSet=new BitSet(100000000);
        for(int i=0;i<1000000000;i++)
        {
            bitSet.set(i);
        }

        System.out.println("0~1亿不在上述随机数中有"+bitSet.size());
        for (int i = 0; i < 100000000; i++)
        {
            if(!bitSet.get(i))
            {
                System.out.println(i);
            }
        }
    }
}
