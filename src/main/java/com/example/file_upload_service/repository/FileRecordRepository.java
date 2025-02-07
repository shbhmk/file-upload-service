package com.example.file_upload_service.repository;

import com.example.file_upload_service.model.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRecordRepository extends JpaRepository<FileRecord,Long> {
}
