package de.kayklein.ui.validator;

import de.kayklein.classes.IProperties;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by kayklein on 17.04.14.
 */
public abstract class AbsTextValidator implements DocumentListener, FocusListener {

    protected IProperties config;
    private String propertyKey;
    protected JTextField textField;

    public AbsTextValidator(IProperties _config, String _propertyKey, JTextField _textField) {
        config      = _config;
        propertyKey = _propertyKey;
        textField   = _textField;
        textField.getDocument().addDocumentListener(this);
        textField.addFocusListener(this);
    }

    protected abstract boolean validate(String path);

    private void updateUi(boolean valid) {
        if (valid) {
            textField.setBackground(Color.GREEN);
        } else {
            textField.setBackground(Color.RED);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateUi(validate(textField.getText()));
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateUi(validate(textField.getText()));
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateUi(validate(textField.getText()));
    }


    @Override
    public void focusGained(FocusEvent e) {
        updateUi(validate(textField.getText() ));
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(validate(textField.getText())) {
            textField.setBackground(Color.WHITE);
            config.setProperty(propertyKey, textField.getText().trim());
            config.safe();
        }else {
            updateUi(false );
        }
    }
}