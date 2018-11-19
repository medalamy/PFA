/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.ioc;

import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 *
 * @author medEl
 */
public class ConfigReader {

    public static String getConfigClassName() throws Exception {

        URL url = ConfigReader.class.getResource("/com/pfa/ioc/DaoClass.txt");
        File file = new File(url.getPath());
        FileReader fileReader = new FileReader(file);
        StringBuffer stringBuffer = new StringBuffer();
        int numCharsRead;
        char[] charArray = new char[1024];
        while ((numCharsRead = fileReader.read(charArray)) > 0) {
            stringBuffer.append(charArray, 0, numCharsRead);
        }
        fileReader.close();
//        System.out.println("Contents of file:");
//        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

}
