package com.Excel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Excel.service.StorageService;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class Application {

	@Autowired
	private StorageService storageService;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException{
		String uploadImage = storageService.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadimage(@PathVariable String fileName){
		byte[] imageData=storageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
	}
	
	
	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image")MultipartFile file) throws IOException{
		String uploadImage = storageService.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
	
	@GetMapping("/fileSystem/{fileName}")
	public ResponseEntity<?> downloadimageToFileSystem(@PathVariable String fileName) throws IOException{
		byte[] imageData=storageService.downloadImageToFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
