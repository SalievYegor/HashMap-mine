package org.itschoolhillel.dnepropetrovsk.ysaliev.entity;

import java.io.File;
import java.util.Date;

/**
 * Created by Halvasan on 28.11.2016.
 */
public abstract class AbstractFile  implements MyFile {

    private final  String name;
    private final File file;

    public AbstractFile(String name){
        this.name = name;
        this.file = new File(name);
    }

    public AbstractFile(File file){
        this.name = file.getName();
        this.file = file;
    }

    protected File file() {
        return  this.file;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Long size() {
        return 0l;
    }

    @Override
    public Date createdDate() {
        return new Date();
    }
}
