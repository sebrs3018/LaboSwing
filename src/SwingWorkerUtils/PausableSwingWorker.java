package SwingWorkerUtils;

import javax.swing.*;


//Classe wrapper dello swingWorker che mi permette di mettere in pausa oppure di riattivare il mio SwingWorker
//Piccolo compromesso in quanto se viene chiamata la wait nel debugWorker, il suo stato cambia
public abstract class PausableSwingWorker<K,V> extends SwingWorker<K,V> {

    private volatile boolean isPaused;

    public final void pause() {
        if (!isPaused() && !isDone()) {
            isPaused = true;
        }
    }

    public final void resume() {
        if (isPaused() && !isDone()) {
            isPaused = false;
        }
    }

    public final boolean isPaused() {
        return isPaused;
    }

}
