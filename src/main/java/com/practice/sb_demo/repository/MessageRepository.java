package com.practice.sb_demo.repository;

import com.practice.sb_demo.model.MessageEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEnity, Long> {
}
