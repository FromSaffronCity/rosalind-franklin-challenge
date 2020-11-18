import java.util.Scanner;

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

    private static float mendelsFirstLaw(int homozygous_dominant, int heterozygous, int homozygous_recessive) {
        return (float) (homozygous_dominant*((homozygous_dominant-1)+heterozygous+homozygous_recessive)+heterozygous*(homozygous_dominant+(heterozygous-1)*0.75+homozygous_recessive*0.5)+homozygous_recessive*(homozygous_dominant+heterozygous*0.5))/((homozygous_dominant+heterozygous+homozygous_recessive)*(homozygous_dominant+heterozygous+homozygous_recessive-1));
    }

    private static double calculatingExpectedOffspring(int[] genotypeCouples) {
        return 2.0*genotypeCouples[0]+2.0*genotypeCouples[1]+2.0*genotypeCouples[2]+1.5*genotypeCouples[3]+1.0*genotypeCouples[4]+0.0*genotypeCouples[5];
    }

    public static void main(String[] args) {
        int[] array = new int[6];
        for(int i=0; i<6; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(calculatingExpectedOffspring(array));
    }
}
