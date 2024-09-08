package com.practice.sb_demo.services;

import com.practice.sb_demo.Util;
import com.practice.sb_demo.dtos.response.MessageResponseDto;
import com.practice.sb_demo.model.MessageEnity;
import com.practice.sb_demo.dtos.request.MessageDto;
import com.practice.sb_demo.repository.MessageRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

    @Autowired
    public MessageRepository messageRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public MessageResponseDto addMessage(MessageDto messageDto) throws ParseException {
        MessageEnity entity = new MessageEnity();
        entity.setSender(messageDto.getFrom());
        entity.setReceiver(messageDto.getTo());
        entity.setContent(messageDto.getContent());
        entity.setCreatedAtTS(Util.strToDate(messageDto.getCreatedAt()));
        MessageEnity savedMessageEntity =  messageRepository.save(entity);

        return modelMapper.map(savedMessageEntity, MessageResponseDto.class);
    }

    /**
     * @param messageId
     * @return
     */
    @Override
    public MessageResponseDto getMessage(long messageId) throws ParseException {
        MessageEnity entity = messageRepository.getReferenceById(messageId);
        return modelMapper.map(entity, MessageResponseDto.class);
    }
}
