import java.util.ArrayList;

import edu.duke.FileResource;

public class CharactersInPlay{

    private ArrayList<String> charNames;
    private ArrayList<Integer> counts;

    public CharactersInPlay(){
        charNames = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    void update(String person){
        int index = charNames.indexOf(person);
        if(index == -1){
            charNames.add(person);
            counts.add(1);
        }
        else{
            int value = counts.get(index);
            counts.set(index, value+1);
        }
    }

    void findAllCharacters(){
        charNames.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            int index = line.indexOf(".");
            if(index != -1){
                String person = line.substring(0, index);
                update(person);
            }
        }
    }

    void tester(){
        findAllCharacters();
        //for each main character, print out the main character, followed by the number of speaking parts that character has.
        //we define a main character as someone who has more than *1* speaking part
        for(int i=0; i<charNames.size(); i++){
            if(counts.get(i) > 1){
                System.out.println(charNames.get(i) + "\t" + counts.get(i));
            }
        }
    }

    void charactersWithNumParts(int num1,int num2){
        /*This method should print out the names of all those characters
         that have exactly number speaking parts, where number is greater 
         than or equal to num1 and less than or equal to num2. */

        for(int i=0; i<charNames.size(); i++){
            if(counts.get(i) >= num1 && counts.get(i) <= num2){
                System.out.println(charNames.get(i) + "\t" + counts.get(i));
            }
        }
    }

    public static void main(String[] args){

    }
}