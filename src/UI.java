import SwingWorkerUtils.DebugWorker;
import SwingWorkerUtils.PausableSwingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

    private JTextArea editText;
    private JButton nextButton;


    public UI(){
        super("Lil debugger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Pannello */
        JPanel centerPanel = new JPanel();
        nextButton = new JButton("Next step");
        nextButton.setEnabled(true);

        /* Text Area Inizializzata  */
        editText = new JTextArea(5,10);
        editText.setEditable(true);

        centerPanel.add(nextButton);
        centerPanel.add(editText);

        nextButton.setActionCommand("debug");
        nextButton.addActionListener(new DebugListener(editText, nextButton, this));

        getContentPane().add(centerPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

//        initApplication();
    }

    private void aggiornaRisultato(String risultato) {
        editText.setText(risultato);
        //Dopo aver inizializzato l'applicazione, si aggiorna la GUI tramite EDT
        Runnable target = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nextButton.setEnabled(true);
            }
        };
        //EDT writing
        SwingUtilities.invokeLater(target);
    }

    private void initApplication() {
        try{
            System.out.println("Inizializzando applicazione");
            Thread.sleep(100);
        } catch (InterruptedException e ){
            e.printStackTrace();
        }


/*
        //Dopo aver inizializzato l'applicazione, si aggiorna la GUI tramite EDT
        Runnable target = new Runnable() {
            @Override
            public void run() {
                nextButton.setEnabled(false);
            }
        };
*/


    }











}
