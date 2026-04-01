package com.projectexample.librarymanagement.service;

import com.projectexample.librarymanagement.dto.ReaderProfileSaveRequest;
import com.projectexample.librarymanagement.vo.ReaderProfileVO;

import java.util.List;

public interface ReaderProfileService {

    List<ReaderProfileVO> listReaders();

    ReaderProfileVO createReader(ReaderProfileSaveRequest request);

    ReaderProfileVO updateReader(Long id, ReaderProfileSaveRequest request);

    void deleteReader(Long id);
}
