package com.fushi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Uploads {
    private static String UPLOADED_FOLDER = "./src/images/";

    public static String writeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "";
        }

            // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        String filename = file.getOriginalFilename()+ "_" + new Date().getTime();
        Path path = Paths.get(UPLOADED_FOLDER + filename);
        Files.write(path, bytes);
        return filename;
    }
}
