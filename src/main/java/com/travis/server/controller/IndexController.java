package com.travis.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
public class IndexController {
    @Value("${spring.datasource.jdbc-url}")
    private String dataSource;

    @GetMapping(produces = "application/json" , value="/")
    public StringBuffer getServerInfo(HttpServletRequest request) throws UnknownHostException {

        StringBuffer returnMessage = new StringBuffer();

        returnMessage.append("serverName : ");
        returnMessage.append(request.getServerName());
        returnMessage.append("\n");
        returnMessage.append("serverAddress : ");
        returnMessage.append(InetAddress.getByName(request.getServerName()).getHostAddress());
        returnMessage.append("\n");
        returnMessage.append("DBurl : ");
        returnMessage.append(dataSource);
        returnMessage.append("\n");
        returnMessage.append("CurrentTime : ");
        returnMessage.append(new Date());
        returnMessage.append("\n");
        returnMessage.append("Content : ");
        returnMessage.append(dataSource);

        return returnMessage;
    }

}
