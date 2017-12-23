/*Name: Vicky Mohamamd
 *ID: 0895381
 */
package stock;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *menu class for user interface to buy stock
 */ 
public class Menu {
    //declare var
    private static String menu = " ", input = " ";
    private static String symbol = " ", name= " ", search = " ";
    private static double price = 0, bookValue = 0;
    private static int quantity = 0;
    private static String searchRange = " ";
    //dieclare objects
    private static Scanner scan = new Scanner(System.in);
    private static Portfolio list = new Portfolio();
    DecimalFormat twoDecimal = new DecimalFormat();
    
    /**
     * main function
     * @param args for the command line input
     */
    public static void main(String[] args) {
        //loop till program exit
        while(!menu.equalsIgnoreCase("quit")){
            //print all for debug
            //list.toStringStockList();
            //display the options
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Update");
            System.out.println("4. GetGain");
            System.out.println("5. Search");
            System.out.println("6. Quit"); 
            //ask the user for option
            System.out.println("[Enter the number or the command]");
            System.out.print("Which Option do you want: ");
            menu = scan.nextLine();
            //choosing the menu option
            if(menu.equalsIgnoreCase("buy") || menu.equals("1")){
                option1();
            }else if(menu.equalsIgnoreCase("sell") || menu.equals("2")){
                option2();
            }else if(menu.equalsIgnoreCase("update") || menu.equals("3")){
                option3();
            }else if(menu.equalsIgnoreCase("getgain") || menu.equals("4")){
                option4();
            }else if(menu.equalsIgnoreCase("search") || menu.equals("5")){   
                option5();
            }else if(menu.equalsIgnoreCase("quit") || menu.equals("6") || menu.equalsIgnoreCase("q")){
                System.out.println("Program has exited.");
                System.exit(0);
            }else{
                System.out.println("PLEASE ENTER THE AVAILABLE MENU");
            }//end if
        }//end if
    }//end main
    
