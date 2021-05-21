package SwingWorkerUtils;

import javax.swing.*;
import java.util.List;

public class DebugWorker extends PausableSwingWorker<Integer, Integer> {

    private JTextArea   textArea;
    private JButton     nextButton;
    private int step = 0;
    private static final int NROROUNDS = 10;

    //Il risultato della computazione i-esima sarà pubblicato nella textArea corrispondente
    public DebugWorker(JTextArea _textArea, JButton _nextButton){
        textArea    = _textArea;
        nextButton  = _nextButton;
        /* Al momento della creazione dello swingWorker mi sincronizzo col pulsante "next" */
        this.pause();
    }

    @Override //Worker thread body
    protected Integer doInBackground() throws Exception {

            while (step<NROROUNDS){
                /* Finche rimane in pausa, il mio thread non andrà avanti nella computazione... BUSY WAIT! */
                if(!isPaused()){
                    /* Simulo computazione pesante */
                    Thread.sleep(1000);
                    step++;
                    /* Una volta completato un passo dell'iterazione, pubblico il risultato */
                    publish(step);
                    /* Appena completato l'i-esimo passo, aspetto... */
                    this.pause();
                }
            }
        return null;
    }


    @Override //eseguito nell'EDT... Dunque posso riattivare il pulsante qua!
    protected void process(List<Integer> chunks) {
            for( var elem : chunks){
            if(isCancelled())
                break;

                textArea.append("Passo " + step + ": " + elem + "\n");
                nextButton.setEnabled(true);
            }
        }

    @Override
    protected void done() {
        super.done();
        textArea.append("Debug Finished");
        nextButton.setText("Finished");
        nextButton.setEnabled(false);
    }
}
