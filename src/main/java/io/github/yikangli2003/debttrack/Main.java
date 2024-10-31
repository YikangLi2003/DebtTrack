package io.github.yikangli2003.debttrack;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main(String[] args) {
        String jarDir = getJarDir();
        if (jarDir != null) {
            System.out.println("JAR file path" + jarDir);
        } else {
            System.out.println("Cannot determine the jar file path.");
        }
    }

    private static String getJarDir() {
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            File jarFile = new File(path);
            return jarFile.isFile() ? jarFile.getParent() : jarFile.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
