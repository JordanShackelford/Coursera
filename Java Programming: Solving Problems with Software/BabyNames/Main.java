import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Main{

    public void printNames(){
        FileResource fr = new FileResource();
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if(numBorn <= 100){
                System.out.println("Name " + rec.get(0) + 
                                " Gender " + rec.get(1) + 
                                " Num Born " + rec.get(2));
            }
            
        }
    }

    public void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            
            totalBirths += numBorn;
            totalNames++;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
            }
            else if(rec.get(1).equals("F")){
                totalGirls += numBorn;
            }
            totalNames++;
            totalBirths += numBorn;
        }
        System.out.println("Total births " + totalBirths);
        System.out.println("Total Girls: " + totalGirls);
        System.out.println("Total Boys: " + totalBoys);
        System.out.println("Total Names:" + totalNames);
    }

    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender){
        String filename = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(filename);
        int rank = 1;
        int countForName = 0;

        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(rec.get(0).equals(name)){
                    countForName = Integer.parseInt(rec.get(2));
                }
            }
        }
        //if after loop, countForName is still 0, then name not found
        if(countForName == 0){
            return -1;
        }

        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(Integer.parseInt(rec.get(2)) > countForName){
                    rank++;
                }
            }
        }
        return rank;
    }

    public void testGetRank(){
        System.out.println(getRank(1971, "Mitch", "M"));
    }

    public String getName(int year,int rank,String gender){
        //this method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME”  is returned.
        String filename = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(filename);
        String name = "NO NAME";
        int currRank = 1;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){
                if(currRank == rank){
                    name = rec.get(0);
                }
                currRank++;
            }
        }
        return name;
    }

    public void testGetName(){
        System.out.println(getName(1980, 1, "M"));
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        //1.determine rank of name in the year they were born
        //2.print the name born in new year that is at the same rank and gender
        //3.out format would be "<name> born in <year> would be <newName> born in <newYear>"
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        System.out.println(name + " born in " + year + " would be " + newName + " born in " + newYear);
    }

    public int yearOfHighestRank(String name, String gender){
        //selects a range of files to process and returns an integer, the year for the highest rank with the name and gender
        DirectoryResource dr = new DirectoryResource();
        int highRank = 0;
        int highYear = 0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            int currYear = Integer.parseInt(f.getName().substring(3,7));
            int currRank = getRank(currYear,name,gender);
            //System.out.println("Inputs: " + name + ", " + "currYear: " + currYear + ", " + "gender: " + gender);
            //System.out.println("Year " + currYear + " Rank " + currRank);

            if(currRank > highRank){
                highRank = currRank;
                highYear = currYear;
            }
        }
        return highYear;
    }

    public void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mitch", "M"));
    }

    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int totalRanks = -1;
        int totalYears = -1;
        for(File f : dr.selectedFiles()){
            int currYear = Integer.parseInt(f.getName().substring(3,7));
            int currRank = getRank(currYear,name,gender);
            totalRanks += currRank;
            totalYears++;
        }
        //return totalRanks / totalYears as a double
        return (double)totalRanks / totalYears;
    }

    public void testGetAverageRank(){
        System.out.println("The average rank for the files selected is : " + getAverageRank("Jacob", "M"));
    }

    public static void main(String[] args){
        Main m = new Main();
        //m.testGetRank();
        //m.testGetName();
        //m.whatIsNameInYear("Isabella",2012,2014,"F");
        //m.testYearOfHighestRank();
        m.testGetAverageRank();
    }
}
