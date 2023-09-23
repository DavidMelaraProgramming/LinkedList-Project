import javax.swing.*;
import java.util.ArrayList;

/**
 * Defines a frame to which a panel with drawings will be added.
 *
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 450;
    int HEIGHT = 450;

    public FrameDisplay()
    {

        setTitle("Graph Display");
        setSize(4*WIDTH, 2*HEIGHT);

        LinkedListDisplay panel = new LinkedListDisplay();

        add(panel);

    }



}
