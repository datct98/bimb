package com.example.demo.exception.common;

import com.example.demo.model.entities.ErrorMessage;
import org.springframework.http.HttpStatus;

public class ExceptionCreater {

    //Common
    public static final String SEND_MAIL_ERROR = "send_mail_error";
    public static final String EMAIL_ERROR = "email_not_found";
    public static final String ERROR_MAINTAIN ="error_maintain";
    public static final String ERROR_STATUS= "error_status";
    public static final String ERROR_GRADE_CLASS= "error_grade_class";

    public static final String INSERT_ERROR= "error_insert";


    //Auth
    public static final String AUTH_ERROR = "auth_error";
    public static final String TOKEN_ERROR="invalid_token";
    public static final String RESET_PASSWORD_ERROR="invalid_reset_password_email";
    public static final String ROLE_ERROR = "invalid_role";
    public static final String CODE_ERROR = "error_code";


    //User
    public static final String USER_ERROR = "user_error";
    public static final String FIND_STUDENT_ERROR= "student_not_found";
    public static final String ERROR_SECURE_CODE= "Invalid_SecureCode";
    public static final String ERROR_EXISTED_SECURE_CODE= "Existed_SecureCode";

    public static final String STUDENT_ERROR = "Invalid_Student";
    public static final String STUDENT_DELETE_ERROR = "delete_Student_error";

    //Multipart
    public static final String MULTIPART_ERROR = "multipart_error";


    // User Address
    public static final String USER_ADDRESS_ERROR = "user_address_error";

    // Transaction
    public static final String TRANSACTION_ERROR = "transaction_error";

    public static ServerException createServerException(IBaseException exception) {
        HttpStatus status = getHTTPStatusFromErrorCode(exception.getCode());
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getCode());
        return new ServerException(status, errorMessage);
    }

    private static HttpStatus getHTTPStatusFromErrorCode(String errorCode) {
        HttpStatus status;
        switch (errorCode) {
            default:
                status = HttpStatus.BAD_REQUEST;
                break;
        }
        return status;
    }
}
