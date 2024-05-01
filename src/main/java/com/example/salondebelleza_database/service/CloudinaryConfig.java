package com.example.salondebelleza_database.service;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary("cloudinary://744411175274459:xP_RAHjvPxYGvsgVnh15oOkit7s@johananube");
        return cloudinary;

    }

}

