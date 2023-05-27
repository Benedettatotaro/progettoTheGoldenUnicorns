package homework2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateTest {

    @Test
    @DisplayName("Test for the first branch")
    void testFirstBranch() {

        double[] example_array = new double[2];

        example_array[0] = 1;

        example_array[1] = 31;

        Calculate test_obj = new Calculate();

        example_array = test_obj.calculateMinimums(example_array);

        double[] result = new double[2];

        result[0] = 1;

        result[1] = 31;

        Assertions.assertArrayEquals(result,example_array);

    }


    @Test
    @DisplayName("Test for the second branch")
    void testSecondBranch() {

        double[] example_array = new double[5];

        example_array[0] = 31;

        example_array[1] = 5;

        example_array[2] = 7;

        example_array[3] = 100;

        example_array[4] = 0.1;

        Calculate test_obj = new Calculate();

        example_array = test_obj.calculateMinimums(example_array);

        double[] result = new double[2];

        result[0] = 0.1;

        result[1] = 5;

        Assertions.assertArrayEquals(result,example_array);

    }

    @Nested
    @DisplayName("writing tests black box")
    class BlackBoxTests {

        @Test
        @DisplayName("Array null should return exception")
        void arrayNullShouldReturnException() throws Exception{

            Calculate calculate= new Calculate();

            assertThrows(IllegalArgumentException.class, ()-> calculate.calculateMinimums(null));

        }

        @Test
        @DisplayName("Array empty should return exception")
        void arrayEmptyShouldReturnException() throws Exception{

            Calculate calculate= new Calculate();

            double[] array = new double[0];

            assertThrows(IllegalArgumentException.class, ()-> calculate.calculateMinimums(array));

        }
        @Test
        @DisplayName("Array with one element should return exception")
        void arrayWithOneElementShouldReturnException() throws Exception{

            Calculate calculate= new Calculate();

            double[] array = new double[1];

            array[0]=1.053;

            assertThrows(IllegalArgumentException.class, ()-> calculate.calculateMinimums(array));

        }

        @Test
        @DisplayName("array in ascendent order")
        void arrayInAscendentOrder() {

            double[] array = new double[10];

            for (int i = 0; i < 10; i += 1) {

                array[i] = i;

            }

            Calculate calculate= new Calculate();

            double[] arrayEqual = new double[2];

            arrayEqual[0]=0;
            arrayEqual[1]=1;

            assertArrayEquals(arrayEqual,calculate.calculateMinimums(array));

        }

        @Test
        @DisplayName("array in discendent order")
        void arrayInDiscendentOrder() {

            double[] array = new double[10];

            int j=100;

            for (int i = 0; i < 10; i += 1) {

                array[i] = j;

                j--;

            }

            Calculate calculate= new Calculate();

            double[] arrayEqual = new double[2];

            arrayEqual[0]=91;
            arrayEqual[1]=92;

            assertArrayEquals(arrayEqual,calculate.calculateMinimums(array));

        }

    }

}
