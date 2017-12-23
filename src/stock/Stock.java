/*Name: Vicky Mohamamd
 *ID: 0895381
 */
package stock;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * class for stock
 * @author Vicky Mohammad
 */
public class Stock {
    //decalre var
    private String symbol, name;
    private int quantity = 0;
    private double price = 0, bookValue = 0;
    private double gain = 0;  
    //set object of 2 decimal format
    DecimalFormat twoDecimal = new DecimalFormat();
    
    /**
     * a constructor to create a stock
     * @param symbol to initialize for the stock
     * @param name to initialize for the stock
     * @param quaintity to initialize for the stock
     * @param price to initialize for the stock
     */
    public Stock(String symbol, String name, int quaintity, double price){
        //add books
        this.symbol = symbol;
        this.name = name;
        this.quantity = quaintity;
        this.price = price;
        this.bookValue = quantity * price + 9.99;
    }//end func
    
    /**
     * function to get symbol of the object
     * @return symbol of the object
     */
    public String getSymmbol(){
        return symbol;
    }//end func
    
    /**
     * function to get the name
     * @return return the name of the stock
     */
    public String getName(){
        return name;
    }//end func
    
    /**
     * get the quantity of the stock
     * @return the quantity of the stock
     */
    public int getQuantity(){
        return quantity;
    }//end func
    
    /**
     * function to get price
     * @return the price of the stock
     */
    public double getPrice(){
        return price;
    }//end func
    
    /**
     * get the book value
     * @return  return the book value of the stock
     */
    public double getBookValue(){
        return bookValue;
    }//end func
    
    /**
     * get new price
     * @param newPrice set the new price 
     */
    public void priceChanged(double newPrice){
        //set the new value when price is changed
        this.price = newPrice;
        gain = (quantity * newPrice - 9.99)- bookValue;
    }//end func
    
    /**
     * get the price
     * @return return the gain
     */
    public double getGain(){
        //update the new price
        priceChanged(this.price);
        return gain;
    }//end func
    
    /**
     * calculate the stock when buying
     * @param price for calculating
     * @param quantity for calculation
     */
    public void buy(double price, int quantity ){
        int totalPreQuantity;
        totalPreQuantity = this.quantity;
        this.quantity = this.quantity + quantity;
        this.price = price;
        this.bookValue = bookValue * ((totalPreQuantity + (double)quantity)/totalPreQuantity);
    }//end if
    
    /**
     * calculate for selling the stock
     * @param quantityToSell the amount to sell
     */
    public void sell(int quantityToSell){
        double paymentRecieved = 0;
        twoDecimal.setMaximumFractionDigits(2);
        if(this.quantity >= quantityToSell){
            double totalPreQuantity;
            totalPreQuantity = quantity;
            quantity = quantity - quantityToSell;
            bookValue = bookValue * ((totalPreQuantity - (double)quantityToSell)/totalPreQuantity);
            //payment recieved after sell
            paymentRecieved = (quantityToSell * price) - 9.99;
            System.out.println("Payment received "  + twoDecimal.format(paymentRecieved));
        }else{
            paymentRecieved = (quantity * price) - 9.99;
            System.out.println("QUANTITY OUT OF BOUND");
            System.out.println("Selling what you have...");
            System.out.println("Payment received "  + twoDecimal.format(paymentRecieved));
        }//end if
    }//end func
    
    /**
     * print the output of the stock
     * @return return the string of the stock
     */
    @Override public String toString(){
        twoDecimal.setMaximumFractionDigits(2);
        //display
        System.out.println("*************************************");
        System.out.println("Type: Stock");
        System.out.println("Symbol: " + symbol);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + twoDecimal.format(price));
        System.out.println("Book Value: $" + twoDecimal.format(bookValue));
        System.out.println("*************************************");
        return String.format("\nSymbol: " + symbol +
              "\nName: " + name +
              "\nQuanity: " + quantity +
              "\nPrice: $" + price +
              "\nStock value: $" + bookValue);
    }//end func
}//end class
