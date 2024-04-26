package com.convert2;

import java.io.IOException;
import java.util.Scanner;

// API KEY: e6aa23dc869b134f5bb179e7
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException, InterruptedException
    {
        Scanner scan = new Scanner(System.in);
        do{
            
            System.out.println( "*************************************************************" );
            System.out.println( "Welcome to the currency converter :)" );
            System.out.println("Type the currency(nomenclature) which you have: ");
            String actualCurrency = scan.nextLine().toUpperCase();
            System.out.println("Type the currency(nomenclature) which you want to convert: ");
            String newCurrency = scan.nextLine().toUpperCase();
            System.out.println("Type the amount: ");
            double amount = Integer.valueOf(scan.nextLine());
            CurrencyConnector connector = new CurrencyConnector();
            Convertion conversion = new Convertion(actualCurrency, newCurrency, amount);
            conversion.convertRates(connector.processResponse(conversion.getActualCurrency()));
            System.out.println("Result: " + conversion.getAmount() + " " + conversion.getActualCurrency() + " is " + conversion.getConversion() + " " + conversion.gettargetCurrency());
            conversion.saveConvertion(conversion);
        }while(true);
        
    }


}
