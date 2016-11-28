package org.itschoolhillel.dnepropetrovsk.ysaliev;


import org.itschoolhillel.dnepropetrovsk.ysaliev.entity.TextFile;
import java.io.IOException;
import java.util.*;

/**
 * Created by Halvasan on 28.11.2016.
 */
public class InputFile {
    private final String nameFile;
    private final Map<String, List<Integer>> contents = new HashMap<>();

    InputFile(String nameFile) { this.nameFile = nameFile; }

    public void read() throws IOException {
        TextFile text = new TextFile(nameFile);

        for(String line: text.lines()) {
            if (!line.isEmpty()){
            String[] keyValue = line.split(" ");
                if (keyValue.length >= 1){
                    if (contents.get(keyValue[0]) == null)  {
                        contents.put(keyValue[0], new LinkedList<>());
                    }
                    for (int i = 1; i < keyValue.length; i++) {
                        List<Integer> valuesList = contents.get(keyValue[0]);
                        try{
                            valuesList.add(Integer.valueOf(keyValue[i]));
                        } catch (NumberFormatException nfe){
                            System.err.println(keyValue[i] + "is not number");
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (Map.Entry<String, List<Integer>> entry : contents.entrySet()) {
            System.out.println(entry.getKey() + " - " + Arrays.toString(entry.getValue().toArray()));
        }
    }
}
