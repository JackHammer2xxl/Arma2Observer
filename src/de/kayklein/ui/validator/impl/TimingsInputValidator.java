package de.kayklein.ui.validator.impl;

import de.kayklein.classes.IProperties;
import de.kayklein.classes.TimingsParser;
import de.kayklein.ui.validator.AbsTextValidator;

import javax.swing.*;

/**
 * Created by kayklein on 17.04.14.
 */
public class TimingsInputValidator extends AbsTextValidator {


    private TimingsParser timingsParser = new TimingsParser();
    public TimingsInputValidator(IProperties _config, JTextField _textField) {
        super(_config, "timings", _textField);
    }

    @Override
    protected boolean validate(String timings) {
        return timingsParser.isValid(timings);
    }
}
