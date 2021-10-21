package com.example.demo.constant;

public class Message {

    // Common message
    public static final String PARSE_DATA_ERROR = "Parse data error";
    public static final String ERROR_CODE = "Invalid code or code expired!";
    public static final String ERROR_MAINTAIN = "The system is maintenance";
    public static final String ERROR_STATUS = "Invalid status";
    public static final String ERROR_GRADE_CLASS = "Grade class is not exist";

    public static final String DELETE_STUDENT_ERROR = "Delete student unsuccessfully!";

    // Auth message error
    public static final String ERROR_INVALID_TOKEN = "Missing or invalid token";
    public static final String ERROR_LOGIN_REQUIRED_PRAM = "Email and password is required";
    public static final String ERROR_LOGIN_USER_NOT_FOUND = "User not found";
    public static final String ERROR_INVALID_REFRESH_TOKEN = "Token or refresh token invalid";
    public static final String ERROR_REFRESH_TOKEN = "Token or refresh token invalid!";
    public static final String ERROR_LOGIN_PASSWORD_INCORRECT  = "Password is incorrect.";
    public static final String ERROR_NOT_ADMIN_ROLE  = "You must be the admin";

    // User message error
    public static final String ERROR_UPDATE_CODE = "Update secure code FAILURE";
    public static final String ERROR_REGISTER_EMAIL_ALREADY_EXISTS = "Email already exists.";
    public static final String ERROR_INVALID_ACCOUNT= "Username or password or email is null !";
    public static final String ERROR_STUDENT_NOT_FOUND = "Student not found";
    public static final String ERROR_ADD_STUDENT = "Student's name is null";
    public static final String ERROR_EMAIL_NOT_FOUND = "Email not found";
    public static final String ERROR_USER_CURRENT_PASSWORD_INCORRECT  = "The current password is incorrect.";
    public static final String ERROR_USER_MULTIPART_FILE ="MultipartFile Error.";

    // Multipart error
    public static final String ERROR_MULTIPART_FILE = "MultipartFile Error.";
    public static final String ERROR_MULTIPART_FILE_NULL = "MultipartFile NULL.";

    // Product error
    public static final String ERROR_PRODUCT_NOT_FOUND = "Product not found.";
    public static final String ERROR_PRODUCT_UPLOAD_FAILED = "Upload product failed.";

    // Send mail error
    public static final String ERROR_SENDING_MAIL = "Sending Email ERROR";
    public static final String ERROR_SEND_REQUEST = "You only send request after 30s!!!";

    // Transaction
    public static final String ERROR_TRANSACTION_INFO_NOT_FOUND = "Transaction information not found.";

}
