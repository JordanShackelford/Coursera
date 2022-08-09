import edu.duke.*;
import org.apache.commons.csv.*;

public class Part4{

    public static void main(String[] args){
        //create url resource
        URLResource resource = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");

        for(String item : resource.words()){
            //convert to lowercase
            String lowerItem = item.toLowerCase();
            //check if it contains youtube.com
            if(lowerItem.contains("youtube.com")){
                int beg;
                int end;
                //set starting index to first quote to the left of youtube.com
                beg = lowerItem.indexOf("\"");
                //set closing index to first quote to the right of youtube.com
                end = lowerItem.indexOf("\"", beg + 1);

                //print the non lower case version of the string between beg and end
                System.out.println(item.substring(beg + 1, end));

            }
        }

    }
}

