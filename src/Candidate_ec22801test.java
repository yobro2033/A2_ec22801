import java.util.Random;

public class Candidate_ec22801test {
    interface Person {
        String getName();
    }

    interface Citizen extends Person {
        Candidate vote(Candidate[] candidates);

        Candidate selectWinner(Candidate[] votes);
    }

    interface Electable {
        String getSlogan();
    }

    abstract class Candidate implements Citizen, Electable {
    }

    class Candidate_ac1234 extends Candidate {

        public String getName() {
            return "Robin";
        }

        public String getSlogan() {
            return "More trees!";
        }

        public Candidate vote(Candidate[] candidates) {

            // If array is empty, return instance of friend's class.
            if (candidates.length == 0) {
                // Randomly choose between three options.
                Random r = new Random();
                int c = r.nextInt(3);
                if (c == 0)
                    return new Candidate_ac1234();
                else if (c == 1)
                    return new Candidate_ac1235();
                else
                    return new Candidate_ac1236();
            }

            Candidate slogans = randomPosition(candidates);
            // Search for a like minded candidate.
            for (Candidate c : candidates)
                if (c.getSlogan().equals(slogans.getSlogan()))
                    return c;

            Candidate friends = randomPosition(candidates);
            // Otherwise, search for a friend.
            for (Candidate c : candidates)
                if (c.getName().equals(friends.getName()))
                    return c;

            // Otherwise, default to last candidate on list.
            return candidates[candidates.length - 1];
        }

        public Candidate selectWinner(Candidate[] votes) {

            // If array is empty, return instance of friend's class.
            if (votes.length == 0)
                return new Candidate_ac1235();

            // Default to first vote, but this will be over-written.
            Candidate currentWinner = votes[0];

            // Count the votes for each object in the array,
            // selecting one with the most.
            int highestCount = 0;
            for (Candidate c : votes) {

                int count = 0;
                for (Candidate x : votes)
                    if (x == c)
                        count++;
                if (count > highestCount) {
                    highestCount = count;
                    currentWinner = c;
                }
            }

            return currentWinner;
        }

    }
    class Candidate_ac1235 extends Candidate {

        public String getName() {
            return "Kim";
        }

        public String getSlogan() {
            return "More fields!";
        }

        public Candidate vote(Candidate[] candidates) {

            // If array is empty, return instance of this class.
            if (candidates.length == 0)
                return new Candidate_ac1235();

            // First search for Utfur on the list of candidates.
            Candidate friends = randomPosition(candidates);
            Candidate firstSlogan = randomPosition(candidates);
            Candidate secondSlogan = randomPosition(candidates);

            for (Candidate c : candidates)
                if (c.getName().equals(friends.getName())) {
                    return c;
                } else if (c.getSlogan().equals(firstSlogan.getSlogan())) {
                    return c;
                } else if (c.getSlogan().equals(secondSlogan.getSlogan())) {
                    return c;
                }

            return randomPosition(candidates);
        }

        public Candidate selectWinner(Candidate[] votes) {

            // If array is empty, return instance of this class.
            if (votes.length == 0)
                return new Candidate_ac1235();

            // Default to first vote, but this will be over-written.
            Candidate currentWinner = votes[0];

            // Count the votes for each object in the array,
            // selecting one with the most.
            int highestCount = 0;
            for (Candidate c : votes) {

                int count = 0;
                for (Candidate x : votes)
                    if (x == c)
                        count++;
                if (count > highestCount) {
                    highestCount = count;
                    currentWinner = c;
                } else if (count == highestCount) {
                    // If there is a tie, choose at random.
                    Random r = new Random();
                    if (r.nextBoolean()) {
                        highestCount = count;
                        currentWinner = c;
                    }
                }
            }

            return currentWinner;
        }

    }
    class Candidate_ac1236 extends Candidate {

        public String getName() {
            return "Arbor";
        }

        public String getSlogan() {
            return "More me!";
        }

