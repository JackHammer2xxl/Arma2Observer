package de.kayklein.ui.controls;

import de.kayklein.log.ILogAppender;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kayklein on 17.04.14.
 */
public class LogTextArea extends JScrollPane implements ILogAppender {


    private final JTextArea txtView;
    private final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    public LogTextArea() {
        txtView = new JTextArea();
        txtView.setEditable(false);
        txtView.setBackground(new java.awt.Color(51, 51, 51));
        txtView.setColumns(20);
        txtView.setFont(new java.awt.Font("Marion", 0, 13)); // NOI18N
        txtView.setForeground(new java.awt.Color(51, 153, 0));
        txtView.setRows(5);
        txtView.setText("Ama2 Observer\r\n");
        setViewportView(txtView);
    }



    public void append(String message){
        txtView.append(String.format("  %s\r\n" , message) );
    }

    public void logDate(){
        txtView.append(String.format("%s\r\n" , format.format(new Date())) );
    }

}
