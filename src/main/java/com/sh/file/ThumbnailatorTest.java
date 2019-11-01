package com.sh.file;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThumbnailatorTest {
    public static void main(String[] args) throws IOException {
//        BufferedImage originalImage = ImageIO.read(new File("4.png"));
//        int height = originalImage.getHeight();
//        int width = originalImage.getWidth();
//        System.out.println("====" + height + "===" + width);
        Thumbnails.of("4.png")
                .forceSize(100, 100)
                .toFile("5.png");
        File file = new File("");
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read();
    }
}
