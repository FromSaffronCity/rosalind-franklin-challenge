import java.util.Scanner;
import java.util.ArrayList;

public class BioinformaticsStronghold {
    private static Scanner scanner = new Scanner(System.in);

    private static float computingGCContent(String dnaString) {
        int gc_count = 0;
        for(int i=0; i<dnaString.length(); i++) {
            if(dnaString.charAt(i)=='G' || dnaString.charAt(i)=='C') {
                gc_count++;
            }
        }
        return (float) (gc_count*100)/dnaString.length();
    }

    private static long mortalFibonacciRabbits(int month, int die_after) {
        long[] rabbitsCount = new long[month];
        rabbitsCount[0] = 1;
        for(int i=1; (i<die_after & i<month); i++) {
            rabbitsCount[i] = (i==1? 1: rabbitsCount[i-1]+rabbitsCount[i-2]);
        }
        for(int i=die_after; i<month; i++) {
            rabbitsCount[i] = 0;
            for(int j=2; j<=die_after; j++) {
                rabbitsCount[i] += rabbitsCount[i-j];
            }
        }
        return rabbitsCount[month-1];
    }

    private static String transcribingDNAintoRNA(String dnaString) {
        StringBuilder rnaString = new StringBuilder("");
        for(int i=0; i<dnaString.length(); i++) {
            if(dnaString.charAt(i) == 'T') rnaString.append("U");
            else rnaString.append(dnaString.charAt(i));
        }
        return rnaString.toString();
    }

