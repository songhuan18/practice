package com.sh;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Author sh
 * Date 2019-08-10 14:59
 */
public class Tess {
    public static void main(String[] args) throws TesseractException {
        Tesseract instance = new Tesseract();
        instance.setLanguage("jpn");
        File file = new File("/Users/songhuan/Downloads/2.png");
        instance.setDatapath("/usr/local/share/tessdata");
        String result = instance.doOCR(file);
        System.out.println(result);
    }
}
