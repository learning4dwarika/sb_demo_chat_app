package com.practice.sb_demo.controllers;

import com.practice.sb_demo.dtos.request.MessageDto;
import com.practice.sb_demo.dtos.response.MessageResponseDto;
import com.practice.sb_demo.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    MessageService messageService;


    @RouterOperation(operation = @Operation(description = "post a new message.", operationId = "post_message", tags = "message",
        responses = @ApiResponse(responseCode = "200",content = @Content(schema = @Schema(implementation = MessageResponseDto.class)))))
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MessageResponseDto> postMessage(@RequestBody MessageDto messageDto) throws ParseException {
            return new ResponseEntity<>(messageService.addMessage(messageDto), HttpStatus.OK) ;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<MessageResponseDto> getMessage(@RequestBody long messageId) throws ParseException {
        return new ResponseEntity<MessageResponseDto>(messageService.getMessage(messageId), HttpStatus.OK) ;
    }
}
