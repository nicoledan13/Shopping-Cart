package com.shopping.cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Shopping {

	private static ArrayList<Item> products ;
	private static ArrayList<Item> basket = new ArrayList<Item>();
	

	Scanner input=new Scanner(System.in);
	
	public void loadProducts()
	{
		products = new ArrayList<Item>();
		String csvFile = "product-data.csv";
     	BufferedReader br = null;
     	String line = "";
     	String cvsSplitBy = ",";

     	try {

     		br = new BufferedReader(new FileReader(csvFile));
     		String line1;
     		int iteration = 0;
     		while ((line1 = br.readLine()) != null) {
     			
     		if(iteration == 0) {
     		        iteration++;  
     		        continue;
     		    }

     		// use comma as separator
     		String[] readLine = line1.split(cvsSplitBy);
     			
     	  
     	   Item object=new Item();
     	   object.setName(readLine[0]);
     	   object.setPrice(readLine[1]); 
     	   
    	   products.add(object);
     			
     		}

     	} catch (FileNotFoundException e) {
     		e.printStackTrace();
     	} catch (IOException e) {
     		e.printStackTrace();
     	} finally {
     		if (br != null) {
     			try {
     				br.close();
     			} catch (IOException e) {
     				e.printStackTrace();
     			}
     		}
     	}      
    	
     	System.out.println("You can choose and buy from this range of products:");
    	for(Item x:products)
    	{
    		System.out.println("Name: "+x.getName()+"	Price: £"+x.getPrice());
    	}
	}
	
	
	public void addToBasket()
	{
		System.out.println("Input the name of the product you want to shop: eg. Butter,Milk or Bread");
		
		String name=input.next();
		
		if(name.equals("Butter") || name.equals("Milk") || name.equals("Bread")){
				System.out.println("Input the quantity:");
				int quantity=input.nextInt();
				
				for(Item x:products)
				{
					if(name.equals(x.getName()))
						{
						            x.setQuantity((x.getQuantity()+quantity));
									basket.add(x);
									System.out.println("Item added to the basket!");
								
							}
		
				}
					
				
				
				/*for(Item y:basket)
				{
					System.out.println("Name: "+y.getName()+"	Price: £"+y.getPrice()+"	Quantity: "+y.getQuantity());
				}*/
		
		}
		else
			System.out.println("This product is not available. Please try shopping an existing product. eg:Butter, Milk or Bread ");
	}
	
	
	
	
	public void displayBasket()
	{
		System.out.println("Your basket is: ");
		if(basket.size()==0)
			System.out.println("Your basket is empty...\n Do some shopping! :) ");
		else
		{
			for(Item y:basket)
			{
				System.out.println("Name: "+y.getName()+"	Price: £"+y.getPrice()+"	Quantity: "+y.getQuantity());
			}
		}
	}
	
	
	
	
	public void removeProductFromBasket()
	{
		System.out.println("Remove items from your shopping basket:...");
        System.out.println("Input the item name you want to remove:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
		System.out.println("Input the quantity that you want to remove:");
		int quantity=scanner.nextInt();
	    
		
		ListIterator<Item> listIterator = basket.listIterator();
		
		while(listIterator.hasNext()){
			Item item = listIterator.next();
			if(input.equals(item.getName()))
			  {
				if(quantity < item.getQuantity()){
					item.setQuantity(item.getQuantity()-quantity);
					System.out.println("Item removed.");
				}
				else if(quantity == item.getQuantity()) {
					listIterator.remove();
					System.out.println("Item removed.");
				}
				else {
					System.out.println("Invalid Quantity");
				}
			  }
		}
	}


	


	public void getTotal() {

		double milkPrice = 0.0;
		double butterPrice = 0.0;
		double breadPrice = 0.0;

		for (Item item : products) {
			if (item.getName().equals("Butter")) {
				butterPrice = item.getPrice();
			} else if (item.getName().equals("Milk")) {
				milkPrice = item.getPrice();
			} else if (item.getName().equals("Bread")) {
				breadPrice = item.getPrice();
			}
		}

		// System.out.println("We have following promotions:\n Buy 2 Butter and get a Bread at 50% off \n Buy 3 Milk and get the 4th milk for free");
		double total = 0;
		int breadQuantity = 0;
		int butterQuantity = 0;
		for (Item y : basket) {
			if (y.getName().equals("Bread")) {
				breadQuantity = y.getQuantity();
			}
			if (y.getName().equals("Milk")) {
				int milkQuantity = y.getQuantity();
				int discountedQuantity = milkQuantity - (milkQuantity / 3);
				total = total + ((double)discountedQuantity * milkPrice);
			}
			if (y.getName().equals("Butter")) {
				butterQuantity = y.getQuantity();
				total = total + (butterQuantity * butterPrice);
			}
		}
		
		if(butterQuantity >=2 && breadQuantity >0){
			total = total + ((breadQuantity-1)*breadPrice)+((double)breadPrice/2);
		}
		else {
			total = total + (breadQuantity*breadPrice);
		}
		
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		String totalValue = decimalFormat.format(total);
		
		System.out.println("Total amount of the basket is: £"+totalValue);

	}
	
	
	

}
