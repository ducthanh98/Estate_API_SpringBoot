package com.fushi.controller;

import com.fushi.util.Response;
import com.fushi.util.Uploads;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = "/files")
public class FileController {

    @GetMapping(path = "/get/{name:.+}")
    public @ResponseBody byte[] getImage(@PathVariable("name")  String name) throws IOException {
        Path path = Paths.get(Uploads.UPLOADED_FOLDER + name);
        return Files.readAllBytes(path);
    }
}
