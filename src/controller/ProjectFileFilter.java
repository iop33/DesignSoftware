package controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ProjectFileFilter extends FileFilter {
    @Override
    public String getDescription() {
        return "Rudok Project Files (*.rdk)";
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".rdk"));
    }
}
