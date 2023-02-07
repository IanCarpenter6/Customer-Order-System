package COS;
import java.util.Scanner;
import java.util.ArrayList;

public class CustomerOrderSystem
{	
	ArrayList<AccountInfo> accounts = new ArrayList<AccountInfo>();
	Cart cart = new Cart();
	AccountInfo currentAccount = null;
	ArrayList<Order> orders = new ArrayList<Order>();
	Bank bank = new Bank();
	
	public static void main(String args[])
	{
		CustomerOrderSystem cos = new CustomerOrderSystem();
		cos.startSystem();
	}
	
	public void startSystem()
	{
		int choice = 0;
		int stop = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to COS!");
		int loginCount = 0;
		
		while(stop==0)
		{	
			System.out.println("\n\nPress (1) to Create an Account, \n(2) to Log in, \n(3) to Log out, \n(4) to Select Items, \n(5) to Make Order, \n(6) to View Order");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1: //create account
					int upperCount = 0;
					int lowerCount = 0;
					int specialCount = 0;
					int digitCount = 0;
					
					boolean notValidID = true;
					String id = null;
					while(notValidID)
					{
						Scanner ident = new Scanner(System.in);
						
						System.out.println("\nEnter an ID you'd like to use: ");
						id = ident.nextLine();
						
						boolean iDmatched = false;
						
						for(AccountInfo account: accounts)
						{
							if(id.equals(account.getID()))
							{
								iDmatched=true;
								System.out.println("That ID already exists. Choose another.");
								break;
							}
						}
						if(iDmatched==false)
						{
							notValidID=false;
						}
					}
					
					Scanner pw = new Scanner(System.in);
					System.out.println("\nPASSWORD REQUIREMENTS: Your Password must include at least one upper case letter, \nat least one digit, and at least one special character.");
					System.out.println("\nEnter a Password: ");
					String pass = pw.nextLine();
					
					for(int i=0; i<pass.length(); i++)			
					{
						char ch = pass.charAt(i);
							
						if(Character.isUpperCase(ch))
							upperCount++;
						else if(Character.isLowerCase(ch))
							lowerCount++;
						else if(Character.isDigit(ch))
							digitCount++;
						else
							specialCount++;
					}
					
					if(pass.length()>=6 && upperCount>=1 && digitCount>=1 && specialCount>=1)
					{System.out.println("Password is valid");}
					else
					{					
						System.out.println("Password doesn't follow requirements. Try again: ");
						pass = pw.nextLine();
					}
					
					Scanner inputName = new Scanner(System.in);
					System.out.println("Enter your name: ");
					String name = inputName.nextLine();
					
					if(name==null)
					{
						System.out.println("No input given. Try again.");
						break;
					}
					
					Scanner inputCC = new Scanner(System.in);
					System.out.println("Enter your credit card number (no spaces necessary): ");
					String cc = inputCC.nextLine();
					
					if(cc==null)
					{
						System.out.println("No input given. Try again.");
						break;
					}
					
					Scanner inputADDR = new Scanner(System.in);
					System.out.println("Enter your address: ");
					String addr = inputADDR.nextLine();
					
					if(addr==null)
					{
						System.out.println("No input given. Try again.");
						break;
					}
					
					System.out.println("Enter the number assigned to the secuirty question you'd like to use: ");
					System.out.println("(1)What is the name of your middle school you went to?");
					System.out.println("(2)What is your father's middle name?");
					System.out.println("(3)What was the name of your first pet?");
					
					Scanner inputSQ = new Scanner(System.in);
					String sQ;
					int sqNum = inputSQ.nextInt();
					if(sqNum==1) 
					{sQ = "What is the name of your middle school you went to?";}
					else if(sqNum==2)
					{sQ = "What is your father's middle name?";}
					else if(sqNum==3)
					{sQ = "What was the name of your first pet?";}
					else 
					{
						System.out.println("Invalid security question. Try again.");
						break;
					}
					Scanner inputSA = new Scanner(System.in);
					System.out.println("Enter your answer to the security question: ");
					String sA = inputSA.nextLine();
					
					if(sA==null) 
					{
						System.out.println("No input given. Try again.");
						break;
					}
					
					AccountInfo acc = new AccountInfo(id,pass,name,cc,addr,sQ,sA);
					accounts.add(acc);
					
					System.out.println("Account Created!");
					
					break;
					
				case 2: //log on
						boolean foundAccountID = false;
						boolean foundAccountPass = false;
					
						for(int i = 0; i<3; i++)
						{
							Scanner idLogin = new Scanner(System.in);
							
							System.out.println("To Log on, enter your User ID: ");
							String inputID = idLogin.nextLine();
							System.out.println("\n");
							
							Scanner pwLogin = new Scanner(System.in);
							System.out.println("Enter your Password: ");
							String inputPass = pwLogin.nextLine();
							System.out.println("\n");
							
							for(AccountInfo account: accounts)
							{
								if(inputID.equals(account.getID()))
								{
									foundAccountID = true;
									
									if(!inputPass.equals(account.getPass()))
									{
										System.out.println("Invalid Password. Try again.");
									}
									else
									{
										foundAccountPass = true;
										currentAccount = account;
										System.out.println("Login successful");
									}
								}
							}
							if(foundAccountID==true && foundAccountPass==true)
							{	
								loginCount++;
								break;
							}
							else
							{
									System.out.println("Account wasn't found. Logging out...");
									stop=1;
							}
						}
						
						if(foundAccountPass==false)
						{
							System.out.println("Password not matched after 3 attempts.");
							stop = 1;
						}
						
						break;
						
				case 3: //logout
						stop = 1;
						
						if(loginCount>0)
						{System.out.println("You're successfully logged out");}
						else
						{System.out.println("You're currently not logged in. Exiting COS...");}
						
						break;
						
				case 4: //select items
						Catalog catalog = new Catalog();
						catalog.loadProducts();
						catalog.printCatalog();
						
						int stopp = 1;
						int quantity;
						
						while(stopp==1) 
						{
							Scanner pr = new Scanner(System.in);
							System.out.println("\nEnter the ID number assigned to the product you want \nor enter '0' to close:");
							
							int idP = pr.nextInt();
							
							if(idP==0)
							{
								stopp=0;
							}
							else
							{	
								Product product = catalog.getProduct(idP);
								
								if(product==null)
								{
									System.out.println("Product not found. Try again.");
									stopp=1;
								}
								
								Scanner pQuant = new Scanner(System.in);
								System.out.println("\nEnter the quantity of the product you want:");
								product.quantity = pQuant.nextInt();
								cart.addProduct(product);
								cart.displayCart();
							}
						}
						
						break;
				
				case 5: //make order					
						if(canViewOrMakeOrder())
						{
							Scanner oe = new Scanner(System.in);
							Order order = new Order();
							order.displayDeliveryMethods();
							int option = oe.nextInt();
							
							if(option==0)
							{
								System.out.println("Exiting to main menu...");
							}
							else if(option==1 || option ==2)
							{
								order.setFee(option);
								order.setCart(cart);
								order.setAccountNumber(currentAccount.getID());
								//get authcode
								int authCode = getAuthorization(currentAccount);
								if (authCode != 0)
								{
									order.setAuthorizationNumber(authCode);
									orders.add(order);
								}
								else {
									System.out.println("Authorization not granted, order cannot be created.");	
								}
							}				
							else
							{
								System.out.println("Invlaid option. Exiting to main menu...");							
							}
						}
						break;
						
				case 6: //view orders
						if(canViewOrMakeOrder())
						{
							for(Order order: orders)
							{
								order.displayOrder();
							}
						}
						break;
					
				case 7:	
						System.out.println("Invalid option. Try again: ");
						choice = sc.nextInt();
						break;
			}
		}
		return;
	}
	
	public int getAuthorization(AccountInfo account) 
	{
		String ccNbr = account.getID();
		int authCode = 0;
		boolean isValid = bank.isValid(ccNbr);
		if (isValid) {
			authCode = bank.getAuthCode(ccNbr);
		}
		if (authCode == 0) {
			Scanner newCC = new Scanner(System.in);
			System.out.println("Credit Card is invalid, authorization is denied. You can try to submit one more credit " +
									   "card number (length of 5 digits) or type Exit");
			String ccAnswer = newCC.nextLine();
			if (ccAnswer.equalsIgnoreCase("exit"))
			{
				return 0;
			}
			else if (bank.isValid(ccAnswer))
			{
				authCode = bank.getAuthCode(ccAnswer);
				account.setCC(ccAnswer);
			}
		}
		
		return authCode;
	}

	
	public boolean canViewOrMakeOrder()
	{
		if(currentAccount == null || cart == null)
		{
			System.out.println("\nYou are not currently logged in or cart is empty and cannot make an order.");
			return false;
		}
		return true;
	}
	
	
}
