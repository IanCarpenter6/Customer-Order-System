package COS;

public class Product 
{

    int idP;
    String name;
    String description;
    double price;
    double salesPrice;
    int quantity;

    public Product(int idP, String name, String description, double price, double salesPrice, int quantity)
    {
        this.idP = idP;
        this.name = name;
        this.description = description;
        this.price = price;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }

    public int getId()
    {
        return idP;
    }

    public int setQuantity(int idP)
    {
    	return quantity;
    }
    public String getProductName()
    {
        return name;
    }

    public String getDescription()
    {
    	return description;
    }

    public double getPrice() 
    {
        return price;
    }

    public double getSalesPrice() 
    {
        return salesPrice;
    }

    public int getQuantity() {
    	return quantity;
    }
}