
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        boolean isUpper = false;
        String dnaUC = dna.toUpperCase();
        if (dna == dnaUC) {
            isUpper = true;
        }
        String result = "";
        String effectiveStartCodon = isUpper ? startCodon.toUpperCase() : startCodon.toLowerCase();
        String effectiveStopCodon = isUpper ? stopCodon.toUpperCase() : stopCodon.toLowerCase();
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        if ((stopIndex-(startIndex+3)) % 3 == 0) {
        result = dna.substring(startIndex, stopIndex+3);
        }
        return result;
    }
    
    public void testFindSimpleGene() {
        String dna = "AATGCGTAATATGGT";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("DNA strand is  " + dna);
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATAGCTAGGGTAATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AATGCTAGGGTAGATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "AACTGCTAGGGTACATATGGT";
        startCodon = "ATG";
        stopCodon = "TAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
        
        dna = "aatgctagggtaatatggt";
        startCodon = "atg";
        stopCodon = "taa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is " + gene);
    }
}
