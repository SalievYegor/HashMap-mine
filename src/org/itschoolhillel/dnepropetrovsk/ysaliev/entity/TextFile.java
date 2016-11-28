package org.itschoolhillel.dnepropetrovsk.ysaliev.entity;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Halvasan on 28.11.2016.
 */
public class TextFile extends AbstractFile {
    public TextFile(String name) {
        super(name);
    }

    public TextFile (File file) {
        super(file);
    }

    public List<String> lines() {
        List<String> lines = new LinkedList<>();
        File file = new File(this.name());

        try{

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found");
        } catch (IOException ioe) {
            System.err.println("Couldn't read file");
        }

        return lines;
    }
}
