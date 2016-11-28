package org.itschoolhillel.dnepropetrovsk.ysaliev.entity;

import java.util.List;

/**
 * Created by Halvasan on 28.11.2016.
 */
public interface MyDirectory extends MyFile {

    void  addFile(MyFile file);
    List<String> listNames();
    void init();
}
