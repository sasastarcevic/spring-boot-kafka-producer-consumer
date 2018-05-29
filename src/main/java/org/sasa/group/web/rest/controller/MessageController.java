package org.sasa.group.web.rest.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sasa.group.web.rest.impl.MessageServiceImpl;
import org.sasa.group.web.rest.resource.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/message")
public class MessageController {

    private static final int SWAGGER_HTTP_STATUS_CREATED = 201;

    @Autowired
    private MessageServiceImpl messageServiceImpl;

    @ApiOperation(value = "addMessage", nickname = "addMessage")
    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {@ApiResponse(code = SWAGGER_HTTP_STATUS_CREATED, message = "Created")})
    public void addMessage(final @Valid @RequestBody MessageDto messageDto) {
        messageServiceImpl.addMessage(messageDto);
    }

}
