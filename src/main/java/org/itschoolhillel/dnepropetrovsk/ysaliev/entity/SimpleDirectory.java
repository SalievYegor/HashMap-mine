package org.itschoolhillel.dnepropetrovsk.ysaliev.entity;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Halvasan on 28.11.2016.
 */
public class SimpleDirectory extends AbstractFile implements MyDirectory {
    private final MyDirectory parent;
    private final List<MyFile> internals = new LinkedList();

    public SimpleDirectory(String name, MyDirectory parent) {
        super(name);
        this.parent = parent;
    }

    public SimpleDirectory(File file, MyDirectory parent){
        super(file);
        this.parent = parent;
    }

    //@Override
    public void addFile(MyFile file) {
        this.internals.add(file);
    }

   // @Override
    public List<String> listNames(){
        List<String> names = new LinkedList();
        for (MyFile file : internals) {
            names.add(file.name());
        }
        return names;
    }

//    public void searchFile(File dir) throws IOException {
//        if (dir.isDirectory()){
//            File[] files = dir.listFiles();
//            for ( File file : files ) {
//                if (file.isDirectory())
//                    searchFile(file);
//            }
//            for (File file : files ) {
//                if (file.isFile()) {
//                    file.getAbsolutePath();
//                }
//            }
//        }
//    }

    //@Override
    public void init(){

        System.out.println(name());

        if (file().isDirectory()) {
            File[] files = file().listFiles(new FileFilter() {
     //           @Override
                public boolean accept(File pathname) {
                    if (pathname == null) {
                        return false;
                    }
                    if (pathname.isDirectory()){
                        return true;
                    }
          //          String namefile = pathname.getAbsolutePath();
                    String namefile = null;
                    try {
                        namefile = pathname.getCanonicalPath();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("File path: " +namefile);
                 // System.out.println(pathname);
                    return namefile != null && namefile.endsWith("txt");
                }
            });
            for (File file : files) {

                if (file.isDirectory()) {
                    SimpleDirectory dir = new SimpleDirectory(file, this);
                    dir.init();
                    internals.add(dir);
                } else {
                    internals.add(new TextFile(file));
                }
            }
        }
    }
}


