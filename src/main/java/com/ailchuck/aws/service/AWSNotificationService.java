package com.ailchuck.aws.service;

import com.amazonaws.services.sqs.model.Message;
import com.ailchuck.aws.dto.ImageInfoDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface AWSNotificationService {

    ResponseEntity<?> subscribe(String email);

    ResponseEntity<?> unsubscribe(String email);

    void sendMessageToSQS(ImageInfoDTO imageInfoDTO);

    List<Message> readMessages();

    void sendMessageToTopic(List<Message> messages);

}
