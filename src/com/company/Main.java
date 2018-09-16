package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    ProgramLogic programLogic = new ProgramLogic(this);
    //ation listener
    GridLayout applicationLayout = new GridLayout(3, 1, 0, 10);

    //making the two buttons that decide whether program runs or not
    FlowLayout First_layout_buttons = new FlowLayout(FlowLayout.CENTER, 0, 40);
    JPanel First_panel = new JPanel();
    JButton Play = new JButton("Play");
    JButton Stop = new JButton("Stop");

    // The second panel of the application that shows data
    //it will be just random numbers
    GridLayout Second_layout_Labels = new GridLayout(2, 6, 30, 20);
    JPanel second_panel = new JPanel();
    JLabel[] NumberLabels = new JLabel[6];
    JTextField[] Number_JtextFirelds = new JTextField[6];

    //third layout to do later
    FlowLayout third_layout_statistic = new FlowLayout(FlowLayout.CENTER, 20, 0);
    JPanel third_panel = new JPanel();
    JLabel informationlabel = new JLabel("Type number:",JLabel.RIGHT);
    JTextField user_input = new JTextField("Type",30);
    JButton check = new JButton("check");


    Main() {

        //this is genral application layout
        super("Geron");
        setSize(800, 300);
        setLayout(applicationLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //setting the first panel componets
        First_panel.setLayout(First_layout_buttons);
        First_panel.add(Play);
        First_panel.add(Stop);
        Play.addActionListener(programLogic);
        Stop.addActionListener(programLogic);

        add(First_panel);

        //making second panel
        second_panel.setLayout(
                Second_layout_Labels
        );
        for (int i = 0; i <= 5; i++) {
            NumberLabels[i] = new JLabel();
            NumberLabels[i].setText(new String("Number " + Integer.toString(i+1) + " :"));
            NumberLabels[i].setHorizontalAlignment(JLabel.RIGHT);
            second_panel.add(NumberLabels[i]);
            Number_JtextFirelds[i] = new JTextField();
            Number_JtextFirelds[i].setEditable(false);
            Number_JtextFirelds[i].setHorizontalAlignment(JTextField.LEFT);
            second_panel.add(Number_JtextFirelds[i]);
        }
        add(second_panel);

        //to do makeing third componets

        third_panel.setLayout(third_layout_statistic);
        this.check.addActionListener(this.programLogic);
        third_panel.add(informationlabel, JPanel.RIGHT_ALIGNMENT);
        third_panel.add(this.user_input, JPanel.CENTER_ALIGNMENT);
        third_panel.add(this.check, JPanel.LEFT_ALIGNMENT);
        this.add(third_panel);

        //making visible
        setVisible(true);


    }


    public static void main(String[] args) {
        // write your code here
        setlookandfeel();
        Main window = new Main();
    }

    public static void setlookandfeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {
            System.out.println("An error has occured with message: "+
                    e.getMessage());
        }
    }
}
