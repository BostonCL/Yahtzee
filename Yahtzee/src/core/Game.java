package core;

import constants.Constants;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import userInterface.YahtzeeUi;

public class Game
{
    private int gameTurn;
    private ArrayList<Player> players;
    private YahtzeeUi yahtzeeUi;
    private Roll dice;
    private Player currentPlayer;

    public Game(YahtzeeUi ui)
    {
        yahtzeeUi = ui;

        createPlayers();
        //game turns to 0
        setGameTurn(Constants.ZERO);

       JOptionPane.showMessageDialog(null, "Let's Play Yahtzee!");
    }

    private void createPlayers()
    {
        // instantiate the players ArrayList
        players = new ArrayList();

        // get the human player name
        //Scanner scan = new Scanner(System.in);
        //System.out.println("Enter human player name");
        //String name = scan.next();
        for(int p = 0; p < Constants.TWOS; p++)
        {
        String name = JOptionPane.showInputDialog("Enter player name");
        HumanPlayer hp = new HumanPlayer();
        hp.setName(name);
        players.add(hp);
        }
        // instantiate the ai player
       // AiPlayer ap = new AiPlayer();
        //ap.setName("AI Player");

        // add players to array
       // players.add(hp);
        //players.add(ap);
    }

    private void displayPlayers()
    {
        //System.out.println("***************************");
        System.out.println("Players for this game are: ");
        //System.out.println("***************************");

        // loop through players and display information
        for(Player player : players)
        {
            System.out.println(player.getName());
        }
    }

    private void switchPlayers()
    {
        currentPlayer.setFinished(false);
        currentPlayer.setCatSelected(false);
        currentPlayer.setRoll(0);
        yahtzeeUi.getRollUi().resetSelectedDice();

        if(currentPlayer == players.get(Constants.ZERO))
        {
            currentPlayer = players.get(Constants.ONES);
        }
        else if(currentPlayer == players.get(Constants.ONES))
        {
            currentPlayer = players.get(Constants.ZERO);
        }
    }

    public void playGame()
    {
       dice = new Roll();
       currentPlayer = players.get(Constants.ZERO);

       for(int turn = 0; turn < Constants.NUM_CATERGORY; turn++)
       {
           yahtzeeUi.getGameUi().setGameTurnValue(turn + 1);

           for(int p = 0; p < 2; p++)
           {
                currentPlayer.rollDice(dice);

                JOptionPane.showMessageDialog(yahtzeeUi.getRollUi(), currentPlayer.getName());

                while(!currentPlayer.isFinished())
                {
                    yahtzeeUi.getPlayerUi().setPlayerName(currentPlayer.getName());
                    yahtzeeUi.getScoreCardUi().setPlayer(currentPlayer);
                    yahtzeeUi.getRollUi().setPlayer(currentPlayer);
                }

                while(!currentPlayer.isCatSelected())
                {
                    //
                }
                switchPlayers();
           }



        /*int roll = 0;

        // instantiate the roll object to create the dice
        dice = new Roll();

        // loop through each player and have them do one roll
        for(Player player : players)
        {
            // pass the roll object to the player
            System.out.println("**********************************");
            System.out.println("Player " + player.getName() + " was passed the dice");

            // instantiate an instance of class Roll and remove the dice
            Roll selected = new Roll();
            selected.removeDice(selected);

            System.out.println("Player " + player.getName() + " rolling the dice");

            while(selected.getDice().size() < Constants.NUM_DICE &&
                  roll < Constants.MAX_ROLLS)
            {
                System.out.println("*******");
                System.out.println("Roll " + roll);
                System.out.println("*******");
                // rolling the dice
                player.rollDice(dice);

                System.out.println("**********************************");
                System.out.println("Player " + player.getName() + " select dice to keep");

                // ask the player to select the dice to keep
                player.selectDice(dice, selected, roll);

                roll++;
            }

            player.selectCategory(selected);
        }
    }*/

    public void getDice()
    {
        return dice;
    }

    public void setDice(Roll dice)
    {
        this.dice = dice;
    }

    /**
     * @return the gameTurn
     */
    public int getGameTurn()
    {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(int gameTurn)
    {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players)
    {
        this.players = players;
    }
}
