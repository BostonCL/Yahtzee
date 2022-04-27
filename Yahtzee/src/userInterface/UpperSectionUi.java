
package userInterface;

import constants.Constants;
import core.Player;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class UpperSectionUi extends JPanel
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private JLabel total;
    private JLabel bonus;
    private JLabel totalScore;
    private JLabel totalScr;
    private JLabel bonusScr;
    private JLabel totalScoreScr;
    private Player player;
    private static int CATS = 6;
    private static int ROWS = 9;
    private static int COLS = 2;
    private GridLayout gridLayout;

    public UpperSectionUi()
    {
        initComponents();
    }

    private void initComponents()
    {
        // layout manager
        gridLayout = new GridLayout(ROWS, COLS);

        // setting up JPanel
        this.setLayout(gridLayout);
        this.setMinimumSize(new Dimension(300, 250));
        this.setPreferredSize(new Dimension(300, 250));
        this.setMaximumSize(new Dimension(300, 250));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList();
        scores = new ArrayList();

        for(int i = 0; i < CATS; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(120, 25));
            category.setPreferredSize(new Dimension(120, 25));
            category.setMaximumSize(new Dimension(120, 25));

            switch(i)
            {
                case 0:
                    category.setText("ACES");
                    break;
                case 1:
                    category.setText("TWOS");
                    break;
                case 2:
                    category.setText("THREES");
                    break;
                case 3:
                    category.setText("FOURS");
                    break;
                case 4:
                    category.setText("FIVES");
                    break;
                case 5:
                    category.setText("SIXES");
                    break;
                default:
                    break;
            }
            categories.add(category);

            JLabel score = new JLabel(String.valueOf(Constants.ZERO));
            score.setMinimumSize(new Dimension(50, 25));
            score.setMaximumSize(new Dimension(50, 25));
            score.setPreferredSize(new Dimension(50, 25));
            score.setVerticalTextPosition(JLabel.CENTER);
            score.setHorizontalTextPosition(JLabel.CENTER);

            scores.add(score);
        }

        totalScore = new JLabel("TOTAL SCORE");
        totalScore.setMinimumSize(new Dimension(120, 25));
        totalScore.setPreferredSize(new Dimension(120, 25));
        totalScore.setMaximumSize(new Dimension(120, 25));

        totalScoreScr = new JLabel("0");
        totalScoreScr.setMinimumSize(new Dimension(50, 25));
        totalScoreScr.setPreferredSize(new Dimension(50, 25));
        totalScoreScr.setMaximumSize(new Dimension(50, 25));

        bonus = new JLabel();
        bonus.setText("BONUS");
        bonus.setMinimumSize(new Dimension(120, 25));
        bonus.setPreferredSize(new Dimension(120, 25));
        bonus.setMaximumSize(new Dimension(120, 25));

        bonusScr = new JLabel();
        bonusScr.setText("0");
        bonusScr.setMinimumSize(new Dimension(50, 25));
        bonusScr.setPreferredSize(new Dimension(50, 25));
        bonusScr.setMaximumSize(new Dimension(50, 25));

        total = new JLabel("TOTAL of Upper Section");
        total.setMinimumSize(new Dimension(120, 25));
        total.setPreferredSize(new Dimension(120, 25));
        total.setMaximumSize(new Dimension(120, 25));

        totalScr = new JLabel("0");
        totalScr.setMinimumSize(new Dimension(50, 25));
        totalScr.setPreferredSize(new Dimension(50, 25));
        totalScr.setMaximumSize(new Dimension(50, 25));
        System.out.println(categories.size());
        // add the UI components
        for(int row = 0; row < categories.size(); row++)
        {
            this.add(categories.get(row));
            this.add(scores.get(row));
        }

        this.add(totalScore);
        this.add(totalScoreScr);
        this.add(bonus);
        this.add(bonusScr);
        this.add(total);
        this.add(totalScr);

    }
}
