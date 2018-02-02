import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Lawrence 
 * @version 2/1/18
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
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null)
            stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for (Product pro : stock) {
            if (pro.getID() == id) {
                return pro;
            }
        }
        return null;
    }
    
    /**
     * Try to find a product in the stock with the given name.
     * @return The identified product, or null if there is none
     *         with a matching name.
     */
    public Product findProduct(String name) {
        for (Product pro : stock)
            if (pro.getName().equals(name))
                return pro;
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product pro = findProduct(id);
        if (pro != null) {
            return pro.getQuantity();
        }
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product pro : stock) {
            System.out.println(pro.toString());
        }
    }
    
    /**
     * Print details for products that are low in stock.
     */
    public void low(int level) {
        for (Product pro : stock)
            if (pro.getQuantity() < level)
                System.out.println(pro.toString());
    }
}
