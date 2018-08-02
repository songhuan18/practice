package com.yg.file;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThumbnailatorTest {
    public static void main(String[] args) throws IOException {
//        BufferedImage originalImage = ImageIO.read(new File("4.png"));
//        int height = originalImage.getHeight();
//        int width = originalImage.getWidth();
//        System.out.println("====" + height + "===" + width);
        Thumbnails.of("4.png")
                .forceSize(100, 100)
                .toFile("5.png");
    }
}
