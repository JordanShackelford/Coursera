public class Part2{

    public static void findSimpleGene(String dna, String startCodon, String stopCodon){
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1) {
            System.out.println("No stop codon found");
            return;
        }
        int length = stopIndex - startIndex;
        if (length % 3 == 0) {
            System.out.println("Found gene");
            System.out.println(dna.substring(startIndex, stopIndex + 3));
        } else {
            System.out.println("No gene found");
        }
        
    }

    public static void testSimpleGene(){
        String[] dnaArray = {"ATGGTATAA", "atgttt", "aggttt","atgtcgtaa", "atgtcgttaa","AAATGCCCTAACTAGATTAAGAAACC"};

        for (String dna : dnaArray) {
            System.out.println("DNA string: " + dna);
            boolean isUpperCase = dna.equals(dna.toUpperCase());
            if(isUpperCase){
                findSimpleGene(dna, "ATG", "TAA");
            } else {
                findSimpleGene(dna, "atg", "taa");
            }

            //if atg and taa are found
            if (dna.indexOf("atg") != -1 && dna.indexOf("taa") != -1) {
                //if the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
                int length = dna.indexOf("taa") - dna.indexOf("atg");
                if (length % 3 == 0) {
                    System.out.println("Found gene");
                    String gene = dna.substring(dna.indexOf("atg"), dna.indexOf("taa") + 3);
                    if (isUpperCase) {
                        gene = gene.toUpperCase();
                    } else {
                        gene = gene.toLowerCase();
                    }
                    System.out.println(gene);
                } else {
                    System.out.println("No gene found");
                }
            } else {
                System.out.println("No gene found");
            }
        }
    }

    public static void main(String[] args){
        testSimpleGene();
    }
}