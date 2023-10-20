package com.java.day6;

import java.util.Scanner;

// Class representing a product
class Product {
    String name;
    double price;

    // Constructor for initializing the product's name and price
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Class representing a shopping cart
class Cart {
    Product[] items;
    int itemCount;

    // Constructor for initializing the shopping cart with a given capacity
    Cart(int capacity) {
        items = new Product[capacity];
        itemCount = 0;
    }

    // Method to add a product to the cart
    void addItem(Product product) {
        if (itemCount < items.length) {
            items[itemCount] = product;
            itemCount++;
        }
    }

    // Method to calculate the total price of items in the cart
    double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].price;
        }
        return total;
    }
    double showPrice() {
    	
		return itemCount;
    	
    }
}

// Class representing a customer
class Customer {
    String name;
    Cart cart;

    // Constructor for initializing the customer's name and creating a shopping cart
    Customer(String name) {
        this.name = name;
        cart = new Cart(10); // The cart has a capacity of 10 items
    }
}

public class Prog4 {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0);
        Product product2 = new Product("Headphones", 50.0);

        Customer customer = new Customer("Alice");
        customer.cart.addItem(product1);
        customer.cart.addItem(product2);

        System.out.println("Customer: " + customer.name);
        System.out.println("Items in Cart:");
        for (Product item : customer.cart.items) {
            if (item != null) {
                System.out.println(item.name);
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Total Price: " + customer.cart.calculateTotal());
    }
}
