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

    public static void main(String[] args){

    }
}