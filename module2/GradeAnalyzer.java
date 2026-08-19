import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    // Global/static counter to track skipped invalid lines
    private static int invalidLinesCount = 0;

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("module2/scores.txt");

        // Handle empty file edge case early
        if (scores.isEmpty()) {
            System.out.println("No valid scores were found in the file.");
            return;
        }

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        // Step 5: find highest and lowest scores using a loop
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        // Step 6: count grade bands
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Step 7: write report to file and print to terminal
        writeReport(scores.size(), invalidLinesCount, average, high, low, 
                    countA, countB, countC, countD, countF, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                
                // Skip blank lines without raising warnings
                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        System.out.println("Warning: Score out of range (0-100) skipped -> " + line);
                        invalidLinesCount++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid numeric input skipped -> " + line);
                    invalidLinesCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    // Writes report to file AND prints summary to terminal
    public static void writeReport(int totalProcessed, int invalidSkipped,
                                   double avg, int high, int low,
                                   int countA, int countB, int countC, int countD, int countF,
                                   String outputFile) {
        
        // Build the formatted summary text
        StringBuilder sb = new StringBuilder();
        sb.append("=== Grade Analysis Report ===\n");
        sb.append(String.format("Total scores processed: %d%n", totalProcessed));
        sb.append(String.format("Invalid lines skipped:  %d%n%n", invalidSkipped));
        sb.append(String.format("Average score:   %.2f%n", avg));
        sb.append(String.format("Highest score:   %d%n", high));
        sb.append(String.format("Lowest score:    %d%n%n", low));
        sb.append("Grade distribution:\n");
        sb.append(String.format("  A (90-100):  %d%n", countA));
        sb.append(String.format("  B (80-89):   %d%n", countB));
        sb.append(String.format("  C (70-79):   %d%n", countC));
        sb.append(String.format("  D (60-69):   %d%n", countD));
        sb.append(String.format("  F (below 60): %d%n", countF));

        String reportText = sb.toString();

        // 1. Output summary report to terminal
        System.out.print(reportText);

        // 2. Write summary report to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.print(reportText);
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
}