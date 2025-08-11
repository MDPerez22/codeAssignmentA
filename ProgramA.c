#include <stdio.h>
#include <stdlib.h>

const int MIN_SCORES = 2;
const int MAX_SCORES = 10;

int main(int argc, char *argv[]) {
    int min_scores = 2;
    int max_scores = 10;
    int scoreTable[MAX_SCORES];
    int nbrOfScores = 0;
    int i;
    int minScore, maxScore;
    double averageScore, sum = 0;

    if (argc == 2) {
        nbrOfScores = atoi(argv[1]);
    } else {
        printf("How many scores (%d-%d): ", min_scores, max_scores);
        scanf("%d", &nbrOfScores);
    }

    if (nbrOfScores < min_scores || nbrOfScores > max_scores) {
        printf("ERROR: The number of scores must be between %d and %d\n", min_scores, max_scores);
        return 0;
    }

    printf("Enter %d scores:\n", nbrOfScores);
    for (i = 0; i < nbrOfScores; i++) {
        scanf("%d", &scoreTable[i]);
    }

    printf("\nContents of the score table:\n");
    for (i = 0; i < nbrOfScores; i++) {
        printf("  %d", scoreTable[i]);
    }
    printf("\n");

    minScore = scoreTable[0];
    maxScore = scoreTable[0];
    sum = scoreTable[0];

    for (i = 1; i < nbrOfScores; i++) {
        if (scoreTable[i] < minScore) {
            minScore = scoreTable[i];
        }
        if (scoreTable[i] > maxScore) {
            maxScore = scoreTable[i];
        }
        sum += scoreTable[i];
    }

    averageScore = sum / nbrOfScores;

    printf("\n*** Statistics Report ***\n\n");
    printf("Maximum  Minimum  Average\n");
    printf(" Score    Score    Score\n");
    printf("-------  -------  -------\n\n");
    printf("%7d  %7d  %7.1f\n", maxScore, minScore, averageScore);

    return 0;
}