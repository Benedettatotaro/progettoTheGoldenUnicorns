package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElementTest {

    @Nested
    @DisplayName("writing tests for the constructor")
    class ConstructorTests {

        @Test
        @DisplayName("Product name null should return Exception")
        void productNameNullShouldReturnException() throws Exception {

            assertThrows(IllegalArgumentException.class,() -> new Element(null,2,3) );

        }

        @Test
        @DisplayName("Product name empty should return Exception")
        void productNameEmptyShouldReturnException() throws Exception {

            assertThrows(IllegalArgumentException.class,() -> new Element("",2,3) );

        }

        @Test
        @DisplayName("Product name new line should return Exception")
        void productNameNewLineShouldReturnException() throws Exception {

            assertThrows(IllegalArgumentException.class,() -> new Element("\n",2,3) );

        }

        @Test
        @DisplayName("Product name tab should return Exception")
        void productNameTabShouldReturnException() throws Exception {

            assertThrows(IllegalArgumentException.class,() -> new Element("\t",2,3) );

        }

        @Test
        @DisplayName("Product name correct should return a non null object")
        void productNameCorrectShouldReturnAnNonEmptyObject() {

            Assertions.assertNotNull(new Element("ciao", 2.3,3));

        }

        @Test
        @DisplayName("Cost on point value (0.01) should return not null object")
        void costLeftOnPointValueShouldReturnAnNonEmptyObject() throws Exception {

            assertNotNull(new Element("prova",0.01,3) );

        }

        @Test
        @DisplayName("Cost off point value (0.01 - Float.MIN_VALUE) should return exception")
        void costLeftOffPointValueShouldReturnException() {

            assertThrows(IllegalArgumentException.class, ()-> new Element("prova",Math.nextAfter(0.01,0),3));

        }

        @Test
        @DisplayName("Cost right on point value (1000) should return a not null object")
        void costRightOnPointValueShouldReturnANotNullObject() throws Exception {

            assertNotNull(new Element("prova",1000 ,3) );

        }

        @Test
        @DisplayName("Cost right off point value (1000 + Double.MIN_VALUE) should return exception")
        void costRightOffPointValueShouldReturnException() {

            assertThrows(IllegalArgumentException.class, ()-> new Element("prova",Math.nextAfter(1000,1001),3));

        }

        @Test
        @DisplayName("Quantity left on point value(0) should return Exception")
        void quantityLeftOnPointValueShouldReturnException() throws Exception {

            assertThrows(IllegalArgumentException.class, () -> new Element("prova", 20, 0));

        }

        @Test
        @DisplayName("Quantity left off point value(1) should return a non null object")
        void quantityLeftOffPointValueShouldReturnANotNullObject() {

            Assertions.assertNotNull(new Element("prova",20,1));

        }

        @Test
        @DisplayName("Quantity right on point value(1000) should return a not null object")
        void quantityRightOnPointValueShouldReturnANotNullObject() throws Exception {

            assertNotNull(new Element("prova", 20, 1000));

        }

        @Test
        @DisplayName("Quantity right off point value(1001) should return exception")
        void quantityRightOffPointValueShouldReturnException() {

            assertThrows(IllegalArgumentException.class, ()->new Element("prova",20,1001));

        }

    }


    @Test
    @DisplayName("the method returnProductName should return the correct product name")
    void returnProductNameShouldReturnTheNameOfTheProduct () {

        Element element = new Element("ciao", 2.5F,3);

        Assertions.assertEquals("ciao", element.returnProductName());

    }


    @Test
    @DisplayName("the method returnCost should return the correct cost of the product")
    void returnCostShouldReturnTheCorrectCostOfTheProduct () {

        Element element = new Element("ciao", 2.5F,3);

        Assertions.assertEquals(2.5F, element.returnCost());

    }

    @Test
    @DisplayName("the method returnQuantity should return the correct quantity of the product")
    void returnQuantityShouldReturnTheCorrectQuantityOfTheProduct () {

        Element element = new Element("ciao", 2.5F,3);
        Assertions.assertEquals(3, element.returnQuantity());

    }

    @Test
    @DisplayName("the method returnTotElement should return the correct quantity of the product")
    void returnTotElementShouldReturnTheCorrectTotalOfTheProduct () {

        Element element = new Element("ciao", 2.5F,3);
        Assertions.assertEquals((2.5F * 3), element.returnTotElement());

    }

}
