import java.util.Random;
import java.util.Scanner;

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


    public String validateInput(String input) {
        if (input.equals("y") || input.equals("n")) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter y or n.");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            return validateInput(input);
        }
    }

    public int validateIntInput(int input) {
        int max = 3;
        if (input >= 0 && input < max) {
            return input;
        } else {
            System.out.println("Invalid input. Please enter a number between 0 and " + (max - 1) + ".");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            return validateIntInput(input);
        }
    }

    public void run(String[] args) throws Exception {

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

        // Ask all voters to vote.
        Candidate[] ballotBox = new Candidate[voters.length];
        // Ask if voters wish to display the list of candidates.
        System.out.println("Do you wish to display the list of candidates? (y/n)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = validateInput(input); // Remove this line if you don't want to validate input.
        if (input.equals("y")) {
            displayCandidates(listOfCandidates);
        }

        String[] votersVoted = new String[voters.length];

        for (int i = 0; i < voters.length; i++) {
            // Ask voter's name.
            boolean nextVote = true;
            while (nextVote) {
                boolean isVoted = false;
                System.out.print("What is your name? ");
                String name = sc.nextLine();
                System.out.println("Hello " + name + "!");
                // Check if voter have voted before.
                for (int j = 0; j < votersVoted.length; j++) {
                    // Get voters in ballot box. If it's null then skip.
                    String votersInBallot = votersVoted[j];
                    if (votersInBallot == null) {
                        continue;
                    } else if (votersInBallot.equals(name)) {
                        System.out.println("You have voted before!");
                        isVoted = true;
                        break;
                    }
                }
                if (isVoted) {
                    nextVote = true;
                } else {
                    // Check if voter's name is in the list of candidates and return position.
                    int position = -1;
                    for (int j = 0; j < listOfCandidates.length; j++) {
                        if (listOfCandidates[j].getName().equals(name)) {
                            position = j;
                            break;
                        }
                    }
                    // If voter's name is not in the list of candidates, ask for another name.
                    if (position == -1) {
                        System.out.println("Your name is not in the list of voters!");
                        continue;
                    } else {
                        Candidate v = voters[i].vote(listOfCandidates);
                        System.out.println(voters[position].getName() + " voted for " + v.getName() +
                                ", whose slogan is '" + v.getSlogan() + "'.");
                        ballotBox[i] = v;
                        // Add voter's name to the list of voters voted.
                        votersVoted[i] = name;
                        nextVote = false;
                        break;
                    }
                }
            }
        }

        // Ask voters whose select winners they want to see
        System.out.println("Do you want to see the winner selected by each voter? (y/n)");
        input = sc.nextLine();
        input = validateInput(input); // Remove this line if you don't want to validate input.
        if (input.equals("y")) {
            for (int i = 0; i < voters.length; i++) {
                Person winner = voters[i].selectWinner(ballotBox);
                System.out.println(voters[i].getName() + " says " + winner.getName() +
                        " wins the election.");
            }
        } else {
            System.out.println("Whose opinion do you want to see?");
            displayVoters(voters);
            System.out.print("Enter the number of the voter: ");
            int voterNumber = sc.nextInt();
            voterNumber = validateIntInput(voterNumber); // Remove this line if you don't want to validate input.
            Person winner = voters[voterNumber].selectWinner(ballotBox);
            System.out.println(voters[voterNumber].getName() + " says " + winner.getName() +
                    " wins the election.");
        }
        
        // Ask all voters to count the votes.
        /*for (int i = 0; i < voters.length; i++) {
            Person winner = voters[i].selectWinner(ballotBox);
            System.out.println(voters[i].getName() + " says " + winner.getName() +
                    " wins the election.");
        }*/

        sc.close();

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
