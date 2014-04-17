package de.kayklein.ui.controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kayklein on 18.04.14.
 */
public class ButtonStop extends JButton  {

    public static interface Delegate {
        public abstract void doStopProcess();
    }

    public ButtonStop(String text, final Delegate delegate) {
        super(text);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delegate.doStopProcess();
            }
        });
    }

}
