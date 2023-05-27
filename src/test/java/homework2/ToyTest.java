package homework2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToyTest {

    @Test
    @DisplayName("understand inputs of calculate")
    void understandInputOfCalculate(){

        double[] array = new double[10];

        for(int i=0; i<10; i+=1){

            array[i]=i;

        }

        Calculate calculate=new Calculate();

        assertNotNull(calculate);

        double[] arrayEqual = new double[2];

        arrayEqual[0]=0;
        arrayEqual[1]=1;

        assertArrayEquals(arrayEqual,calculate.calculateMinimums(array));

    }

}
