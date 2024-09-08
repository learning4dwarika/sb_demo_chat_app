package com.practice.sb_demo.services;

import com.practice.sb_demo.dtos.request.MessageDto;
import com.practice.sb_demo.dtos.response.MessageResponseDto;

import java.text.ParseException;

public interface MessageService {

    public MessageResponseDto addMessage(MessageDto message) throws ParseException;

    public MessageResponseDto getMessage(long messageId) throws ParseException;
}
