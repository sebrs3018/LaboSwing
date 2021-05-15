import SwingWorkerUtils.DebugWorker;

import javax.swing.*;

public class MonitorDebugger {

    private JButton nextButton ;
    private DebugWorker debugWorker;

    public MonitorDebugger(JButton _nextButton, DebugWorker _debugWorker){
        nextButton = _nextButton;
        debugWorker = _debugWorker;
    }
/*
    @Override
    public  void propertyChange(PropertyChangeEvent evt) {
        String strPropertyName = evt.getPropertyName();

*//*        if("state".equals(strPropertyName)){
            try {
                while(nextButton.isEnabled()){
                    System.out.println("Primo passo completato, fermo il mio worker!");
                    wait();
                }
                System.out.println("Attesa terminata!");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*//*

    }*/
}
