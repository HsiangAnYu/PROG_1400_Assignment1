public class Player {
    //all variable
    private String name;

    //getter, don't need setter for player class
    public String getName() {return name;}

    public int getGoals() {return goals;}

    public int getAssists() {return assists;}

    private int goals;
    private int assists;

    //constructor
    protected Player(String name, int goals, int assists){
        this.name = name;
        this.goals = goals;
        this.assists = assists;
    }

    //method for goals + assist
    protected int totalPoint(){return this.goals + this.assists;}
}
