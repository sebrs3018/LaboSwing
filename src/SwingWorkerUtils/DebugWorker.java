package SwingWorkerUtils;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DebugWorker extends PausableSwingWorker<Integer, Integer> {

    private JTextArea textArea;
    private final JButton nextButton;
    private int step = 0;

    //Il risultato della computazione i-esima sarà pubblicato nella textArea corrispondente
    public DebugWorker(JTextArea _textArea, JButton _nextButton){
        textArea = _textArea;
        nextButton = _nextButton;
        this.pause();
//        ui = _ui;
    }

    @Override //Worker thread body
    protected Integer doInBackground() throws Exception {

//        while(!isCancelled()){
            while (step<3){
                if(!isPaused()){
                    step++;
                    //Una volta completato un passo dell'iterazione, pubblico il risultato
                    publish(step);
                    /* E' necessario chiamare la sleep perchè i risultati siano recuperati dalla process*/
                    Thread.sleep(100);
                }else{
                    Thread.sleep(200);
            }
        }
        return null;
    }


    @Override
    protected void process(List<Integer> chunks) {

        System.out.println("chunk size: " + chunks.size());

            for( var elem : chunks){

            if(isCancelled())
                break;

                textArea.append("Passo " + step + ": " + elem + "\n");
                this.pause();

            }
        }



    @Override
    protected void done() {
        super.done();
        System.out.println("Debugging finito!");
        textArea.append("Debug Finished");
    }



    /**
     * Wait the given time in milliseconds

     */
    private void waitForReactivation () {
        try {
            Thread.sleep(1000);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    } // End of Method: waitFor()

    public void goAhead(){
        notify();
    }

}
