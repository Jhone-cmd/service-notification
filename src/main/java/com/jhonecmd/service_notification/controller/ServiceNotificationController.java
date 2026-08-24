package com.jhonecmd.service_notification.controller;

import com.jhonecmd.service_notification.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class ServiceNotificationController {

    @Value("${message:Hello default}")
    private String message;


    @GetMapping("/message")
    public String message(){
        return message;
    }

    @PostMapping()
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        return ResponseEntity.ok().build();
    }
}
