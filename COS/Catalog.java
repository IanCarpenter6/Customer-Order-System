package COS;

import java.util.ArrayList;

public class Catalog 
{
    ArrayList<Product> products = new ArrayList<>();

    public void loadProducts() 
    {
        Product product1 = new Product(101, "Parley x UltraBoost 4.0", "eco-friendly footwear\ncollaborating with Parley to create\nwith entirely recycled material.", 179.99, 139.99, 0);
        Product product2 = new Product(102, "Timberland's 6 inch Clasic boot", "Classic durability from Timberland's", 159.99, 120.55, 0);
        Product product3 = new Product(103, "Air Jordan Retro High OG 'Turbo Green'", "A textured white leather base\ncontrasted by soft suede overlays in Tubro Green.", 636.22, 525.25, 0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    public void printCatalog() 
    {
        for(Product product: products) 
        {
            System.out.println("\nProduct #"+product.getId()+"\nName: "+product.getProductName()+"\nDescription: "+product.getDescription()+"\nPrice: $"+product.getPrice()+ "\nSales Price: $"+product.getSalesPrice());
        }
    }
    
    public Product getProduct(int idP)
    {
    	for(Product product: products)
    	{
    		if(idP==product.getId())
    		{
    			return product;
    		}
    	}
    	return null;
    }
}