package de.kayklein.ui.controls;

import javax.swing.*;

/**
 * Created by kayklein on 17.04.14.
 */
public class ButtonReload extends JButton {

    public static interface Delegate {
        public abstract void doReloadTimings();
    }

    public ButtonReload(final Delegate delegate) {
        setIcon((new javax.swing.ImageIcon(getClass().getResource("/assets/img_reload.gif")))); // NOI18N
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delegate.doReloadTimings();
            }
        });
    }

}
