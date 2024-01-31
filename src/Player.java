public class Player {
    //all variable
    private final String name;
    private final int goals;
    private final int assists;

    //getter, don't need setter for player class
    public String getName() {return name;}

    public int getGoals() {return goals;}

    public int getAssists() {return assists;}

    //constructor
    protected Player(String name, int goals, int assists){
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    //method for goals + assist
    protected int totalPoint(){return this.goals + this.assists;}
}
