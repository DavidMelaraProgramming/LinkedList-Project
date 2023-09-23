import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Shows the way that the panel the drawings will be made in.
 *
 */
public class LinkedListDisplay extends JPanel
{
    
    public void paint(Graphics g)
    {

        Main main = new Main();

        ListNode node = main.getResult();

        int xIncrease = 60;

        int yIncrease = 20;

        int counter = 1;

        g.setColor(Color.RED);

        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,50));

        g.drawString("Reversing a Linked List between the "+main.getM()+" and "+main.getN()+" nodes",10,200);

        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));

        while(node != null) {
            g.setColor(Color.getHSBColor(0,0,0));
            g.drawRect(30+3*counter*xIncrease,240+yIncrease,100,60);
            g.setColor(Color.GREEN);
            g.fillRect(30+3*counter*xIncrease,240+yIncrease,100,60);
            g.setColor(Color.BLACK);
            g.drawLine(30+3*counter*xIncrease+70,240+yIncrease,30+3*counter*xIncrease+70,240+yIncrease+60);
            g.drawLine(30+3*counter*xIncrease,240+yIncrease,30+3*counter*xIncrease,240+yIncrease+60);
            g.drawString(String.valueOf(node.val),55+3*counter*xIncrease,270+yIncrease);
            g.drawLine(30+3*counter*xIncrease,240+yIncrease,30+3*counter*xIncrease+100,240+yIncrease);

            node = node.next;
            if(node != null) {
                g.drawLine(30+3*counter*xIncrease+160,278,30+3*counter*xIncrease+178,287);
                g.drawLine(30+3*counter*xIncrease+160,302,30+3*counter*xIncrease+182,290);
                g.drawLine(30 + 3 * counter * xIncrease + 100, (560 + yIncrease) / 2, 30 + 3 * counter * xIncrease + 180, (560 + yIncrease) / 2);
            }
            counter++;
        }




    }


}
