import SwingWorkerUtils.DebugWorker;
import SwingWorkerUtils.PausableSwingWorker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugListener implements ActionListener {

    private final PausableSwingWorker debugWorker;
    private JButton nextButton;

    public DebugListener(JTextArea _textArea, JButton _nextButton){
        nextButton = _nextButton;
        /* Passo al DebugWorker gli oggetti su cui eseguirà delle modifiche... nel Done() oppure nella process! */
        debugWorker = new DebugWorker(_textArea, _nextButton);
        /* Faccio partire subito il workerThread in stato "pause"*/
        debugWorker.execute();
    }

    @Override   //Questa action verrà eseguita dall'EDT
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("debug")){
            calculateNextStep();
        }
    }

    private void calculateNextStep() {
        /* Disabilito il pulsante finchè non completo un passo della mia computazione */
        nextButton.setEnabled(false);
        /* Questa funzione mi permette di riattivare il mio swingWorker - Viene chiamato ogni volta che schiaccio il pulsante*/
        debugWorker.resume();
    }

}
