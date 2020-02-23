package movecircle2;
// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    JButton left;
    JButton right;
    JButton up;
    JButton down;
    JPanel buttonPanel;
    
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        // Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");
        
        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);
        
        left.setToolTipText("Move Circle Left press Alt+l");
        right.setToolTipText("Move Circle Right press Alt+r");
        up.setToolTipText("Move Circle Up press Alt+u");
        down.setToolTipText("Move Circle Down press Alt+d");
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;
    
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            int temp_left;
            int temp_right;
            int temp_up;
            int temp_down;
            
            
            if(x+dx <= 0) {
                temp_left = -x;
                x += temp_left;
                repaint();
                left.setEnabled(false);
            } else {
                left.setEnabled(true);
                if(x+dx+CIRCLE_SIZE >= getWidth()) {
                    temp_right = getWidth() - (x+CIRCLE_SIZE);
                    x += temp_right;
                    repaint();
                    right.setEnabled(false);
                } else {
                    right.setEnabled(true);
                    x += dx;
                    repaint();
                }
            }
            
            if(y+dy <= 0) {
                temp_up = -y;
                y += temp_up;
                repaint();
                up.setEnabled(false);
            } else {
                up.setEnabled(true);
                if(y+dy+CIRCLE_SIZE >= getHeight() - (int)buttonPanel.getSize().getHeight()) {
                    temp_down = (getHeight() - (int)buttonPanel.getSize().getHeight()) - (y+CIRCLE_SIZE);
                    y += temp_down;
                    repaint();
                    down.setEnabled(false);
                } else {
                    y += dy;
                    repaint();
                    down.setEnabled(true);
                }
            }
        }
    }
}    