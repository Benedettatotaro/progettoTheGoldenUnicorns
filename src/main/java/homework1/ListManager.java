package homework1;

import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class ListManager {

    private List<Element> elements;
    private float totElement=0;

    public ListManager(List<Element> elements) throws Exception {

        if(elements == null){

            throw new NullPointerException("The list can't be null");

        }

        this.elements=elements;

    }

    public void addElement(double cost, int quantity, String productName) throws Exception{

        Element element=new Element(productName, cost, quantity);
        elements.add(element);

        System.out.println("The amount of " + element.returnProductName() + " is: " + element.returnTotElement()+"\n");

    }

    public double calculateTotalAmount() throws Exception {

        double tot=0;

        for(Element element:this.elements) {

            tot = tot + element.returnTotElement();

        }

        addTotalAmountToFile(tot);
        return tot;

    }

    public int removeElement(String productName)
    {

        int removedElements=0;

        Iterator<Element> iterator=elements.iterator();

        while(iterator.hasNext()){

            if(iterator.next().returnProductName().equals(productName)){ //cambiamento

                iterator.remove();
                removedElements++;

            }

        }

        return removedElements;

    }

    private void addTotalAmountToFile(double tot) throws Exception{

        FileWriter writer = new FileWriter("C:\\Users\\Bened\\OneDrive\\Desktop\\integrzione e test\\homework\\homework1.csv");
        writer.append("Product Name,Cost,Quantity,Total amount=" + String.valueOf(tot) + "\n");
        for(Element element:this.elements) {
            writer.append(element.returnProductName());
            writer.append(",");
            writer.append(String.valueOf(element.returnCost()));
            writer.append(",");
            writer.append(String.valueOf(element.returnQuantity()));
            writer.append(",");
            writer.append(String.valueOf(element.returnTotElement()));
            writer.append("\n");
        }

        writer.flush();
        writer.close();

    }

    public int returnListSize(){

        return elements.size();

    }

}
