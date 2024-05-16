package com.demo.persistencia.demopersistencia.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = "http://127.0.0.1:5501")
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/load")
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            return ResponseEntity.ok(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al leer el archivo");
        }
    }
}
