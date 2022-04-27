
package userInterface;

import constants.Constants;
import core.Die;
import core.LowerSection;
import core.Player;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;
import javax.swing.*;

public class LowerSectionUi extends JPanel
{
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private GridLayout gridLayout;
    private JLabel totalLower;
    private JLabel totalUpper;
    private JLabel totalLowerScore;
    private JLabel totalUpperScore;
    private LowerSection lowerSection;
    private Player player;
    private static int CATS = 7;
    private static int ROWS = 10;
    private static int COLS = 2;

    public LowerSectionUi()
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

        categories = new ArrayList<JButton>();
        scores = new ArrayList<JLabel>();

        for(int i = 0; i < CATS; i++)
        {
            // JButton for the category
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(150, 25));
            category.setPreferredSize(new Dimension(150, 25));
            category.setMaximumSize(new Dimension(150, 25));

            switch(i)
            {
                case 0:
                    category.setText("THREE OF A KIND");
                    break;
                case 1:
                    category.setText("FOUR OF A KIND");
                    break;
                case 2:
                    category.setText("FULL HOUSE");
                    break;
                case 3:
                    category.setText("SMALL STRAIGHT");
                    break;
                case 4:
                    category.setText("LARGE STRAIGHT");
                    break;
                case 5:
                    category.setText("YAHTZEE");
                    break;
                case 6:
                    category.setText("CHANCE");
                    break;
                case 7:
                    category.setText("YAHTZEE BONUS");
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }

            categories.add(category);

            JLabel score = new JLabel(String.valueOf(Constants.ZERO));
            score.setMinimumSize(new Dimension(50, 25));
            score.setMaximumSize(new Dimension(50, 25));
            score.setPreferredSize(new Dimension(50, 25));
            score.setHorizontalTextPosition(JLabel.CENTER);
            scores.add(score);
        }

        totalLower = new JLabel("TOTAL of Lower Section");
        totalLower.setMinimumSize(new Dimension(150, 25));
        totalLower.setPreferredSize(new Dimension(150, 25));
        totalLower.setMaximumSize(new Dimension(150, 25));

        totalLowerScore = new JLabel("0");
        totalLowerScore.setMinimumSize(new Dimension(50, 25));
        totalLowerScore.setPreferredSize(new Dimension(50, 25));
        totalLowerScore.setMaximumSize(new Dimension(50, 25));

        totalUpper = new JLabel("TOTAL of Upper Section");
        totalUpper.setMinimumSize(new Dimension(150, 25));
        totalUpper.setPreferredSize(new Dimension(150, 25));
        totalUpper.setMaximumSize(new Dimension(150, 25));

        totalUpperScore = new JLabel("0");
        totalUpperScore.setMinimumSize(new Dimension(50, 25));
        totalUpperScore.setPreferredSize(new Dimension(50, 25));
        totalUpperScore.setMaximumSize(new Dimension(50, 25));

        for(int row = 0; row < categories.size(); row++)
        {
            this.add(categories.get(row));
            this.add(scores.get(row));
        }

        this.add(totalLower);
        this.add(totalLowerScore);
        this.add(totalUpper);
        this.add(totalUpperScore);

    }
}
