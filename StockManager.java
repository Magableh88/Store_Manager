import java.util.ArrayList;
import java.util.*;
//Mohammad Makableh
//Student ID: 202130654
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;    

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    //add Product method is modified to prevent two different products of same ID being added to stock list
    public void addProduct(Product item)
    {
        //if statement checks if the product ID is already being used before adding the item
        if(findProduct(item.getID()) == null){
            stock.add(item);
        }
        else{
            System.out.println("Product ID already in use. Please use another ID");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    //Delivery method increases the quantity of specific product after recieving a delivery
    public void delivery(int id, int amount)
    {
        //uses findProduct() method to add the new amount
        if(findProduct(id) != null){
            findProduct(id).increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    //Find product by ID method searches for the product in the list
    public Product findProduct(int id)
    {
        for(Product product : stock){
            if(product.getID() == id){
                return product;
            }
        }        
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    //This method tells the user how many units there are available of a certain product
    public int numberInStock(int id)
    {
        //temparally return 0 as a place holder
        //uses findProduct() function to look for product and determine its quantity
        if(findProduct(id) != null){
            return findProduct(id).getQuantity();
        }
        return 0;
    }

    /**
     * Print details of all the products.
     */
    //Prints the details of all available products in the list
    public void printProductDetails()
    {
        //Uses iterator to loop through the list and print the details
        Iterator it = stock.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }     
    }
    
    //This method prints list of the products low in stock based on a specific base set in the parameter
    public void lowStock(int base){
        //Uses a stream to filter through the list and get the products we are looking for
        stock.stream().filter(product -> product.getQuantity() < base).forEach(product -> System.out.println(product.toString()));
    }
    
    //Find product by Name method searches for the product in the list
    public Product findProduct(String name){
        //Searches for a product by name 
        for(Product product : stock){
            if(product.getName().equals(name)){
                return product;
            }
        }        
        return null;
    }
}
