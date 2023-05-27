package homework1;

public class Element {

    private String productName;
    private double cost;
    private int quantity;
    private double totElement;

    public Element(String productName, double cost, int quantity) {

        if (productName == null || productName.equals("") || productName.equals("\n") || productName.equals("\t")) {

            throw new IllegalArgumentException("The product name can't be empty.");

        }


        if(cost < 0.01 || cost > 1000) {

            throw new IllegalArgumentException("The cost can't be negative or equal to zero.");

        }

        if(quantity <= 0 || quantity > 1000) {

            throw new IllegalArgumentException("The amount of element can't be negative or equal to zero.");

        }

        this.totElement = cost*quantity;
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;


    }

    public double returnCost() {

        return this.cost;

    }

    public double returnTotElement() {

        return this.totElement;

    }

    public int returnQuantity() {

        return this.quantity;

    }

    public String returnProductName() {

        return this.productName;

    }

}
