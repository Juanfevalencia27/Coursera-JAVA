
/**
 * Write a description of Part2 here.
 * This assignment will determine if a DNA strand has a gene in it by using the simplified 
 * algorithm from the lesson, but organizing the code in a slightly different way. 
 * You will modify the method findSimpleGene to have three parameters, one for the DNA string,
 * one for the start codon and one for the stop codon.

Specifically, you should do the following:
1. Create a new Java Class named Part2 in the StringsFirstAssignments project.

2. Copy and paste the two methods findSimpleGene and testSimpleGene from the 
Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. 
Modify findSimpleGene to add two additional parameters, one named startCodon for 
the start codon and one named stopCodon for the stop codon. 
What additional changes do you need to make for the program to compile? 
After making all changes, run your program to check that you get the same output as before.

4. Modify the findSimpleGene method to work with DNA strings that are either all uppercase 
letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. 
Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, 
the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer 
with lowercase letters, the gene “atgctataa”. HINT: there are two string methods 
toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results 
in the string “atgtaa”.

 * @author (Theary Im) 
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
