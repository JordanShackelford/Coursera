import java.util.ArrayList;
import edu.duke.*;
import org.apache.commons.csv.*;

class WordFrequencies{

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    void findUnique(){
        myWords.clear();
        myFreqs.clear();

        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }

    void tester(){
        //Add code to the tester method to determine and print the word that occurs t
        //he most often in a selected file and how many times it occurs. You should find it helpful to call findIndexOfMax.
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        //for each word, print the frequency and the word
        for(int i=0; i<myWords.size(); i++){
            System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
        }
    }

    int findIndexOfMax(){
        return -1;
        //"This method returns an int that is the index location of the largest value in myFreqs. If there is a tie, then return the first such value."
    }

    static public void main(String[] args){
        WordFrequencies wf = new WordFrequencies();
        wf.tester();
    }
}