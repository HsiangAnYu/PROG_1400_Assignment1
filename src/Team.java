public class Team {
    //all variable
    private String name = "";
    private String stars;
    private double budget = Math.random()*100000;
    private Player[] players = new Player[3];

    //getter
    public String getName() {return name;}

    public String getStars() {return stars;}

    public double getBudget() {return budget;}

    public Player[] getPlayers() {return players;}

    //setter, only need stars and players
    public void setStars(String stars) {this.stars = stars;}

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
    protected  int totalPoints(){
        int totals = 0;
        for(Player p : players)
        {totals += p.totalPoint();};

        return totals;
    }

}
