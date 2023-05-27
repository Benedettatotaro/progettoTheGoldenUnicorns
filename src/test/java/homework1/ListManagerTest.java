package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    @Nested
    @DisplayName("writing tests for the constructor")
    class ConstructorTests {

        @Test
        @DisplayName("List manager Constructor should return an Exception with Null parameter ")
        void listManagerConstructorShouldReturnAnExceptionWithNullParameter() {

            Assertions.assertThrows(NullPointerException.class, () ->new ListManager(null) );

        }

        @Test
        @DisplayName("list manager constructor should initialize the list attribute correctly")
        void listManagerConstructorShouldInitializeTheListAttributeCorrectly() throws Exception {

            List<Element> elements = new ArrayList<Element>();

            Assertions.assertNotNull(new ListManager(elements));

            elements.add(new Element("bananas", 20, 20));

            Assertions.assertNotNull(new ListManager(elements));

        }

    }

    @Test
    @DisplayName("add element to an empty list should add it correctly")
    void addElementToAnEmptyListShouldAddItCorrectly() throws Exception {

        List<Element> elements = new ArrayList<>();

        ListManager listManager = new ListManager(elements);

        listManager.addElement( 20,20,"bananas");

        Assertions.assertEquals(1,listManager.returnListSize());

    }

    @Test
    @DisplayName("add element should add correctly a new element to a full list")
    void addElementShouldAddCorrectlyANewElementToAFullList() throws Exception {

        List<Element> elements = new ArrayList<>();

        Element element=new Element("bananas",12.0,5);

        elements.add(element);

        element=new Element("strawberries",9.20,4);

        elements.add(element);

        element=new Element("apples",10.50,10);

        elements.add(element);

        ListManager listManager = new ListManager(elements);

        listManager.addElement( 20,20,"pineapples");

        listManager.addElement(10.02, 30,"pears");

        Assertions.assertEquals(5,listManager.returnListSize());

    }

    @Test
    @DisplayName("remove element should return zero if the list is empty or product not found")
    void removeElementShouldReturnZeroIfTheListIsEmptyOrProductNotFound() throws Exception {

        List<Element> elements = new ArrayList<>();

        ListManager listManager = new ListManager(elements);

        Assertions.assertEquals(0, listManager.removeElement("bananas"));

        Assertions.assertEquals(0, listManager.returnListSize());

        listManager.addElement(20,20,"bananas");

        Assertions.assertEquals(0, listManager.removeElement("strawberries"));

        Assertions.assertEquals(1, listManager.returnListSize());

    }

    @Test
    @DisplayName("remove element from full list with the element should return the correct number of removed elements")
    void removeElementFromFullListShouldReturnTheNumberOfTheRemovedElements() throws Exception {

        List<Element> elements = new ArrayList<>();

        ListManager listManager = new ListManager(elements);

        listManager.addElement(20,20,"pineapples");

        listManager.addElement(30,20,"strawberries");

        listManager.addElement(30,20,"bananas");

        listManager.addElement(30,20,"bananas");

        Assertions.assertEquals(2,listManager.removeElement("bananas"));

        Assertions.assertEquals(2,listManager.returnListSize());

    }

    @Test
    @DisplayName("the total amount of a list empty should be zero")
    void theTotalAmountOfAListEmptyShouldBeZero() throws Exception {

        List<Element> elements = new ArrayList<>();

        ListManager listManager = new ListManager(elements);

        Assertions.assertEquals(0,listManager.calculateTotalAmount());

    }

    @Test
    @DisplayName("the total amount of a full list should be the correct value")
    void theTotalAmountOfAFullListShouldBeTheCorrectValue() throws Exception {

        List<Element> elements = new ArrayList<>();

        ListManager listManager = new ListManager(elements);

        listManager.addElement(20,20,"pineapples");

        listManager.addElement(30,20,"strawberries");

        listManager.addElement(30,20,"bananas");

        Assertions.assertEquals(1600,listManager.calculateTotalAmount());

    }

}
