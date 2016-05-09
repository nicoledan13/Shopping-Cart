package com.shopping.cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    
	/*
	 * 
	 * Given the basket has 1 bread, 1 butter and 1 milk when I total the basket then the total should be £2.95
       Given the basket has 2 butter and 2 bread when I total the basket then the total should be £3.10
       Given the basket has 4 milk when I total the basket then the total should be £3.45
       Given the basket has 2 butter, 1 bread and 8 milk when I total the basket then the total should be £9.00
	 * 
	 * 
	 * 
	 */
   

    public static void main(String[] args) {
    	
    	System.out.println("************************************");
        System.out.println("* Welcome to Online Shopping *");
        System.out.println("************************************");
        System.out.println("Enter ***Q*** to Quit");
        System.out.println("Enter ***add*** to add to basket");
        System.out.println("Enter ***remove*** to remove from basket");
        System.out.println("Enter ***list*** to show a list of products in the inventory");
        System.out.println("Enter ***basket*** to show a list of products in your basket");
        System.out.println("Enter ***total*** to show the total price of the basket");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("Offers of this week:\n Buy 2 Butter and get a Bread at 50% off \n Buy 3 Milk and get the 4th Milk for free! \n Enjoy shopping! :)");
        System.out.println("************************************");
        System.out.println("************************************");
    	
        
        Scanner scanner = new Scanner(System.in);
        
    	Shopping shop=new Shopping();
    	shop.loadProducts();
    	
    	while (true) {
            String inputValue = scanner.next();

            if (inputValue.startsWith("add")) {
      
                shop.addToBasket();

            } else if (inputValue.startsWith("remove")) {
                shop.removeProductFromBasket();

            } else if (inputValue.startsWith("list")) {
                shop.loadProducts();

            } else if (inputValue.startsWith("total")) {
                shop.getTotal();
                
            } else if (inputValue.startsWith("basket")) {
                shop.displayBasket();   

            } else if ("Q".equalsIgnoreCase(inputValue)) {
                System.out.println("Thanks for shopping!");
                System.exit(0);
            }
        }
    }
    	
        
}

