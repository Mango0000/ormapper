package io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class io_Helper {

    public static List<String> getEntityClassnames(Path dirPath){
        List<String> classnames = new ArrayList<String>();
        File dir = new File(dirPath.toString());
        File[] dirContent = dir.listFiles();
        for (File file:dirContent){
            if(file.isDirectory()){
                classnames.addAll(getEntityClassnames(file.toPath()));
            }else if (file.isFile()){
                classnames.add(file.getAbsolutePath());
            }
        }
        return classnames;
    }

    public static void main(String[] args) {
        Path dirPaht = Paths.get(".","src","main","java")
        for (String str:getEntityClassnames(dirPaht)){
            System.out.println(str);
        }
    }
}