    /**
     * a function to catch wrong format for int 
     * @param toBeConverted from the input to int
     * @return -1 if wrong format
     */
    public static int tryCatchInt(String toBeConverted){
        int number = 0;
        try{
            number = Integer.parseInt(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    /**
     * a function to catch wrong format for int 
     * @param toBeConverted from input to int
     * @return -1 if wrong format
     */
    public static double tryCatchDouble(String toBeConverted){
        double number = 0;
        try{
            number = Double.parseDouble(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    /**
     * a function to ask symbol
     */
    public static void askSymbol(){
        //enter symbol
        do{
            System.out.print("Enter Symbol: ");
            symbol = scan.nextLine();
        }while(symbol.equals(""));
    }//end func
    
    /**
     * a function to ask name
     */
    public static void askName(){
        //enter name
        do{
            System.out.print("Enter Name: ");
            name = scan.nextLine();
        }while(name.equals(""));
    }//end func
    
    /**
     * function ask quantity
     */
    public static void askQuantity(){
        //enter quanity
        do{
            System.out.print("Enter Quantity: ");
            input = scan.nextLine();
            quantity = tryCatchInt(input);
        }while(quantity < 0);
    }//end func
    
    /**
     * function ask price
     */
    public static void askPrice(){
        do{
            //enter quanity
            System.out.print("Enter Price: ");
            input = scan.nextLine();
            price = tryCatchDouble(input);
        }while(price < 0);
    }//end func
    
    /**
     * ask price for the search
     * @return the -1 if error
     */
    public static double askPriceForSearch(){
        double number = 0;
        //enter quanity
        System.out.print("Enter Price: ");
        searchRange = scan.nextLine();
        //if wrong formate enter -1
        try{
            price = Double.parseDouble(searchRange);
        }catch(NumberFormatException E){
            return number = -1;
        }//end catch
        return number;
    }//end func
    
    public static void askType(){
        //ask the user for the type
        boolean flag = false;
        do{
            //print and ask option
            System.out.println("1. Stock");
            System.out.println("2. MutualFund");
            System.out.print("Enter Option: ");
            menu = scan.nextLine();
            if(menu.equalsIgnoreCase("Stock")){
                flag = true;
            }else if(menu.equalsIgnoreCase("MutualFund")){
                flag = true;
            }else if(menu.equalsIgnoreCase("1")){
                flag = true;
            }else if(menu.equalsIgnoreCase("2")){
                flag = true;
            }//end if
        }while(flag == false);
    }//end if

    /**
     * option 1
     */
    public static void option1(){
        //ask the user
        askType();
        //option for stock and mutual fund
        if(menu.equalsIgnoreCase("stock") || menu.equals("1")){
            askSymbol();
            askName();
            askQuantity();
            askPrice();
            //check if it exist
            int found = 0;
            for(int x=0; x<list.stock.size(); x++){
                if (list.stock.get(x).getSymmbol().equalsIgnoreCase(symbol)){
                    System.out.println("Found existing symbol");
                    System.out.println("Buying more existing investment...");
                    list.stock.get(x).buy(price, quantity);
                    found = 1;
                    break;
                }//end if
            }//end for
            if(found == 0){
                //add the stock list
                list.addStock(symbol, name, quantity, price); 
            }//end if
        }else if(menu.equalsIgnoreCase("mutualfund") || menu.equals("2")){
            askSymbol();
            askName();
            askQuantity();
            askPrice();                  
            //check if it exist
            int found = 0;
            for(int x=0; x<list.mutualFund.size(); x++){
                if (list.mutualFund.get(x).getSymmbol().equalsIgnoreCase(symbol)){
                    System.out.println("Buying existing investment...");
                    list.mutualFund.get(x).buy(price, quantity);
                    found = 1;
                    break;
                }//end if
            }//end for
            if(found == 0){
                //add the mutual list
                list.addMutual(symbol, name, quantity, price); 
            }//end if
        }//end if
    }//end func
    
    /**
     * option 2
     */
    public static void option2(){
        //ask which list you want to sell
        askType();         
        //option choice to sell
        if(menu.equalsIgnoreCase("stock") || menu.equals("1")){
            //declare var
            int found = 0;
            //ask user input
            askSymbol();
            //search for the symbol of stock
            for(int x = 0; x < list.stock.size();x++){
                if(list.stock.get(x).getSymmbol().equalsIgnoreCase(symbol)){
                    //print and sell
                    list.stock.get(x).toString();
                    found = 1;//flag for found
                    //if symbol found ask the user
                    System.out.println("Symbol found...");
                    askQuantity();
                    askPrice();
                    //System.out.println("Comparing: " + quantity + ">" + list.stock.get(x).getQuantity());
                    //remove the invesment
                    list.stock.get(x).priceChanged(price);
                    if(quantity >= list.stock.get(x).getQuantity()){
                        list.stock.get(x).sell(quantity);
                        list.stock.remove(x);
                    }else{
                        list.stock.get(x).sell(quantity);
                    }//end if
                }//end if
            }//end list
            if(found != 1){
                System.out.println("COULD NOT FIND SYMBOL");
            }//end if
        }else if(menu.equalsIgnoreCase("mutualfund") || menu.equals("2")){
            //declare var
            int found = 0;
            //ask user input
            askSymbol();
            //search for the symbol of mutual fund
            for(int x = 0; x < list.mutualFund.size();x++){
                if(list.mutualFund.get(x).getSymmbol().equalsIgnoreCase(symbol)){
                    //print and sell
                    list.mutualFund.get(x).toString();
                    found = 1;//flag for found
                    //if symbol found ask the user
                    System.out.println("Symbol found...");
                    askQuantity();
                    askPrice();
                    //for debug
                    //System.out.println("Comparing: " + quantity + ">" + list.mutualFund.get(x).getQuantity());
                    //remove the invesment and update the price
                    list.mutualFund.get(x).priceChanged(price);
                    if(quantity >= list.mutualFund.get(x).getQuantity()){
                        list.mutualFund.get(x).sell(quantity);
                        list.mutualFund.remove(x);
                    }else{
                        list.mutualFund.get(x).sell(quantity);
                    }//end if
                }//end if
            }//end list
            if(found != 1){
                System.out.println("COULD NOT FIND SYMBOL");
            }//end if
        }//end if
    }//end func
       
    /**
     * option 3
     */
    public static void option3(){
        if(list.stock.size() != 0){
            for(int x = 0; x < list.stock.size();x++){
                //ask for the price
                do{
                    System.out.print("Enter the new updated price for (" + list.stock.get(x).getName() + ") stock: ");
                    input = scan.nextLine();
                    price = tryCatchDouble(input);
                }while(price < x);
                //update the new price
                list.getStockList(x).priceChanged(price);
            }//end for
        }//end if
        if(list.mutualFund.size() != 0){
            for(int x = 0; x < list.mutualFund.size();x++){
                //ask for the price
                do{
                    System.out.print("Enter the new updated price for (" + list.mutualFund.get(x).getName() + ") mutual fund: ");
                    input = scan.nextLine();
                    price = tryCatchDouble(input);
                }while(price < x);
                //update the new price
                list.getMutualList(x).priceChanged(price);
            }//end for
        }//end if
        if(list.mutualFund.size() == 0 && list.stock.size() == 0){
            System.out.println("No investment available");
        }//end if
    }//end func
            
    /**
     * option 4
     */
    public static void option4(){
        DecimalFormat decimalGain = new DecimalFormat();
        decimalGain.setMaximumFractionDigits(2);
        double totalGain = 0;
        //add all the gain in the list
        if(list.stock.size() != 0){
            for(int x=0; x<list.stock.size();x++){
                totalGain = totalGain + list.stock.get(x).getGain();           
                System.out.println("Your gain for Stock is " + decimalGain.format(list.stock.get(x).getGain()));
            }//end for
        }//end if
        if(list.mutualFund.size() != 0){
            for(int x=0; x<list.mutualFund.size();x++){
                totalGain = totalGain + list.mutualFund.get(x).getGain();
                System.out.println("Your gain for Mutual is " + decimalGain.format(list.mutualFund.get(x).getGain()));
            }//end for
        }//end if
        System.out.println("Your total gain " + decimalGain.format(totalGain));
    }//end func
    
    /**
     * option 5
     */
    public static void option5(){
        //decalre var
        double inputPrice;
        //enter user input
        
        //enter symbol
        System.out.print("Enter Symbol: ");
        symbol = scan.nextLine();

        //enter name
        System.out.print("Enter KeyWord: ");
        name = scan.nextLine();
 
        inputPrice = askPriceForSearch();
        //find the inverstment in the listS
        if(list.stock.size() != 0){
            //declare var
            int match = 0;
            //check for stock the list
            for(int x = 0; x < list.stock.size();x++){ 
                //check for the are a match
                String[] splitName = name.split(" ");
                String[] splitListName = list.stock.get(x).getName().split(" ");;
                for(int y = 0; y < splitName.length; y++){    
                    for(int z = 0; z < splitListName.length; z++){
                        if(splitName[y].equals(splitListName[z])){
                            match++;
                        }//end if
                    }//end for
                }//end for loop
                
                //for debuging
                //System.out.println("S: " + symbol + "N: " + name + "IP: " + inputPrice);
                
                //check print the name if it match
                if(symbol.equals("") == true && name.equals("") == true && searchRange.equals("") == true){
                    for(int y = 0; y<list.stock.size(); y++){
                        list.stock.get(y).toString();
                    }//end if
                    break;
                }else if(match >= splitName.length && searchRange.equals("") == true && symbol.equals("") == true){
                    list.stock.get(x).toString();
                }else if(symbol.equalsIgnoreCase(list.stock.get(x).getSymmbol()) && searchRange.equals("") == true && name.equals("") == true){
                    list.stock.get(x).toString();
                }else if(symbol.equals("") == true && name.equals("") == true && searchRange.equals("") != true){
                    checkRangeValueForStock(x);
                }else if(match >= splitName.length && searchRange.equals("") != true && symbol.equals("") == true){ 
                    checkRangeValueForStock(x);
                }else if(symbol.equalsIgnoreCase(list.stock.get(x).getSymmbol()) && searchRange.equals("") != true && name.equals("") == true){
                    checkRangeValueForStock(x);
                }else if(symbol.equalsIgnoreCase(list.stock.get(x).getSymmbol()) && searchRange.equals("") == true && match >= splitName.length){
                    list.stock.get(x).toString();
                }else if(symbol.equalsIgnoreCase(list.stock.get(x).getSymmbol()) && searchRange.equals("") != true && match >= splitName.length){
                    checkRangeValueForStock(x);
                }//end if
                match = 0;
            }//end for
        }//end if
        
        if(list.mutualFund.size() != 0){
            //declare var
            int match = 0;
            //check for stock the list
            for(int x = 0; x < list.mutualFund.size();x++){ 
                //check for the are a match
                String[] splitName = name.split(" ");
                String[] splitListName = list.mutualFund.get(x).getName().split(" ");;
                for(int y = 0; y < splitName.length; y++){    
                    for(int z = 0; z < splitListName.length; z++){
                        if(splitName[y].equals(splitListName[z])){
                            match++;
                        }//end if
                    }//end for
                }//end for loop
                
                //for debuging
                //System.out.println("S: " + symbol + "N: " + name + "IP: " + inputPrice);
                
                //check print the name if it match
                if(symbol.equals("") == true && name.equals("") == true && searchRange.equals("") == true){
                    for(int y = 0; y<list.mutualFund.size(); y++){
                        list.mutualFund.get(y).toString();
                    }//end if
                    break;
                }else if(match >= splitName.length && searchRange.equals("") == true && symbol.equals("") == true){
                    list.mutualFund.get(x).toString();
                }else if(symbol.equalsIgnoreCase(list.mutualFund.get(x).getSymmbol()) && searchRange.equals("") == true && name.equals("") == true){
                    list.mutualFund.get(x).toString();
                }else if(symbol.equals("") == true && name.equals("") == true && searchRange.equals("") != true){
                    checkRangeValueForMutual(x);
                }else if(match >= splitName.length && searchRange.equals("") != true && symbol.equals("") == true){ 
                    checkRangeValueForMutual(x);
                }else if(symbol.equalsIgnoreCase(list.mutualFund.get(x).getSymmbol()) && searchRange.equals("") != true && name.equals("") == true){
                    checkRangeValueForMutual(x);
                }else if(symbol.equalsIgnoreCase(list.mutualFund.get(x).getSymmbol()) && searchRange.equals("") == true && match >= splitName.length){
                    list.mutualFund.get(x).toString();
                }else if(symbol.equalsIgnoreCase(list.mutualFund.get(x).getSymmbol()) && searchRange.equals("") != true && match >= splitName.length){
                    checkRangeValueForMutual(x);
                }//end if
                match = 0;
            }//end for
        }//end if
    }//end func
    
    /**
     * check check the range value
     * @param x for the element of the list
     */
    public static void checkRangeValueForStock(int x){
        //if it is in the price range then print
        if(searchRange.matches(".*\\d+.*-.*\\d+.*")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            double num2 = Double.parseDouble(split[1]);
            //System.out.println("Plit 1: " + split[0]);
            //System.out.println("Plit 2: " + split[1]);
            if(num1 <= list.stock.get(x).getPrice() && list.stock.get(x).getPrice() <= num2){
                list.stock.get(x).toString();
            }//end if
        }else if(searchRange.matches("-.*\\d+.*")){
            String[] split = searchRange.split("-");
            double num2 = Double.parseDouble(split[1]);
            if(list.stock.get(x).getPrice() <= num2){
                list.stock.get(x).toString();
            }//end if
        }else if(searchRange.matches(".*\\d+.*-")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            //System.out.println("Plit 1: " + split[0]);
            if(list.stock.get(x).getPrice() >= num1){
                list.stock.get(x).toString();
            }//end if
        }else if(searchRange.matches(".*\\d+.*")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            //System.out.println("Plit 1: " + split[0]);
            if(list.stock.get(x).getPrice() == num1){
                list.stock.get(x).toString();
            }//end if
        }//end if
    }//end func
    
    /**
     * check check the range value
     * @param x for the element of the list
     */
    public static void checkRangeValueForMutual(int x){
        //if it is in the price range then print
        if(searchRange.matches(".*\\d+.*-.*\\d+.*")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            double num2 = Double.parseDouble(split[1]);
            //System.out.println("Plit 1: " + split[0]);
            //System.out.println("Plit 2: " + split[1]);
            if(num1 <= list.mutualFund.get(x).getPrice() && list.mutualFund.get(x).getPrice() <= num2){
                list.mutualFund.get(x).toString();
            }//end if
        }else if(searchRange.matches("-.*\\d+.*")){
            String[] split = searchRange.split("-");
            double num2 = Double.parseDouble(split[1]);
            if(list.mutualFund.get(x).getPrice() <= num2){
                list.mutualFund.get(x).toString();
            }//end if
        }else if(searchRange.matches(".*\\d+.*-")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            //System.out.println("Plit 1: " + split[0]);
            if(list.mutualFund.get(x).getPrice() >= num1){
                list.mutualFund.get(x).toString();
            }//end if
        }else if(searchRange.matches(".*\\d+.*")){
            String[] split = searchRange.split("-");
            double num1 = Double.parseDouble(split[0]);
            //System.out.println("Plit 1: " + split[0]);
            if(list.mutualFund.get(x).getPrice() == num1){
                list.mutualFund.get(x).toString();
            }//end if
        }//end if
    }//end func
}//end class