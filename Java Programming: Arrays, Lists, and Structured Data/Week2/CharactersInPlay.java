import java.util.ArrayList;

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

    public static void main(String[] args){

    }
}