        public Candidate vote(Candidate[] candidates) {

            // First search for self on the list of candidates.
            for (Candidate c : candidates)
                if (c.getName().equals(this.getName()))
                    return c;

            return randomPosition(candidates);
        }

        public Candidate selectWinner(Candidate[] votesCast) {

            // If array is empty, return instance of this class.
            if (votesCast.length == 0) {
                Random r = new Random();
                int c = r.nextInt(2);
                if (c == 0)
                    return new Candidate_ac1234();
                else
                    return new Candidate_ac1235();
            }

            // Default to first vote, but this will be over-written.
            Candidate currentWinner = votesCast[0];

            // Count the votes for each object in the array,
            // selecting one with the most.
            int highestCount = 0;
            for (Candidate c : votesCast) {

                int count = 0;
                for (Candidate x : votesCast)
                    if (x == c)
                        count++;
                if (count > highestCount) {
                    highestCount = count;
                    currentWinner = c;
                } else if (count == highestCount) {
                    // If there is a tie, choose at random.
                    Random r = new Random();
                    if (r.nextBoolean()) {
                        highestCount = count;
                        currentWinner = c;
                    }
                }
            }
            if (highestCount < 3) {
                Random r = new Random();
                int c = r.nextInt(3);
                if (c == 0)
                    return new Candidate_ac1234();
                else if (c == 1)
                    return new Candidate_ac1235();
                else
                    return new Candidate_ac1236();
            }
            return currentWinner;
        }
    }

    public Candidate randomPosition(Candidate[] candidates) {
        Random r = new Random();
        int randomPos = r.nextInt(candidates.length);
        return candidates[randomPos];
    }

    public void displayCandidates(Candidate[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            System.out.println("[" + i + "] Candidate: " + candidates[i].getName() + ", slogan for the campaign: "
                    + candidates[i].getSlogan());
        }
    }

    public void displayVoters(Citizen[] voters) {
        for (int i = 0; i < voters.length; i++) {
            System.out.println("[" + i + "] Voter: " + voters[i].getName());
        }
    }

