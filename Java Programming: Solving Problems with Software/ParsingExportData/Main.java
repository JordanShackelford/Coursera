

import org.apache.commons.csv.*;
import edu.duke.*;

public class Main{

    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        listExportersTwoProducts(parser, "cotton", "flowers");

        parser = fr.getCSVParser();

        //how many countries export sugar?
        System.out.println(numberOfExporters(parser, "cocoa"));

        parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

    }

    public String countryInfo(CSVParser parser,String country){
        //format of the string is country followed by ":" followed by a list of the countries exports followed by ":" followed by the country's export value
        String countryInfo = "";
        for(CSVRecord record : parser){
            String countryName = record.get("Country");
            if(countryName.equals(country)){
                countryInfo = countryName + ":" + record.get("Exports") + ":" + record.get("Value (dollars)");
                break;
            } else {
                countryInfo = "NOT FOUND";
            }
        }
        return countryInfo;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        //This method prints the names of all the countries that have both exportItem1 and exportItem2 as export items
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        //returns the number of countries that export exportItem
        int numberOfExporters = 0;
        for(CSVRecord record : parser){
            String exports = record.get("Exports");
            if(exports.contains(exportItem)){
                numberOfExporters++;
            }
        }
        return numberOfExporters;
    }

    public void bigExporters(CSVParser parser, String amount){
        //This method prints the names of all the countries that have exports greater than amount
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");

            //if amount.length is greater than value.length, then it is a big exporter
            if(value.length() > amount.length()){
                System.out.println(record.get("Country"));
            }
        }
    }


    public static void main(String[] args){
        Main m = new Main();
        m.tester();
    }
}


