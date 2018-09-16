package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

public class ProgramLogic implements Runnable,
        ActionListener {

    //class data
    private Main Program;
    private Thread Running_Thread ;
    //statistic
    HashMap <Integer, Integer> Stats = new HashMap <>(50, 0.7F);

    @Override
    public void run() {
        Thread temporary = Running_Thread.currentThread();
        while (temporary == Running_Thread) {
            for (int i = 0; i < 6; i++) {
                int temp = (int) (Math.random() * 100);
                Stats.put(temp, Stats.get(temp + 1));
                Program.Number_JtextFirelds[i].setText(
                        Integer.toString(temp)
                );
            }
        }

    }

    //the constructor setts the gui where program logic
    // will be implemented and starts it

    public ProgramLogic(Main Program) {
        this.Program = Program;
    }

    //methods resposible for actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Play")) {
            startPlaying();
        }
        if (command.equals("Stop")) {
            stopPlaying();
        }
        if (command.equals("check")) {
            showStatistics();
        }
    }

    // odpowiednie funkcje
    public void startPlaying() {

        System.out.println("In playing function ");
        Running_Thread = new Thread(this);
        Running_Thread.start();
        Program.Play.setEnabled(false);
        Program.Stop.setEnabled(true);

    }

    public void stopPlaying() {
        Running_Thread = null;
        Program.Play.setEnabled(true);
        Program.Stop.setEnabled(false);

    }

    public void showStatistics() {

        System.out.println("In checking function");
        int numbertoshow = 1;
        try {
            String numberr = Program.user_input.getText();
            numbertoshow = (Integer.parseInt(numberr));
        } catch (Exception e) {
            System.out.println("An error has occured");
            numbertoshow=1;
        }
        finally {
            this.Program.informationlabel.setText(
                    "Amount of Number " + Integer.toString(numbertoshow) + " appearance"
            );
            this.Program.user_input.setText(
                    Integer.toString(1
                           // this.Stats.get(numbertoshow)
                    )
            );
        }
    }


}
