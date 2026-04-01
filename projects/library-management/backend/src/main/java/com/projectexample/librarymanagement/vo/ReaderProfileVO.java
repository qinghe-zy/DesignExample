package com.projectexample.librarymanagement.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReaderProfileVO {

    private Long id;
    private String readerNo;
    private String readerName;
    private String readerType;
    private String phone;
    private Integer status;
}
