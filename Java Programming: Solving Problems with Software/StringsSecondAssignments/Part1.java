

public class Part1{

    public static String findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (currIndex == -1) {
            return "";
        } else {
            return dna.substring(startIndex, currIndex + 3);
        }
    }

    public static void testStopCodon(){
        String dna = "ATGAAATAA";
        String stopCodon = "TAA";
        System.out.println(findStopCodon(dna, 0, stopCodon));

        // example of dna string that has genes
        dna = "ATGAAATAAATGAAATAA";
        stopCodon = "TAA";
        System.out.println(findStopCodon(dna, 0, stopCodon));

        // example of dna string that has no genes
        dna = "ATGAATAAATGAAATAA";
        stopCodon = "TGA";
        System.out.println(findStopCodon(dna, 0, stopCodon));
    }

    public static String findGene(String dna){

        //Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }

        //Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.
        String firstTAA = findStopCodon(dna, startIndex, "TAA");
        String firstTAG = findStopCodon(dna, startIndex, "TAG");
        String firstTGA = findStopCodon(dna, startIndex, "TGA");
        
        //Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away. If there is no valid stop codon and therefore no gene, return the empty string.
        if (firstTAA.isEmpty() && firstTAG.isEmpty() && firstTGA.isEmpty()) {
            return "";
        } else if (firstTAA.isEmpty() && firstTAG.isEmpty()) {
            return dna.substring(startIndex, firstTGA.length() + startIndex);
        } else if (firstTAA.isEmpty()) {
            return dna.substring(startIndex, firstTAG.length() + startIndex);
        } else {
            return dna.substring(startIndex, firstTAA.length() + startIndex);
        }
    }

    public static void testFindGene(){
        // dna with no atg
        String dna = "ACGAAATAA";
        System.out.println(findGene(dna));

        // dna with ATG and one valid stop codon
        dna = "ATGAAATAA";
        System.out.println(findGene(dna));

        // dna with ATG and two valid stop codons
        dna = "ATGAAATAAATGAAATAA";
        System.out.println(findGene(dna));

        // dna with ATG and no valid stop codons
        dna = "ATGAAATCATCAAATCA";
        System.out.println(findGene(dna));

        // dna with no ATG and no valid stop codon
        dna = "ACGAAATCATCAAATCA";
        System.out.println(findGene(dna));

    }

    public static void printAllGenes(String dna){
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna.substring(startIndex));
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
            startIndex += currentGene.length();
        }
    }

    public static void main(String[] args){
        //testStopCodon();
        //testFindGene();
        printAllGenes("ATGCGATAAATGABCTGA");
    }

}