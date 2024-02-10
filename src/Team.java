public class Team {
    //all variable
    private final String name;
    private final double budget = Math.random()*100000; // the rubric say between 0 ~ 100000, so I didn't plus 1
    private final int playerNum = 3;
    private Player[] players = new Player[playerNum];

    //I only include getter and setter that's necessary to run this program
    //getter
    public String getName() {return name;}

    public int getPlayerNum() {return playerNum;}

    public double getBudget() {return budget;}

    public Player[] getPlayers() {return players;}

    //setter, only need players
    public void setPlayers(Player players, int i) {this.players[i] = players;}

    //constructor, only include name, player info will add later
    protected Team(String name){this.name = name;}

    //method for cal total goals for team
    protected int totalGoals(){
        int goals = 0;
        for(Player p : players)
        {goals += p.getGoals();}

        return goals;
    }

    //method for cal total assists for team
    protected int totalAssists(){
        int assists = 0;
        for(Player p : players)
        {assists += p.getAssists();}

        return assists;
    }

    //method for cal total goals + assists
    protected int totalPoints(){
        int totals = 0;
        for(Player p : players)
        {totals += p.totalPoint();};

        return totals;
    }

    //method for cal rating stars
    //I know it will be better to make the range in variable, but I'm too lazy
    protected String rating(int totalPoints){
        if(totalPoints > 20){return "3* stars";}
        else if (totalPoints >= 10){return "2* stars";}
        else if(totalPoints > 0){return "1* star";}
        else{return "0 star";}
    }
}
