package COS;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Order 
{
	Cart cart;
	String customerId; 
	double fee = 0;
	private static DecimalFormat df = new DecimalFormat("0.00");
	private double orderTotal = 0;
	private int orderNumber = 0;
	private LocalDate orderDate;
	private int authorizationNumber=0;
	
	public Order() {
		Random random = new Random();
		orderNumber = random.nextInt();
		orderDate = LocalDate.now();		
	}
	
	public void displayDeliveryMethods() 
	{
		System.out.println("\n Please choose a delivery method or '0' to exit.");
		System.out.println( "(1) Mail ($3.00) \n (2) In-store pickup (free)");
	}
	
	public void setFee(int choice) 
	{
		if (choice == 1) 
		{
			fee = 3;
		}
	}
	
	public void setAccountNumber(String accountNumber)
	{
		customerId = accountNumber;
	}
	
	public void setAuthorizationNumber(int authCode)
	{
		authorizationNumber = authCode;
	}
	
	public void setCart(Cart cartArg) 
	{
		cart = cartArg;
		double cartTotal = cart.getCartTotal();
		orderTotal = cartTotal + fee;
		System.out.println("\nDeliveryFee = " + fee + "\nOrder total = "+ df.format(orderTotal));
	}
	
	public void displayOrder() 
	{
		if(cart == null) 
		{
			System.out.println("\nCart is empty, cannot print order");
			return;
		}
		System.out.println("\nOrder number: " + orderNumber + "\nOrder Date: "+ orderDate);
		System.out.println("\nAuthorization number: " + authorizationNumber + "\nCustomer ID: "+ customerId);
		
		for(Product product: cart.getProducts())
		{
			System.out.println("\nItem: "+product.getProductName()+ "\nQuantity: "+ product.getQuantity());
		}
	}
}
