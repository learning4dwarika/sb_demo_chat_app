package com.practice.sb_demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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

    public MessageEnity() {
        super();
    }

    public MessageEnity(String from, String to, String content, Date createdAtTS) {
        this.sender = from;
        this.receiver = to;
        this.content = content;
        this.createdAtTS = createdAtTS;
    }
}
