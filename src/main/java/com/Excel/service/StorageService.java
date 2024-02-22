package com.Excel.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Excel.entity.FileData;
import com.Excel.entity.ImageData;
import com.Excel.repository.FileDataRepository;
import com.Excel.repository.StorageRepository;
import com.Excel.util.ImageUtils;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;
	
	@Autowired
	private FileDataRepository fileDataRepository;
	
	private final String FOLDER_PATH="C:\\Users\\HP\\Desktop\\FileData folder\\";
	
	
	public String uploadImage(MultipartFile file) throws IOException {
		
		  ImageData imageData=storageRepository.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		  
		if(imageData != null) {
			return "file uploaded successfully :"+file.getOriginalFilename();
		}
		return null;
	}
	
	public byte[] downloadImage(String fileName) {
		
		Optional<ImageData> dbImageData=storageRepository.findByName(fileName);
		byte[]images=ImageUtils.decompressImage(dbImageData.get().getImageData());
		return images;
	}
	
	
	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		  String filePath=FOLDER_PATH+file.getOriginalFilename();
		  
		  FileData filedata=fileDataRepository.save(FileData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filePath).build());
		  
		  file.transferTo(new File(filePath));
		  
		if(filedata != null) {
			return "file uploaded successfully :"+file.getOriginalFilename();
		}
		return null;
	}
	
     public byte[] downloadImageToFileSystem(String fileName) throws IOException {
		
		Optional<FileData> fileData=fileDataRepository.findByName(fileName);
		String filePath=fileData.get().getFilePath();
		byte[]images=Files.readAllBytes(new File(filePath).toPath());
		return images;
	}
}
