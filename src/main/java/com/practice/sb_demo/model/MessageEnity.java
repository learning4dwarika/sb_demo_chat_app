package com.practice.sb_demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Messages")
public class MessageEnity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long messageId;

    @Column
    private String sender;

    @Column
    private String receiver;

    @Column
    private String content;

    @Column(name = "created_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAtTS;

    @Column(name = "read_ts", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date readAtTS;

}
