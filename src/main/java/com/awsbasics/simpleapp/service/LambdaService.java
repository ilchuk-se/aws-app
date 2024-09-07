package com.awsbasics.simpleapp.service;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.awsbasics.simpleapp.configuration.LambdaClientProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class LambdaService {

    private final LambdaClientProperties lambdaClientProperties;
    private final AWSLambda lambdaClient;

    public ResponseEntity<?> triggerDataConsistencyFunction(){
        InvokeRequest request = new InvokeRequest();
        request.withFunctionName(lambdaClientProperties.getFunctionName());

        InvokeResult invoke = lambdaClient.invoke(request);
        return new ResponseEntity<>(StandardCharsets.UTF_8.decode(invoke.getPayload()).toString(),
                HttpStatus.valueOf(invoke.getStatusCode()));
    }
}
