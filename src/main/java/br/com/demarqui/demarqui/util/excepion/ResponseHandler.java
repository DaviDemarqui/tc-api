package br.com.demarqui.demarqui.util.excepion;

import br.com.genesys.os_api.Util.Exception.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {

        ErrorObject errorObject1 = new ErrorObject(message, "", responseObj);
        List<ErrorObject> objectList = new ArrayList<>();
        objectList.add(errorObject1);

        return new ResponseEntity<Object>(objectList, status);
    }

}