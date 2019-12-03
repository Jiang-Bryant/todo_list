package com.tddtest.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Frank Yu
 * @date 11/7/2019
 */
@Data
@Document
public class SipgReport {
    @Id
    private String id;
    @Indexed
    private String transactionId;
    @Indexed
    private String blNumber;
    @Indexed
    private String eventDateTime;

    private LocalDateTime incomingDateTime;
    private LocalDateTime callSipgDateTime;

    private String sipgApiResponse;
    @Indexed
    private String status;
    @Indexed
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
