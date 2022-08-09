import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Main {

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldest = null;
        for(CSVRecord current : parser){
            if(coldest == null){
                coldest = current;
            }
            else{
                if(Double.parseDouble(current.get("TemperatureF")) < Double.parseDouble(coldest.get("TemperatureF"))){
                    coldest = current;
                }
            }
        }
        return coldest;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldest = coldestHourInFile(parser);
        System.out.println("Coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
    }

    public String fileWithColdestTemperature(){
        //This method should return a string that is the name of the csv from selected files that has the coldest temperature
        DirectoryResource dr = new DirectoryResource();
        String fileName = "";
        double coldestTemp = -1;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord coldest = coldestHourInFile(parser);
            if(coldestTemp == -1){
                coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
                fileName = f.getName();
            }
            else{
                if(Double.parseDouble(coldest.get("TemperatureF")) < coldestTemp){
                    coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
                    fileName = f.getName();
                }
            }
        }
        return fileName;
    }

    public void testFileWithColdestTemperature(){
        System.out.println("Coldest temperature was in file " + fileWithColdestTemperature());
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        //This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.
        CSVRecord lowest = null;
        for(CSVRecord current : parser){
            if(lowest == null){
                lowest = current;
            }
            else{
                if(Double.parseDouble(current.get("Humidity")) < Double.parseDouble(lowest.get("Humidity"))){
                    lowest = current;
                }
            }
        }
        return lowest;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowest = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        //This method returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found.
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowest = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord current = lowestHumidityInFile(parser);
            if(lowest == null){
                lowest = current;
            }
            else{
                if(Double.parseDouble(current.get("Humidity")) < Double.parseDouble(lowest.get("Humidity"))){
                    lowest = current;
                }
            }
        }
        return lowest;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        //This method returns the average temperature for the given file.
        double sum = 0;
        int count = 0;
        for(CSVRecord current : parser){
            sum += Double.parseDouble(current.get("TemperatureF"));
            count++;
        }
        return sum/count;
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        System.out.println("Average temperature was " + average);
    }

   public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
       //This method returns the average temperature for the given file with an average humidity greater than the given value.
       double sum = 0;
       int count = 0;
       for(CSVRecord current : parser){
           if(Double.parseDouble(current.get("Humidity")) > value){
               sum += Double.parseDouble(current.get("TemperatureF"));
               count++;
           }
       }
       return sum/count;
   }

   public void testAverageTemperatureWithHighHumidityInFile(){
         FileResource fr = new FileResource();
         CSVParser parser = fr.getCSVParser();
         double average = averageTemperatureWithHighHumidityInFile(parser, 80);
         System.out.println("Average temperature when high humidity is " + average);
   }

    public static void main(String[] args){
        Main m = new Main();
        //m.testFileWithColdestTemperature();
        m.testColdestHourInFile();
        //m.testFileWithColdestTemperature();
        //m.testLowestHumidityInFile();
        //m.testLowestHumidityInManyFiles();
        //m.testAverageTemperatureInFile();
        //m.testAverageTemperatureWithHighHumidityInFile();

    }
}