    public void run(String[] args) {

        // Make up list of candidates to pass to vote methods.
        Candidate[] listOfCandidates = new Candidate[3];
        listOfCandidates[0] = new Candidate_ac1234();
        listOfCandidates[1] = new Candidate_ac1235();
        listOfCandidates[2] = new Candidate_ac1236();

        // Compile list of citzens.
        Citizen[] voters = new Citizen[3];
        voters[0] = new Candidate_ac1234();
        voters[1] = new Candidate_ac1235();
        voters[2] = new Candidate_ac1236();

        System.out.println("List of candidates:");
        // Ask if voters wish to display the list of candidates.
        displayCandidates(listOfCandidates);

        System.out.println("");
        System.out.println("Voting in progress...");
        // Ask all voters to vote.
        Candidate[] ballotBox = new Candidate[voters.length];
        for (int i=0;i<voters.length;i++) {
            Candidate v = voters[i].vote(listOfCandidates);
            System.out.println(voters[i].getName() +" voted for " + v.getName() +
                              ", whose slogan is '" + v .getSlogan() + "'.");
            ballotBox[i] = v;
        }

        System.out.println("");
        System.out.println("Let's count the votes!");
        // Check who received how many votes.
        String[] candidateName = new String[listOfCandidates.length];
        Integer[] candidateCount = new Integer[listOfCandidates.length];
        for (int i = 0; i < listOfCandidates.length; i++) {
            System.out.println("Processing candidate " + listOfCandidates[i].getName() + "...");
            int count = 0;
            for (int j = 0; j < ballotBox.length; j++) {
                if (listOfCandidates[i].getName().equals(ballotBox[j].getName()))
                    count++;
            }

            // Add count and candidate name to each list, make sure the count is in order descending, handling null
            // values.
            for (int z = 0; z < candidateCount.length; z++) {
                if (candidateCount[z] == null) {
                    candidateCount[z] = count;
                    candidateName[z] = listOfCandidates[i].getName();
                    break;
                } else if (count > candidateCount[z]) {
                    for (int y = candidateCount.length - 1; y > z; y--) {
                        candidateCount[y] = candidateCount[y - 1];
                        candidateName[y] = candidateName[y - 1];
                    }
                    candidateCount[z] = count;
                    candidateName[z] = listOfCandidates[i].getName();
                    break;
                }
            }
        }

        System.out.println("");
        // Display the results.
        for (int i = 0; i < candidateName.length; i++) {
            System.out.println(candidateName[i] + " received " + candidateCount[i] + " votes.");
        }

        System.out.println("");
        System.out.println("Who will win the election?");
        // Ask voters whose select winners they want to see
        for (int i = 0; i < voters.length; i++) {
                Person winner = voters[i].selectWinner(ballotBox);
                System.out.println(voters[i].getName() + " says " + winner.getName() +
                        " wins the election.");
        }

        // Check whether there is a tie.
        int numberOfWinners = 0;
        for (int i = 0; i < candidateCount.length; i++) {
            if (candidateCount[i] == candidateCount[0])
                numberOfWinners++;
        }

        System.out.println("");
        System.out.println("Let's see who tells the truth!");
        // Check whether voters are telling the truth. If there is a tie, check whether the voter is telling the truth.
        for (int i = 0; i < voters.length; i++) {
            if (numberOfWinners > 1) {
                for (int j = 0; j < numberOfWinners; j++) {
                    if (voters[i].selectWinner(ballotBox).getName().equals(candidateName[j])) {
                        System.out.println(voters[i].getName() + " is telling the truth.");
                        break;
                    } else if (j == numberOfWinners - 1) {
                        System.out.println(voters[i].getName() + " is lying.");
                    }
                }
            } else if (voters[i].selectWinner(ballotBox).getName().equals(candidateName[0])) {
                System.out.println(voters[i].getName() + " is telling the truth.");
            } else {
                System.out.println(voters[i].getName() + " is lying.");
            }
        }

        // Display which slogan was the most popular.
        System.out.println("");
        System.out.println("Which slogan was the most popular?");
        String[] sloganName = new String[listOfCandidates.length];
        Integer[] sloganCount = new Integer[listOfCandidates.length];
        for (int i = 0; i < listOfCandidates.length; i++) {
            System.out.println("Processing slogan " + listOfCandidates[i].getSlogan() + "...");
            int count = 0;
            for (int j = 0; j < ballotBox.length; j++) {
                if (listOfCandidates[i].getSlogan().equals(ballotBox[j].getSlogan()))
                    count++;
            }

            // Add count and slogan name to each list, make sure the count is in order descending, handling null
            // values.
            for (int z = 0; z < sloganCount.length; z++) {
                if (sloganCount[z] == null) {
                    sloganCount[z] = count;
                    sloganName[z] = listOfCandidates[i].getSlogan();
                    break;
                } else if (count > sloganCount[z]) {
                    for (int y = sloganCount.length - 1; y > z; y--) {
                        sloganCount[y] = sloganCount[y - 1];
                        sloganName[y] = sloganName[y - 1];
                    }
                    sloganCount[z] = count;
                    sloganName[z] = listOfCandidates[i].getSlogan();
                    break;
                }
            }
        }

        System.out.println("");
        String mostPopularSlogan = "";
        if (numberOfWinners == 1) {
            mostPopularSlogan = "The slogan '" + sloganName[0] + "' was the most popular.";
            System.out.println(mostPopularSlogan);
        } else {
            for (int i = 0; i < numberOfWinners; i++) {
                mostPopularSlogan = mostPopularSlogan + "'" + sloganName[i] + "' ";
            }
            System.out.println("Slogans " + mostPopularSlogan + "were the most popular.");
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Candidate_ec22801test obj = new Candidate_ec22801test();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
