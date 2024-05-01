package com.example.salondebelleza_database.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service

public class CloudinaryService {

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();


    public CloudinaryService() {
        valuesMap.put("cloud_name", "johananube");
        valuesMap.put("api_key", "744411175274459");
        valuesMap.put("api_secret", "xP_RAHjvPxYGvsgVnh15oOkit7s");
        cloudinary = new Cloudinary(valuesMap);
        System.out.println(valuesMap);

    }

    public  Map cargarImagen(MultipartFile archivo) throws IOException {
        File file = convert(archivo);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }
    private File convert(MultipartFile multipartFile) throws IOException{
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }
}

