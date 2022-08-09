public class Part3{

    public static void findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        int taaIndex = dna.indexOf("TAA", startIndex + 3);
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

    public static int countGenes(String dna){
        //return the number of genes found in dna
        int count = 0;
        int startIndex = dna.indexOf("atg");
        while (startIndex != -1) {
            int taaIndex = dna.indexOf("taa", startIndex + 3);
            if (taaIndex != -1) {
                count++;
                startIndex = dna.indexOf("atg", taaIndex + 3);
            } else {
                break;
            }
        }
        return count;
    }

    public static void testCountGenes(){
        //test countGenes
        String[] dnaArray = {"ATGGTATAA", "atgttt", "aggttt","atgtcgtaa", "atgtcgttaa","AAATGCCCTAACTAGATTAAGAAACC"};
        for (String dna : dnaArray) {
            System.out.println("DNA string: " + dna);
            System.out.println("Number of genes: " + countGenes(dna));
        }
    }

    public static void main(String[] args){
        //testCountGenes();

        //print the first gene found for “AATGCTAACTAGCTGACTAAT”
        //String dna = "AATGCTAACTAGCTGACTAAT";
        //findSimpleGene(dna);

        System.out.println(7 % 2 == 0);
    }
}