public class Team {
    //all variable
    String name = "";
    String stars;
    int totalGoals;
    int totalAssists;
    double budget = Math.random()*100000;
    Player[] players = new Player[3];

    //constructor
    public Team(String n){
        this.name = n;
    }

}
