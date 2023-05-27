package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToyTest {

    @Test
    @DisplayName("Understand inputs of element")
    void understandInputsOfElement() {

        Element element = new Element("pen",2.50,4);

        assertNotNull(element);

        assertEquals("pen", element.returnProductName());

        assertEquals(2.50, element.returnCost());

        assertEquals(4, element.returnQuantity());


    }

    @Test
    @DisplayName("Understand inputs of list manager")
    void understandInputsOfListManager() throws Exception{

        List<Element> elements = new ArrayList<>();

        Element element=new Element("bananas",12.0,5);

        elements.add(element);

        element=new Element("strawberries",9.20,4);

        elements.add(element);

        element=new Element("apples",10.50,10);

        elements.add(element);

        ListManager listManager = new ListManager(elements);

        assertNotNull(listManager);

        listManager.addElement( 20,20,"pineapples");

        listManager.addElement(10.02, 30,"pears");

        Assertions.assertEquals(5,listManager.returnListSize());

    }

}
