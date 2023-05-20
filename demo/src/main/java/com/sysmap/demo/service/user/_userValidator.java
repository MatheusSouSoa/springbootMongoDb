package com.sysmap.demo.service.user;

// import org.apache.catalina.connector.Response;
// import org.springframework.http.ResponseEntity;

public class _userValidator {

    public static boolean validate(CreateUserRequest request){

        if(!validateName(request)){
            return false;
        }
        return true;
    }

    public static boolean validateName(CreateUserRequest request) {
        if(request.name == null || request.name.length() < 3){
            //é possivel retorna aqui ja informando q o erro foi no nome ?
            //ResponseEntity.badRequest().build();
            return false;
        }
        return true;
    }

}
