import javax.swing.plaf.IconUIResource;
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
                System.out.println("Need at least 3 characters");
                i --;
            }
        }

        //display info
        System.out.println("\nPLAYER ENTRY");
        System.out.println("================================");



    }
}