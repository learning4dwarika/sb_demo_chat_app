package com.practice.sb_demo.dtos.request;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class MessageDto {


//    private long messageId;

    private String from;
    private String to;
    private String content;
    private String createdAt;
}
