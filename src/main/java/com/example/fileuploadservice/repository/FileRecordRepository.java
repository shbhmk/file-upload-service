package com.example.fileuploadservice.repository;

import com.example.fileuploadservice.model.FileRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRecordRepository extends JpaRepository<FileRecord,Long> {
}
