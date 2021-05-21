import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Main {


    public static void main(String[] args) {

        Runnable init = new Runnable() {
            @Override
            public void run() {
                new UIDebugger();
            }
        };

        try {
            SwingUtilities.invokeAndWait(init);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
