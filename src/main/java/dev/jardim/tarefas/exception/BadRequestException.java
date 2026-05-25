package dev.jardim.tarefas.exception;

public class BadRequestException extends Exception{

    public BadRequestException(String message) {
        super(message);
    }

}