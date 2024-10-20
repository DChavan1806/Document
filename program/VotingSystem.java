package program;

import java.util.*;

public class VotingSystem {

    private final int N;
    private final Map<Integer, Integer> voteCounts;

    public VotingSystem(int N) {
        this.N = N;
        voteCounts = new HashMap<>();
        for (int i = 0; i < N; i++) {
            voteCounts.put(i, 0);
        }
    }

    public void castVotes(int firstVote, int secondVote, int thirdVote) {
        if (isValidCondidate(firstVote)) {
            voteCounts.put(firstVote, voteCounts.get(firstVote) + 3); // 3 points for first choice
        }
        if (isValidCondidate(secondVote)) {
            voteCounts.put(secondVote, voteCounts.get(secondVote) + 2); // 2 points for second choice
        }
        if (isValidCondidate(thirdVote)) {
            voteCounts.put(thirdVote, voteCounts.get(thirdVote) + 1); // 1 point for third choice
        }
    }

    // Method to check if the vote is valid (within the range of candidate IDs)
    private boolean isValidCondidate(int vote) {
        return vote >= 0 && vote < N;
    }

    // Method to get the total votes for each candidate
    public void displayResults() {
        System.out.println("Vote Results:");
        for (int candidate : voteCounts.keySet()) {
            System.out.println("Candidate " + candidate + ": " + voteCounts.get(candidate) + " votes");
        }
    }

    // Get the candidate with the highest vote count
    public int getWinner() {
        return Collections.max(voteCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem(5); // Create a system with 5 candidates (IDs 0 to 4)

        // Simulate casting votes
        votingSystem.castVotes(0, 1, 2); // First vote: candidate 0, second: candidate 1, third: candidate 2
        votingSystem.castVotes(2, 1, 3); // First vote: candidate 2, second: candidate 1, third: candidate 3
        votingSystem.castVotes(4, 0, 1); // First vote: candidate 4, second: candidate 0, third: candidate 1

        // Display the results
        votingSystem.displayResults();

        // Find and display the winner
        int winner = votingSystem.getWinner();
        System.out.println("The winner is candidate " + winner);
    }
}
