package com.whj.common;

/**
 * @Author WHJ
 * @Date 2024/4/23 16:15
 * @Description: TODO
 * @Version 1.0
 */
public class ErrorCodeException extends RuntimeException{

    private static final long serialVersionUID = 317400383270914028L;

    private ErrorCode errorCode;

    private int causeCode;

    public int getCauseCode() {
        return this.causeCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ErrorCodeException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(int causeCode, String message) {
        super(message);
        this.causeCode = causeCode;
    }

    public ErrorCodeException(String message) {
        super(message);
        this.causeCode = 50000;
        this.errorCode = ErrorCode.SYSTEM_ERROR;
    }

    public String toString() {
        if (this.errorCode == null) {
            return super.getMessage();
        } else {
            return this.errorCode.getCode() + " : " + this.errorCode.getMessage();
        }
    }

}
