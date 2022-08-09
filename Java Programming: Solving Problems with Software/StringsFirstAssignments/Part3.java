public class Part3{

    public static boolean twoOccurrences(String stringa, String stringb){
        int count = 0;
        int index = stringb.indexOf(stringa);
        while (index != -1) {
            count++;
            index = stringb.indexOf(stringa, index + 1);
        }
        if (count > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void testing(){
        String[][] stringPairs = { 
            {"by","A story by Abby Long"},
            {"a","banana"}, 
            {"atg","ctgtatgta"} 
        };

        //test twoOccurrences on each string pair
        for (String[] pair : stringPairs) {
            //print out the string pair
            System.out.println("String pair: " + pair[0] + ", " + pair[1]);
            //print out the result of calling twoOccurrences
            System.out.println("Result of calling twoOccurrences: " + twoOccurrences(pair[0], pair[1]));
        }

        stringPairs = new String[][]{
            {"an","banana"}, 
            {"zoo","forest"},
            {"bitch","bitchnigga"},
            {"base","baseball"}
        };

        //test lastPart on each string paid
        for (String[] pair : stringPairs) {
            
            //print out the result of calling lastPart
            System.out.println("The part of the string after " + pair[0] + " in " + pair[1] + " is " + lastPart(pair[0], pair[1]));
        }
    }

    public static String lastPart(String stringa, String stringb){
        //if string a is not found in string b, return string b
        if (stringb.indexOf(stringa) == -1) {
            return stringb;
        } else {
            //if string a is found in string b, return the substring that starts with the last occurrence of string a and ends with the last occurrence of string b
            int index = stringb.indexOf(stringa);
            String word = stringb.substring(index + stringa.length());
            return word;
        }
    }


    public static void main(String[] args){
        testing();
    }
}