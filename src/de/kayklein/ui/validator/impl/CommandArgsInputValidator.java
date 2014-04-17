package de.kayklein.ui.validator.impl;

import de.kayklein.classes.IProperties;
import de.kayklein.ui.validator.AbsTextValidator;

import javax.swing.*;

/**
 * Created by kayklein on 17.04.14.
 */
public class CommandArgsInputValidator extends AbsTextValidator {

    public CommandArgsInputValidator(IProperties _config, JTextField _textField) {
        super(_config, "args", _textField);
    }

    @Override
    protected boolean validate(String path) {
        return true;
    }
}
