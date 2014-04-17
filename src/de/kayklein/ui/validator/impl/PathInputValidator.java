package de.kayklein.ui.validator.impl;

import de.kayklein.classes.IProperties;
import de.kayklein.ui.validator.AbsTextValidator;

import javax.swing.*;
import java.io.File;

/**
 * Created by kayklein on 17.04.14.
 */
public class PathInputValidator extends AbsTextValidator {



    public PathInputValidator(IProperties config, JTextField _textField) {
        super(config, "path", _textField);
    }


    protected boolean validate(String path) {
        File file = new File(path);
        return /*file.exists() &&*/ path.endsWith("arma3server.exe");
    }



}


