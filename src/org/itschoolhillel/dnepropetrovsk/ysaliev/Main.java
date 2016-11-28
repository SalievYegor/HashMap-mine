package org.itschoolhillel.dnepropetrovsk.ysaliev;

import org.itschoolhillel.dnepropetrovsk.ysaliev.entity.MyDirectory;
import org.itschoolhillel.dnepropetrovsk.ysaliev.entity.SimpleDirectory;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Halvasan on 28.11.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException{

        MyDirectory dir = new SimpleDirectory("./resources", null);
        dir.init();
        System.out.println(Arrays.toString(dir.listNames().toArray()));
    }
}
