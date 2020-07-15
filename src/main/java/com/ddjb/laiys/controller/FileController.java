package com.ddjb.laiys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController("/file")
public class FileController {

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        return "success";
    }
}
