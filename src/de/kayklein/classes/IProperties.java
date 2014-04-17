package de.kayklein.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by kayklein on 17.04.14.
 */
public class IProperties extends Properties {


    private final String name;
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");

    public IProperties(String _name) throws IOException, URISyntaxException {
        name = _name;
        if(!new File(_name).exists()) {
            URL resource = getClass().getResource("/assets/config.properties");
            load(new FileInputStream(new File(resource.toURI())));
        }else {
            load(new FileInputStream(name));
        }
    }

    public boolean safe(){
        boolean isUpdated = false;
        try {
            store(new FileOutputStream(name), "Software from JackHammer2xxl2@Skype"/*String.format("Edit %s", format.format(new Date()))*/);
            isUpdated = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

}