    private static String translatingRNAintoProtein(String rnaString) {
        StringBuilder proteinString = new StringBuilder();

        for(int i=0; i<rnaString.length(); i+=3) {
            if(rnaString.charAt(i) == 'U') {
                if(rnaString.charAt(i+1) == 'U') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("F");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("F");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("L");
                    } else {
                        proteinString.append("L");
                    }
                } else if(rnaString.charAt(i+1) == 'C') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("S");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("S");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("S");
                    } else {
                        proteinString.append("S");
                    }
                } else if(rnaString.charAt(i+1) == 'A') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("Y");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("Y");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("");
                    } else {
                        proteinString.append("");
                    }
                } else {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("C");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("C");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("");
                    } else {
                        proteinString.append("W");
                    }
                }
            } else if(rnaString.charAt(i) == 'C') {
                if(rnaString.charAt(i+1) == 'U') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("L");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("L");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("L");
                    } else {
                        proteinString.append("L");
                    }
                } else if(rnaString.charAt(i+1) == 'C') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("P");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("P");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("P");
                    } else {
                        proteinString.append("P");
                    }
                } else if(rnaString.charAt(i+1) == 'A') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("H");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("H");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("Q");
                    } else {
                        proteinString.append("Q");
                    }
                } else {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("R");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("R");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("R");
                    } else {
                        proteinString.append("R");
                    }
                }
            } else if(rnaString.charAt(i) == 'A') {
                if(rnaString.charAt(i+1) == 'U') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("I");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("I");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("I");
                    } else {
                        proteinString.append("M");
                    }
                } else if(rnaString.charAt(i+1) == 'C') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("T");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("T");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("T");
                    } else {
                        proteinString.append("T");
                    }
                } else if(rnaString.charAt(i+1) == 'A') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("N");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("N");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("K");
                    } else {
                        proteinString.append("K");
                    }
                } else {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("S");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("S");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("R");
                    } else {
                        proteinString.append("R");
                    }
                }
            } else {
                if(rnaString.charAt(i+1) == 'U') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("V");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("V");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("V");
                    } else {
                        proteinString.append("V");
                    }
                } else if(rnaString.charAt(i+1) == 'C') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("A");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("A");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("A");
                    } else {
                        proteinString.append("A");
                    }
                } else if(rnaString.charAt(i+1) == 'A') {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("D");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("D");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("E");
                    } else {
                        proteinString.append("E");
                    }
                } else {
                    if(rnaString.charAt(i+2) == 'U') {
                        proteinString.append("G");
                    } else if(rnaString.charAt(i+2) == 'C') {
                        proteinString.append("G");
                    } else if(rnaString.charAt(i+2) == 'A') {
                        proteinString.append("G");
                    } else {
                        proteinString.append("G");
                    }
                }
            }
        }
        return proteinString.toString();
    }

    private static String rnaSplicing(String dnaString, String[] introns) {
        for(String intron: introns) dnaString = dnaString.replaceAll(intron, "");
        return translatingRNAintoProtein(transcribingDNAintoRNA(dnaString));
    }

    private static double calculatingProteinMass(String proteinString) {
        double proteinMass = 0;
        for(int i=0; i<proteinString.length(); i++) {
            char charAt = proteinString.charAt(i);
            if(charAt == 'A') proteinMass += 71.03711;
            else if(charAt == 'C') proteinMass += 103.00919;
            else if(charAt == 'D') proteinMass += 115.02694;
            else if(charAt == 'E') proteinMass += 129.04259;
            else if(charAt == 'F') proteinMass += 147.06841;
            else if(charAt == 'G') proteinMass += 57.02146;
            else if(charAt == 'H') proteinMass += 137.05891;
            else if(charAt == 'I') proteinMass += 113.08406;
            else if(charAt == 'K') proteinMass += 128.09496;
            else if(charAt == 'L') proteinMass += 113.08406;
            else if(charAt == 'M') proteinMass += 131.04049;
            else if(charAt == 'N') proteinMass += 114.04293;
            else if(charAt == 'O') proteinMass += 237.14773;
            else if(charAt == 'P') proteinMass += 97.05276;
            else if(charAt == 'Q') proteinMass += 128.05858;
            else if(charAt == 'R') proteinMass += 156.10111;
            else if(charAt == 'S') proteinMass += 87.03203;
            else if(charAt == 'T') proteinMass += 101.04768;
            else if(charAt == 'U') proteinMass += 150.95364;
            else if(charAt == 'V') proteinMass += 99.06841;
            else if(charAt == 'W') proteinMass += 186.07931;
            else if(charAt == 'Y') proteinMass += 163.06333;
        }
        return proteinMass;
    }

    private static float mendelsFirstLaw(int homozygous_dominant, int heterozygous, int homozygous_recessive) {
        return (float) (homozygous_dominant*((homozygous_dominant-1)+heterozygous+homozygous_recessive)+heterozygous*(homozygous_dominant+(heterozygous-1)*0.75+homozygous_recessive*0.5)+homozygous_recessive*(homozygous_dominant+heterozygous*0.5))/((homozygous_dominant+heterozygous+homozygous_recessive)*(homozygous_dominant+heterozygous+homozygous_recessive-1));
    }

    private static double calculatingExpectedOffspring(int[] genotypeCouples) {
        return 2.0*genotypeCouples[0]+2.0*genotypeCouples[1]+2.0*genotypeCouples[2]+1.5*genotypeCouples[3]+1.0*genotypeCouples[4]+0.0*genotypeCouples[5];
    }

    private static String findingConsensusStringAndProfileMatrix(String[] dnaStrings) {
        /* Consensus & Profile */
        int[][] profileMatrix = new int[4][dnaStrings[0].length()];
        for(int i=0; i<profileMatrix.length; i++) {
            for(int j=0; j<profileMatrix[0].length; j++) {
                profileMatrix[i][j] = 0;
            }
        }
        for(int i=0; i<dnaStrings[0].length(); i++) {
            for(String dnaString: dnaStrings) {
                if(dnaString.charAt(i) == 'A') {
                    profileMatrix[0][i]++;
                } else if(dnaString.charAt(i) == 'C') {
                    profileMatrix[1][i]++;
                } else if(dnaString.charAt(i) == 'G') {
                    profileMatrix[2][i]++;
                } else if(dnaString.charAt(i) == 'T') {
                    profileMatrix[3][i]++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0, max=-1, index=-1; i<profileMatrix[0].length; i++) {
            for(int j=0; j<profileMatrix.length; j++) {
                index = (max<profileMatrix[j][i]? j: index);
                max = (max<profileMatrix[j][i]? profileMatrix[j][i]: max);
            }
            stringBuilder.append((index<2? (index<1? 'A': 'C'): (index<3? 'G': 'T')));
            max = index = -1;
        }
        stringBuilder.append("\n");
        for(int i=0; i<profileMatrix.length; i++) {
            stringBuilder.append((i<2? (i<1? "A:": "C:"): (i<3? "G:": "T:")));
            for(int profileMatrixEntry: profileMatrix[i]) {
                stringBuilder.append(" ").append(profileMatrixEntry);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static double findingTransitionTransversionRatio(String dnaString1, String dnaString2) {
        /* Transitions & Transversions */
        int transitions=0, transversions=0;
        for(int i=0; i<dnaString1.length(); i++) {
            if(dnaString1.charAt(i) != dnaString2.charAt(i)) {
                if((dnaString1.charAt(i)=='A' && dnaString2.charAt(i)=='G') || (dnaString1.charAt(i)=='G' && dnaString2.charAt(i)=='A') || (dnaString1.charAt(i)=='T' && dnaString2.charAt(i)=='C') || (dnaString1.charAt(i)=='C' && dnaString2.charAt(i)=='T')) {
                    transitions++;
                } else {
                    transversions++;
                }
            }
        }
        return (double) transitions/transversions;
    }

    private static String swapCharacterWithinString(String string, int charAt1, int charAt2) {
        char[] charArray = string.toCharArray();
        char temp = charArray[charAt1];
        charArray[charAt1] = charArray[charAt2];
        charArray[charAt2] = temp;
        return new String(charArray);
    }

    private static void findingPermutations(ArrayList<String> permutations, String permutation, int low, int high) {
        if(low == high) {
            permutations.add(permutation);
        } else {
            for(int i=low; i<=high; i++) {
                permutation = swapCharacterWithinString(permutation, low, i);
                findingPermutations(permutations, permutation, low+1, high);
                permutation = swapCharacterWithinString(permutation, low, i);
            }
        }
    }

    private static ArrayList<String> enumeratingGeneOrders(int length) {
        ArrayList<String> permutations = new ArrayList<>();
        StringBuilder initialPermutation = new StringBuilder("");
        for(int i=1; i<=length; i++) {
            initialPermutation.append(i);
        }
        findingPermutations(permutations, initialPermutation.toString(), 0, length-1);
        return permutations;
    }

    public static void main(String[] args) {

    }
}
