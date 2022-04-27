package core;

public abstract class Player implements IPlayer {

    public Player() {
        Roll rollDice = new Roll();
        int roll = 0;
    }
    private String name;
    private ScoreCard score;
    private boolean finished = false;
    private int roll;
    private Roll rollDice;
    private boolean catSelected = false;

     public boolean isCatSelected()
    {
        return catSelected;
    }

    public void setCatSelected(boolean input)
    {
        catSelected = input;
    }

    public Roll getRollDice()
    {
        return rollDice;
    }

    public void setRollDice(Roll roll)
    {
        this.rollDice = roll;
    }

    public void incrementRoll()
    {
        // call Rolls rolldice method
        if(roll < 3)
        {
            finished = false;
            roll++;
        }
        else
        {
            finished = true;
        }
    }

    public int getRoll()
    {
        return roll;
    }

    public void setRoll(int num)
    {
        roll = num;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void setFinished(boolean finished)
    {
        this.finished = finished;
    }

    public ScoreCard getScore()
    {
        return score;
    }

    public void setScore(ScoreCard score)
    {
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public abstract void selectDice(Roll original, Roll keep, int rollNum);
    public abstract void calculateScore(Roll keep, int category);
}
