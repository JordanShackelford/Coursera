public class Part1 {

    public static void findSimpleGene(String dna){

        //find index position of start codon 'atg'
        int startIndex = dna.indexOf("atg");
        //find index position of stop codon 'taa'
        int taaIndex = dna.indexOf("taa", startIndex + 3);
        //return empty string if no stop codon found
        if (taaIndex == -1) {
            System.out.println("No stop codon found");
            return;
        }
        //If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
        int length = taaIndex - startIndex;
        if (length % 3 == 0) {
            System.out.println("Found gene");
            System.out.println(dna.substring(startIndex, taaIndex + 3));
        } else {
            System.out.println("No gene found");
        }
    }

    public static void testSimpleGene(){
        String[] dnaArray = {"aggttt", "atgttt", "aggttt","atgtcgtaa", "atgtcgttaa"};

        for (String dna : dnaArray) {
            System.out.println("DNA string: " + dna);
            findSimpleGene(dna);
            
            //if atg and taa are found
            if (dna.indexOf("atg") != -1 && dna.indexOf("taa") != -1) {
                //if the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
                int length = dna.indexOf("taa") - dna.indexOf("atg");
                if (length % 3 == 0) {
                    System.out.println("Found gene");
                    System.out.println(dna.substring(dna.indexOf("atg"), dna.indexOf("taa") + 3));
                } else {
                    System.out.println("No gene found");
                }
            } else {
                System.out.println("No gene found");
            }
        }
    }

    public static void main(String[] args) {
        testSimpleGene();
    }
}

