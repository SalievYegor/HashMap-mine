package org.itschoolhillel.dnepropetrovsk.ysaliev;

import org.itschoolhillel.dnepropetrovsk.ysaliev.entity.MyDirectory;
import org.itschoolhillel.dnepropetrovsk.ysaliev.entity.SimpleDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Created by Halvasan on 28.11.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

//        MyDirectory searchPath = new SimpleDirectory("./resources", null);
//        searchPath.addFile();

        MyDirectory dir = new SimpleDirectory("./resources" , null);
        dir.init();
        System.out.println(Arrays.toString(dir.listNames().toArray()));

        InputFile inputFile = new InputFile("E:/HashMap-mine-new/./resources/1/3/4/input.txt");
        inputFile.read();
        inputFile.print();
    }

//    InputFile inputFile = new InputFile("E:\HashMap-mine-new\.\resources\input.txt");
//    inputFile.read();
//    inputFile.print();

}
