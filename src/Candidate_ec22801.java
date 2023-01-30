import java.util.Random;

public class Candidate_ec22801 {
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

    abstract class Candidate implements Citizen, Electable { }

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
            
            // Search for a like minded candidate.
            for (Candidate c : candidates)
                if (c.getSlogan().equals("More trees!"))
                    return c;
            
            // Otherwise, search for a friend.
            for (Candidate c : candidates)
                if (c.getName().equals("Kim"))
                    return c;
            
            // Otherwise, default to last candidate on list.
            return candidates[candidates.length-1];
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
            for (Candidate c : candidates)
                if (c.getName().equals("Utfur")) {
                    return c;
                } else if (c.getSlogan().equals("More fields!")) {
                    return c;
                } else if (c.getSlogan().equals("More trees!")) {
                    return c;
                }
                
            
            // Otherwise, choose at random from list.
            Random r = new Random();
            int c = r.nextInt(candidates.length);
            return candidates[c]; 
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
                if (c.getName().equals("Arbor"))
                    return c;
            
            // Otherwise, default to ramdom candidate on list.
            Random r = new Random();
            int c = r.nextInt(candidates.length);
            return candidates[c];
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
        for (int i=0;i<voters.length;i++) {
            Candidate v = voters[i].vote(listOfCandidates);
            System.out.println(voters[i].getName() +" voted for " + v.getName() +
                              ", whose slogan is '" + v .getSlogan() + "'.");
            ballotBox[i] = v;
        }
        
        // Ask all voters to count the votes.
        for (int i=0;i<voters.length;i++) {
            Person winner = voters[i].selectWinner(ballotBox);
            System.out.println(voters[i].getName() +" says " + winner.getName() +
                              " wins the election.");
        }
        
    }

    public static void main(String[] args) throws Exception {
        try
        {
            Candidate_ec22801 obj = new Candidate_ec22801 ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
}
