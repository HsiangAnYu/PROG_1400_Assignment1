public class Player {
    //all variable
    String name;
    int goals;
    int assists;

    //constructor
    public Player(String n, int g, int a){
        this.name = n;
        this.goals = g;
        this.assists = a;
    }

    public int totalPoint(){
        return this.goals + this.assists;
    }
}
