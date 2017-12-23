/*Name: Vicky Mohamamd
 *ID: 0895381
 */
package stock;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

//create class
public class Portfolio {
    //declare var
    ArrayList<Stock> stock = new ArrayList<Stock>();
    ArrayList<MutualFund> mutualFund = new ArrayList<MutualFund>();
    
    /**
     * function to get the stock in the list
     * @param x the element of the list
     * @return the stock of the list
     */
    public Stock getStockList(int x){
        return stock.get(x);
    }//end func
    
    /**
     * get the mutual fund of the list
     * @param x the element of the list
     * @return the mutual fund
     */
    public MutualFund getMutualList(int x){
        return mutualFund.get(x);
    }//end func
    
    /**
     * add a new stock to the portfolio
     * @param symbol of the object
     * @param name of the object
     * @param quaintity of the object
     * @param price of the object
     */
    public void addStock(String symbol, String name, int quaintity, double price){
        stock.add(new Stock(symbol, name, quaintity, price));
    }//end func
    
    /**
     * add a mutual fund to the portfolio
     * @param symbol of the object
     * @param name of the object
     * @param quaintity of the object
     * @param price of the object
     */
    public void addMutual(String symbol, String name, int quaintity, double price){
        mutualFund.add(new MutualFund(symbol, name, quaintity, price));
    }//end func
    
    /**
     * print all the list
     */
    public void toStringStockList(){
        //set object of 2 decimal format
        DecimalFormat twoDecimal = new DecimalFormat();
        twoDecimal.setMaximumFractionDigits(2);
        //display book 
        for(int x = 0; x < stock.size();x++){
            stock.get(x).toString();
        }//end for
        for(int x = 0; x < mutualFund.size();x++){
            mutualFund.get(x).toString();
        }//end for
    }//end func
}//end class
