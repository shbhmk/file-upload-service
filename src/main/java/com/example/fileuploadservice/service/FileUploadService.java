package com.example.fileuploadservice.service;

import com.example.fileuploadservice.repository.FileRecordRepository;
import com.example.fileuploadservice.model.FileRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class FileUploadService {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadService.class);
    private static final String KAFKA_TOPIC = "file-uploads";
    @Autowired
    private FileRecordRepository fileRecordRepository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public String uploadFile(MultipartFile file){
        try{

            if (file.isEmpty()){
                throw new IllegalArgumentException("Uploaded file is empty");
            }


//            String contentType = file.getContentType();
//            if(!contentType.equals("text/csv") && !contentType.equals("application/json")){
//                throw new IllegalArgumentException("Unsupported File Format" + contentType );
//            }


            FileRecord fileRecord = new FileRecord();
            fileRecord.setFileName(file.getOriginalFilename());
            fileRecord.setFileSize(file.getSize());
            fileRecord.setFileType(file.getContentType());
            fileRecord.setUploadTime(LocalDateTime.now());

            logger.info("Saving file metadata to db : {}",fileRecord.getFileName());
            fileRecordRepository.save(fileRecord);

            logger.info("Publishing the metadata to the kafka {}" , KAFKA_TOPIC);
            kafkaTemplate.send(KAFKA_TOPIC , "got msg");


            return "File upload Successful";
        }catch (Exception e){
            throw new RuntimeException("Failed to uploadfile" + e.getMessage());
        }
    }
}
