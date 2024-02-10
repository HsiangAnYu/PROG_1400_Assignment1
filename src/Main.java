import javax.swing.plaf.IconUIResource;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declare useful object first
        Scanner sc = new Scanner(System.in);
        final int teamNum = 3;
        Team[] teamsArray = new Team[teamNum];

        //display intro
        System.out.println("FANTASY HOCKEY APPLICATION");
        System.out.println("TEAM ENTRY");
        System.out.println("================================");

        //create new team with input team name
        for(int i = 0; i < teamsArray.length; i++)
        {
            System.out.println("Enter name for team # " + (i+1) + ":");
            teamsArray[i] = new Team(sc.next());
            //validation for team name.
            if(teamsArray[i].getName().length() < 3)
            {
                System.out.println("Name need at least 3 characters");
                i --;
            }
        }

        //display info
        System.out.println("\nPLAYER ENTRY");
        System.out.println("================================");

        //loop for player data input
        for (Team team : teamsArray) {   //temp variable for player class
            String tempName;
            int tempGoal;
            int tempAssist;

            System.out.println("Enter players for " + team.getName());

            for (int p = 0; p < team.getPlayerNum(); p++) {
                //store player name with validation
                do {
                    System.out.println("Enter name for player # " + (p + 1) + ":");
                    tempName = sc.next();
                    if (tempName.length() < 3) {
                        System.out.println("Name need at least 3 characters");
                    }
                } while (tempName.length() < 3); //check if string length is larger than 3

                //store player goals with validation
                do {
                    System.out.println("Enter number of goals for " + tempName);
                    //detect rather input is int or not.
                    while (!sc.hasNextInt()) {
                        System.out.println("Input need to be a number!");
                        System.out.println("Enter number of goals for " + tempName);
                        sc.next();
                    }
                    tempGoal = sc.nextInt();
                    if (tempGoal < 0) {
                        System.out.println("Goal need to be positive number");
                    }
                } while (tempGoal < 0); //check if input is positive

                //store player assist with validation
                do {
                    System.out.println("Enter number of assists for " + tempName);
                    //detect rather input is int or not.
                    while (!sc.hasNextInt()) {
                        System.out.println("Input need to be a number!");
                        System.out.println("Enter number of assist for " + tempName);
                        sc.next();
                    }
                    tempAssist = sc.nextInt();
                    if (tempAssist < 0) {
                        System.out.println("Assist need to be positive number");
                    }
                } while (tempAssist < 0); //check if input is positive

                //store new player into team object
                team.setPlayers(new Player(tempName, tempGoal, tempAssist), p);
            }
        }//end loop for player input

        //display info
        System.out.println("\nREPORT: Stats per Team");
        System.out.println("================================");

        //output team data
        for(Team t : teamsArray)
        {
            System.out.print(t.getName() + ":");
            System.out.print(" Goals- " + t.totalGoals());
            System.out.print(" Assists- " + t.totalAssists());
            System.out.println(" Total- " + t.totalPoints());
            System.out.println("Budget: $" + String.format("%,.2f", t.getBudget())); // to 2 decimal place
            System.out.println("Rating: " + t.rating(t.totalPoints()));
            System.out.println();
        }

        //display info
        System.out.println("\nREPORT: Stats per Player");
        System.out.println("================================");

        //output player data
        for(Team t : teamsArray)
        {
            System.out.println(t.getName());
            for(Player p : t.getPlayers())
            {
                System.out.print(p.getName() + ":");
                System.out.print(" Goals-" + p.getGoals());
                System.out.print(" Assists-" + p.getAssists());
                System.out.println(" Total-" + p.totalPoint());
            }
            System.out.println();
        }

    }//end method main
}//end class main