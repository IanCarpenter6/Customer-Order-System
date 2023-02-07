package COS;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart 
{
	ArrayList<Product> products = new ArrayList<Product>();
	private static double taxRate = .085;
	private static DecimalFormat df = new DecimalFormat("0.00");
	private double cartTotal = 0;
	
	public void addProduct(Product product) 
	{
		products.add(product);
	}
	
	
	public void displayCart() 
	{
		df.setRoundingMode(RoundingMode.UP);
		double productTotal = 0;
		
		System.out.println("\nNew cart total: ");
		
		for(Product product: products)
		{
			productTotal += (product.getPrice() * product.getQuantity());
			System.out.println("\nQuantity: " + product.getQuantity()+"\nProduct #"+product.getId()+"\nName: "+product.getProductName()+"\nPrice: $"+product.getPrice());
		}
		
		double tax = productTotal * taxRate;
		cartTotal = productTotal + tax;
		
		System.out.println("\nProduct total = "+ productTotal + "\nTaxes = " + df.format(tax) + "\nCart Total = "+ df.format(cartTotal));
	}
	
	public double getCartTotal() 
	{
		return cartTotal;
	}
	
	public ArrayList<Product> getProducts()
	{
		return products;
	}
}
