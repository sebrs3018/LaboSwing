import SwingWorkerUtils.DebugWorker;
import SwingWorkerUtils.PausableSwingWorker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebugListener implements ActionListener {

    private JButton nextButton;
    private JTextArea textArea;
    private PausableSwingWorker debugWorker;
    private UI ui;

    public DebugListener(JTextArea _textArea, JButton _nextButton,UI _ui){
        textArea = _textArea;
        nextButton = _nextButton;
        ui = _ui;
        debugWorker = new DebugWorker(textArea, nextButton);
        debugWorker.execute();
    }

    @Override   //Questa action verrà eseguita dall'EDT
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "debug"){
            calculateNextStep();
        }
    }

    private void calculateNextStep() {
        debugWorker.resume();

/*        MonitorDebugger monitorDebugger = new MonitorDebugger(nextButton, debugWorker);
        debugWorker.addPropertyChangeListener(monitorDebugger);*/
//        System.out.println(debugWorker.getState());

    }

}
