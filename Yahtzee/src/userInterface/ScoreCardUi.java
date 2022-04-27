
package userInterface;

import core.Player;
import java.awt.Dimension;

import javax.swing.*;

public class ScoreCardUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel grandTotal;
    private LowerSectionUi lowerUi;
    private UpperSectionUi upperUi;
    private Player player;

    public ScoreCardUi()
    {
        initComponents();
    }

    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);

        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(300, 500));
        this.setPreferredSize(new Dimension(300, 500));
        this.setMaximumSize(new Dimension(300, 500));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        upperUi = new UpperSectionUi();
        lowerUi = new LowerSectionUi();

        grandTotal = new JLabel("GRAND TOTAL                                        0");
        grandTotal.setMinimumSize(new Dimension(300, 25));
        grandTotal.setPreferredSize(new Dimension(300, 25));
        grandTotal.setMaximumSize(new Dimension(300, 25));

        this.add(upperUi);
        this.add(lowerUi);
        this.add(grandTotal);
    }
}
