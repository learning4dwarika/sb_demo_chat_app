package com.practice.sb_demo.services;

import com.practice.sb_demo.dtos.MessageDto;

import java.text.ParseException;

public interface MessageService {

    public MessageDto addMessage(MessageDto message) throws ParseException;

    public MessageDto getMessage(long messageId) throws ParseException;
}
