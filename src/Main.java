import javax.swing.plaf.IconUIResource;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //declare useful object first
        Scanner sc = new Scanner(System.in);
        Team[] teamsArray = new Team[3];
        Player[] playerArray = new Player[3];

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
        for(int i = 0; i < teamsArray.length; i++)
        {   //temp variable for player class
            String tempName;
            int tempGoal;
            int tempAssist;

            System.out.println("Enter players for "+ teamsArray[i].getName() +" Picks:");

            for(int p = 0; p < playerArray.length; p++)
            {
                //store player name with validation
                do{
                    System.out.println("Enter name for player # " + (p+1) +":");
                    tempName = sc.next();
                    if(tempName.length() < 3){ System.out.println("Name need at least 3 characters");}
                }while(tempName.length() < 3);

                //store player goals with validation
                do{
                    System.out.println("Enter number of goals for " + tempName);
                    //detect rather input is int or not.
                    while (!sc.hasNextInt()) {
                        System.out.println("Input need to be a number!");
                        System.out.println("Enter number of goals for " + tempName);
                        sc.next();
                    }
                    tempGoal = sc.nextInt();
                    if(tempGoal < 0){ System.out.println("Goal need to be positive number");}
                }while(tempGoal < 0);

                //store player assist with validation
                do{
                    System.out.println("Enter number of assists for " + tempName);
                    //detect rather input is int or not.
                    while (!sc.hasNextInt()) {
                        System.out.println("Input need to be a number!");
                        System.out.println("Enter number of assist for " + tempName);
                        sc.next();
                    }
                    tempAssist = sc.nextInt();
                    if(tempAssist < 0){ System.out.println("Assist need to be positive number");}
                }while(tempAssist < 0);

                //store new player into player object
                playerArray[p] = new Player(tempName,tempGoal,tempAssist);
            }
            //store player array into team object
            teamsArray[i].setPlayers(playerArray);
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
            System.out.println("Budget- $" + String.format("%,.2f", t.getBudget())); // to 2 decimal place
            System.out.println("Rating: " + t.rating(t.totalPoints()));
        }

        //display info
        System.out.println("\nREPORT: Stats per Player");
        System.out.println("================================");

        //output player data
        for(Team t : teamsArray)
        {
            System.out.println(t.getName());
            for(Player p : playerArray)
            {
                System.out.print(p.getName() + ":");
                System.out.print(" Goals- " + p.getGoals());
                System.out.print(" Assists- " + p.getAssists());
                System.out.println(" Total- " + p.totalPoint());
            }
            System.out.println();
        }


    }//end method main
}//end class main