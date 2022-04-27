package userInterface;

import constants.Constants;
import core.Die;
import core.Player;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.*;

public class RollUi extends JPanel
{
    private ArrayList<JToggleButton> dice;
    private BoxLayout boxLayout;
    private JButton rollButton;
    private Player player;

    public RollUi()
    {
        initComponents();
    }

    private void initComponents()
    {
        // layout manager
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        // setting up JPanel
        this.setMinimumSize(new Dimension(200, 450));
        this.setPreferredSize(new Dimension(200, 450));
        this.setMaximumSize(new Dimension(200, 450));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        dice = new ArrayList<JToggleButton>();

        DieListener dieListener = new DieListener();

        // creating the dice buttons
        for(int i = 0; i < Constants.NUM_DICE; i++)
        {
            JToggleButton die = new JToggleButton();
            die.setMinimumSize(new Dimension(65, 65));
            die.setPreferredSize(new Dimension(65, 65));
            die.setMaximumSize(new Dimension(65, 65));
            die.setAlignmentX(Component.CENTER_ALIGNMENT);
            die.putClientProperty("die", (i + 1));
            die.putClientProperty("value", (i + 1));
            die.putClientProperty("selected", false);
            die.addActionListener(dieListener);
            addImage(die);
            dice.add(die);
            dice.add(die);

            this.add(die);
        }

        // creating the roll button
        rollButton = new JButton("Roll Dice");
        rollButton.setMinimumSize(new Dimension(100, 100));
        rollButton.setPreferredSize(new Dimension(100, 100));
        rollButton.setMaximumSize(new Dimension(100, 100));
        rollButton.setFont(new Font("Serif", Font.BOLD, 16));

        this.add(rollButton);
    }

      public void setDice(ArrayList<Die> diceData)
      {
          int index = 0;
          for(JToggleButton die : dice)
          {
              die.putClientProperty("value", diceData.get(index).getFaceValue());
              addImage(die);
              index++;
          }

      }

// method for adding the images to the dice buttons
    private void addImage(JToggleButton die)
    {
        int value = (int)die.getClientProperty("value");
        ImageIcon dieImage = new ImageIcon();

        switch(value)
        {
            case 1:
               dieImage = new ImageIcon( getClass().getResource("../images/one.png"));
                break;
            case 2:
                dieImage = new ImageIcon( getClass().getResource("../images/two.png"));
                break;
            case 3:
                dieImage = new ImageIcon( getClass().getResource("../images/three.png"));
                break;
            case 4:
                dieImage = new ImageIcon( getClass().getResource("../images/four.png"));
                break;
            case 5:
                dieImage = new ImageIcon( getClass().getResource("../images/five.png"));
                break;
            case 6:
                dieImage = new ImageIcon( getClass().getResource("../images/six.png"));
                break;
        }

        dieImage = imageResize(dieImage);
        die.setIcon(dieImage);
    }
    // method to resize the image to fit on the jbutton
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

   // public void resetSelectedDice() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    private class DieListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            int die = 0;
            int value = 0;
            boolean selected = false;

            if(ae.getSource() instanceof JToggleButton)
            {
                JToggleButton button = (JToggleButton)ae.getSource();
                die = (int)button.getClientProperty("die");
                value = (int)button.getClientProperty("value");

                selected = button.isSelected();

                if(selected)
                {
                    button.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
                    button.putClientProperty("selected", true);
                }
                else
                {
                    button.setBorder(BorderFactory.createLineBorder(null));
                    button.putClientProperty("selected", false);
                }
            }
        }
    }

    private class RollListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            // this rolls all dice regardless of which are selected
//            ArrayList<Die> diceData = player.getRoll().getDice();

            int counter = 0;

//            player.incrementRoll();

            for(JToggleButton die: dice)
            {
                boolean selected = (boolean)die.getClientProperty("selected");
                if(!selected)
                {
 //                   dice. .get(counter).rollDie();
                }
                counter++;
            }

//            setDice(player.getRoll().getDice());
        }
    }
}
