/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.kayklein.ui;

import de.kayklein.classes.IProperties;
import de.kayklein.log.Log;
import de.kayklein.task.TaskFactory;
import de.kayklein.ui.controls.ButtonReload;
import de.kayklein.ui.controls.LogTextArea;
import de.kayklein.ui.validator.impl.CommandArgsInputValidator;
import de.kayklein.ui.validator.impl.PathInputValidator;
import de.kayklein.ui.validator.impl.TimingsInputValidator;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kayklein
 */
public class MainWindow extends JFrame implements ButtonReload.Delegate {

    private IProperties config;
    private PathInputValidator validatorPath;
    private TimingsInputValidator validatorTimings;
    private CommandArgsInputValidator validatorArgs;
    private JButton btnReload;

    public MainWindow(IProperties config) {
        this.config = config;
        setTitle("Arma2 Server Observer");
        initComponents();

        setSize(800,600);
        setResizable(false);
    }

    @Override
    public void doReloadTimings() {
        Log.date();
        TaskFactory.cancelAll();
        String timings = config.getProperty("timings");
        if(timings != null) {
            Log.i("MainWindow.doReloadTimings" , String.format("Load Timings:") );
            List<String> times = Arrays.asList(timings.split(";"));
            for(String strTime : times){
                String[] time = strTime.split(":");
                TaskFactory.addTask(time[0] , time[1] );
            }
        }else {
            Log.i("MainWindow.doReloadTimings" , String.format("No timings specified") );
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="UI Code">
    private void initComponents() {
        final JPanel panelLeft      = new JPanel();
        final JLabel lblTimings     = new JLabel("Restart Times (00:00 - 12:59)");
        final JLabel lblPath        = new JLabel("Path");
        final JLabel lblCommandLine = new JLabel("Befehlszeile");
        final JButton btnStart      = new JButton("Start");
        final JButton btnStop       = new JButton("Stop");

        txtLogView       = new LogTextArea();
        Log.setAppender(txtLogView );


        btnReload        = new ButtonReload(this);

        txtTimings       = new JTextField(config.getProperty("timings"));
        validatorTimings = new TimingsInputValidator(config, txtTimings);

        txtPath          = new JTextField(config.getProperty("path"));
        validatorPath    = new PathInputValidator(config,txtPath );

        txtArgs          = new JTextField(config.getProperty("args"));
        validatorArgs    = new CommandArgsInputValidator(config, txtArgs);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panelLeft);
                panelLeft.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnStart)
                                    .addComponent(btnStop))
                            .addGap(0, 397, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimings)
                                    .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblPath)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblTimings)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnReload)))
                            .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnStart)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTimings)
                                .addComponent(btnReload))
                        .addGap(18, 18, 18)
                        .addComponent(txtTimings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(lblPath)
                        .addGap(18, 18, 18)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                );





        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtArgs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCommandLine)
                                        .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(txtLogView, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCommandLine))
                        .addComponent(txtLogView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtArgs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();

        doReloadTimings();
    }// </editor-fold>                        



    // Variables declaration - do not modify
    private LogTextArea txtLogView;
    private JTextField txtArgs;
    private JTextField txtPath;
    private JTextField txtTimings;
    // End of variables declaration
}
