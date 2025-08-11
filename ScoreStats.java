import java.util.Scanner;

class ScoreStats
{
static final int MIN_SCORES = 2;
static final int MAX_SCORES = 10;

// -----------------------------------
public static void main(String[] args)
{
Scanner inputSource = new Scanner(System.in);
int[] scoreTable = new int[MAX_SCORES];
int userResponse;
int nbrOfScores = 0;
int minimumScore;
int maximumScore;
double averageScore;

if (args.length == 1)
   nbrOfScores = parseCommandLine(args);
else
   {
   System.out.print("How many scores(" + MIN_SCORES + "-" + MAX_SCORES + "): ");
   nbrOfScores = inputSource.nextInt();
   } // End else

if (nbrOfScores < MIN_SCORES || nbrOfScores > MAX_SCORES)
   {
   System.out.println("ERROR: The number of scores must be between " + MIN_SCORES + " and " + MAX_SCORES);     
   } // End if
else
   {
   readScores(inputSource, scoreTable, nbrOfScores);
   displayScoreTable(scoreTable, nbrOfScores);

   minimumScore = findMinimumScore(scoreTable, nbrOfScores);
   maximumScore = findMaximumScore(scoreTable, nbrOfScores);
   averageScore = calculateAverageScore(scoreTable, nbrOfScores);

   displayStatisticsReport(minimumScore, maximumScore, averageScore);   
   } // End else      

} // End main

// --------------------------------------------------
private static int parseCommandLine(String[] args)
{
int number;

number = Integer.parseInt(args[0]);
return number;
} // End method

// --------------------------------------------------
private static void readScores(Scanner input, int[] table, int scoreCount)
{
for (int i = 0; i < scoreCount; i++)
   {
   table[i] = input.nextInt();
   } // End for 
} // End method

// --------------------------------------------------
private static void displayScoreTable(int[] table, int scoreCount)
{
System.out.println();
System.out.println("Contents of the score table:");

for (int i = 0; i < scoreCount; i++)
   {
   System.out.print("  " + table[i]);
   } // End for 
System.out.println();
} // End method

// --------------------------------------------------
private static int findMinimumScore(int[] table, int scoreCount)
{
int minimumScore = table[0];

for (int i = 1; i < scoreCount; i++)
   {
   if (table[i] < minimumScore)
      minimumScore = table[i];
   } // End for 
   
return minimumScore;
} // End method

// --------------------------------------------------
private static int findMaximumScore(int[] table, int scoreCount)
{
int maximumScore = table[0];

for (int i = 1; i < scoreCount; i++)
   {
   if (table[i] > maximumScore)
      maximumScore = table[i];
   } // End for 
   
return maximumScore;
} // End method

// --------------------------------------------------
private static double calculateAverageScore(int[] table, int scoreCount)
{
double sum = 0;
double average = 0;

for (int i = 0; i < scoreCount; i++)
   {
   sum = sum + table[i];
   } // End for 

average = sum / scoreCount;
   
return average;
} // End method

// --------------------------------------------------
private static void displayStatisticsReport(int minScore, int maxScore, double avgScore)   
{
System.out.println();
System.out.println("*** Statistics Report ***");
System.out.println();
System.out.println("Maximum  Minimum  Average");
System.out.println(" Score    Score    Score");
System.out.println("-------  -------  -------");
System.out.println();
System.out.printf("%7d  %7d  %7.1f\n", minScore, maxScore, avgScore);
} // End method

} // End class
