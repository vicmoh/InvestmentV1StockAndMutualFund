/*Name: Vicky Mohamamd
 *ID: 0895381
 */
package stock;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * class for mutual fund
 * @author Vicky Mohammad
 */
public class MutualFund {
    //decalre var
    private String symbol, name;
    private int quantity = 0;
    private double price = 0, bookValue = 0;
    private double gain = 0; 
    DecimalFormat twoDecimal = new DecimalFormat();
    
    /**
     * constructor to create a new mutual 
     * @param symbol the symbol of the object
     * @param name the name of object
     * @param quaintity the amount
     * @param price of the object
     */
    public MutualFund(String symbol, String name, int quaintity, double price){
        //add books
        this.symbol = symbol;
        this.name = name;
        this.quantity = quaintity;
        this.price = price;
        this.bookValue = quantity * price;
    }//end func
    
    /**
     * get the symbol of the mutual fund
     * @return symbol of the mutual fund 
     */
    public String getSymmbol(){
        return symbol;
    }//end func
    
    /**
     * get the the name of mutual fund
     * @return name the mutual fund 
     */
    public String getName(){
        return name;
    }//end func
    
    /**
     * get the quantity
     * @return quantity the amount 
     */
    public int getQuantity(){
        return quantity;
    }//end func
    
    /**
     * get the price of the mutual fund
     * @return price of the object
     */
    public double getPrice(){
        return price;
    }//end func
    
    /**
     * get book value of mutual fund
     * @return book value of the object
     */
    public double getBookValue(){
        return bookValue;
    }//end func
    
    /**
     * change the price the new price
     * @param newPrice of the object
     */
    public void priceChanged(double newPrice){
        //set the new value when price is changed
        this.price = newPrice;
        gain = (quantity * newPrice - 45)- bookValue;
    }//end func
    
    /**
     * get the gain of mutual fund
     * @return the gain of the object
     */
    public double getGain(){
        priceChanged(price);
        return gain;
    }//end func
    
    /**
     * calculate the when buying 
     * @param price of the mutual
     * @param quantity of the mutual
     */
    public void buy(double price, int quantity ){
        int totalPreQuantity;
        totalPreQuantity = this.quantity;
        this.quantity = this.quantity + quantity;
        this.price = price;
        this.bookValue = bookValue * ((totalPreQuantity + (double)quantity)/totalPreQuantity);
    }//end if
    
    /**
     * calculate the quantity to sell
     * @param quantityToSell the amount 
     */
    public void sell(int quantityToSell){
        double paymentRecieved = 0;
        twoDecimal.setMaximumFractionDigits(2);
        if(this.quantity >= quantityToSell){
            double totalPreQuantity = this.quantity;
            this.quantity = this.quantity - quantityToSell;
            this.bookValue = this.bookValue * ((totalPreQuantity - (double)quantityToSell)/totalPreQuantity);
            //payment recieved after sell
            paymentRecieved = (quantityToSell * price) - 45;
            System.out.println("Payment received " + twoDecimal.format(paymentRecieved));
        }else{
            //payment recieved after sell
            paymentRecieved = (quantity * price) - 45;
            System.out.println("QUANTITY OUT OF BOUND");
            System.out.println("Selling what you have..");
            System.out.println("Payment received " + twoDecimal.format(paymentRecieved));
        }//end if
    }//end func
    
    /**
     * a function to print out the mutual fund
     * @return return the string of the object
     */
    @Override public String toString(){
       //set object of 2 decimal format
       twoDecimal.setMaximumFractionDigits(2);
       //display
       System.out.println("*************************************");
       System.out.println("Type: Mutual Fund");
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
