package com.practice.sb_demo.services;

import com.practice.sb_demo.Util;
import com.practice.sb_demo.entities.MessageEnity;
import com.practice.sb_demo.dtos.MessageDto;
import com.practice.sb_demo.repository.MessageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

    @Autowired
    public MessageRepository messageRepository;

    @Override
    public MessageDto addMessage(MessageDto messageDto) throws ParseException {
        MessageEnity entity = new MessageEnity();
        entity.setSender(messageDto.getFrom());
        entity.setReceiver(messageDto.getTo());
        entity.setContent(messageDto.getContent());
        entity.setCreatedAtTS(Util.strToDate(messageDto.getCreatedAt()));
        MessageEnity savedEntity =  messageRepository.save(entity);

        messageDto.setMessageId(savedEntity.getMessageId());
        return messageDto;
    }

    /**
     * @param messageId
     * @return
     */
    @Override
    public MessageDto getMessage(long messageId) throws ParseException {
        MessageEnity entity = messageRepository.getReferenceById(messageId);
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageId(entity.getMessageId());
        messageDto.setFrom(entity.getSender());
        messageDto.setTo(entity.getReceiver());
        messageDto.setContent(entity.getContent());
        messageDto.setCreatedAt(Util.dateToStr(entity.getCreatedAtTS()));

        return messageDto;
    }
}
