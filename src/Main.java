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
            if(teamsArray[i].name.length() < 3)
            {
                System.out.println("Name need at least 3 characters");
                i --;
            }
        }

        //display info
        System.out.println("\nPLAYER ENTRY");
        System.out.println("================================");

        for(int i = 0; i < teamsArray.length; i++)
        {
            String tempName;
            int tempGoal;
            int tempAssist;

            System.out.println("Enter players for "+ teamsArray[i].name +" Picks:");

            for(int p = 0; p < playerArray.length; p++)
            {
                do{
                    System.out.println("Enter name for player # " + (p+1) +":");
                    tempName = sc.next();
                }while(tempName.length() < 3);

                do{
                    System.out.println("Enter number of goals for " + tempName);
                    tempGoal = sc.nextInt();
                }while(tempGoal < 0);

                do{
                    System.out.println("Enter number of assists for " + tempName);
                    tempAssist = sc.nextInt();
                }while(tempAssist < 0);

                playerArray[p] = new Player(tempName,tempGoal,tempAssist);
            }
            teamsArray[i].players = playerArray;
        }

        System.out.println(teamsArray[1].players[1].name + teamsArray[1].players[1].goals + teamsArray[1].players[1].assists);

    }
}