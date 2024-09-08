package com.practice.sb_demo.dtos.response;


import lombok.Data;

import java.util.Date;

@Data
public class MessageResponseDto {

    private Long messageId;

    private String sender;

    private String receiver;

    private String content;

    private Date createdAtTS;

    private Date readAtTS;

}
