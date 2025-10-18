package week_9.practice;

public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            public boolean validate() {
                return voterId != null && voterId.matches("V[0-9]{3}");
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate()) {
            System.out.println("Vote recorded for " + candidate + " by voter " + voterId);
        } else {
            System.out.println("Invalid voter ID: " + voterId);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.processVote("V101", "Candidate A");
        vs.processVote("123", "Candidate B");
    }
}
