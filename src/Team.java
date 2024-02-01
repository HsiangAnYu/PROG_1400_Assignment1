public class Team {
    //all variable
    private final String name;
    private final double budget = Math.random()*100000;
    private Player[] players = new Player[3];

    //getter
    public String getName() {return name;}

    public double getBudget() {return budget;}

    public Player[] getPlayers() {return players;}

    //setter, only need players
    public void setPlayers(Player[] players) {this.players = players;}

    //constructor
    protected Team(String name){
        this.name = name;
    }

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
    protected String rating(int totalPoints){
        if(totalPoints > 20){return "3* stars";}
        else if (totalPoints > 10){return "2* stars";}
        else if(totalPoints > 0){return "1* star";}
        else{return "0 star";}
    }
}
