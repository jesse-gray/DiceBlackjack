package nz.ac.eit;

public class GameEngine {
    private Die die = new Die();
    private Player user = new Player();
    private Player dealer = new Player();

    public GameEngine(){
    }

    //Runs through the entire dealer turn
    public void dealerTurn() {
        while(dealer.getScore() < 16) {
            hit(dealer);
        }
        checkScore(dealer);
    }

    //Checks to see if a player can keep playing
    public boolean checkScoreValid(Player player) {
        if (player.getScore() >= 21) {
            return false;
        } else{
            return true;
        }
    }

    //Player rolls two dice
    public void hit(Player player) {
        int turnScore = 0;
        for(int i = 0; i < 2; i++){
            turnScore += die.Roll();
        }
        player.updateScore(turnScore);
        checkScore(player);
    }

    //Calculates the outcome of the game, null is a draw.
    public Player calculateWinner() {
        int userScore = user.getScore();
        int dealerScore = dealer.getScore();
        if(userScore <= 21 && userScore > dealerScore){
            return user;
        }
        else if(userScore == dealerScore){
            return null;
        }
        else{
            return dealer;
        }
    }

    public Die getDie() {
        return die;
    }

    public void setDie(Die die) {
        this.die = die;
    }

    public Player getUser() {
        return user;
    }

    public void setUser(Player user) {
        this.user = user;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }
}
