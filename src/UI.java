import javax.swing.*;

public class UI extends JFrame {

    private JEditorPane editText;
    private JButton nextButton;


    public UI(){
        super("Lil debugger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        nextButton = new JButton("Next step");
        nextButton.setEnabled(true);
        centerPanel.add(nextButton);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        initApplication();
    }

    private void initApplication() {
        try{
            System.out.println("Inizializzando applicazione");
            Thread.sleep(100);
        } catch (InterruptedException e ){
            e.printStackTrace();
        }


        //Dopo aver inizializzato l'applicazione, si aggiorna la GUI tramite EDT
        Runnable target = new Runnable() {
            @Override
            public void run() {
                nextButton.setEnabled(false);
            }
        };


    }











}
