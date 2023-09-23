import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int m;

    private static int n;

    private static ListNode originalList;

    private static ListNode result;

    private static boolean decision;

    public static void main(String [] args) {

        String file = "";

        int c = 0;

        file = JOptionPane.showInputDialog(null, "Welcome. Please enter the name of your file in order to create your Linked List");


        while(true) {

            if(c > 0) {
                file = JOptionPane.showInputDialog(null, "Please enter the name of your file in order to create your Linked List");
            }

            c++;

            if (file == null) {
                JOptionPane.showMessageDialog(null, "Please provide an answer");
                return;
            }

            if(file.equalsIgnoreCase("DONE")) {
                JOptionPane.showMessageDialog(null,"The end.");
                return;
            }

                decision = true;

                originalList = generateList(file);

                result = reverseBetween(generateList(file), m, n);

                if (decision) {

                    FrameDisplay frame = new FrameDisplay();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "If you want to try this interactive application, please try to write a valid .txt file name");

                }

            }

    }

    public static ListNode generateList(String filename) {

        File file = new File(filename);

        Scanner in = null;

        try {

          in = new Scanner(file);

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,"No such file found");

            decision = false;

            return null;

        }

        try {

            m = Integer.parseInt(in.next());

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,"Incorrect format for the .txt file");

            return null;
        }

        try {

            n = Integer.parseInt(in.next());

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,"Incorrect format for the .txt file");

            return null;

        }

        in.nextLine();

        ListNode node = new ListNode();

        ListNode prev = null, head = null;

        boolean flag = false;

        while(true) {
            assert in != null;
            if (!in.hasNext()) break;

            int x = 0;

            try {

                x = Integer.parseInt(in.next());

                node.setInfo(x);

            } catch(Exception e) {

               JOptionPane.showMessageDialog(null,"The .txt file can only have numerical values");

               return null;

            }

            if(!flag) {
                head = node;
                flag = true;
            }

            prev = node;

            node.next = new ListNode();

            node = node.next;


        }

        assert prev != null;
        prev.next = null;

        return head;

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode curr = head;

        ListNode prev = null;

        while(m > 1) {

            prev = curr;

            curr = curr.next;

            m--;

            n--;

        }

        ListNode con = prev, tail = curr;

        ListNode third = null;

        while(n > 0) {

            third = curr.next;

            curr.next = prev;

            prev = curr;

            curr = third;

            n--;

        }

        if(con != null) {

            con.next = prev;

        } else {

            head = prev;

        }

        if(tail != null) {
            tail.next = curr;
        }


        return head;

    }

    public ListNode getResult() {
        return result;
    }

    public ListNode getOriginalList() {
        return originalList;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }


}


