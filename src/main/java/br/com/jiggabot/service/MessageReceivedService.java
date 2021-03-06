package br.com.jiggabot.service;

public class MessageReceivedService {

    private static final char COMMAND_PREFIX = '!';

    public boolean isCommandMessage(String message, String ...args) {
        //TODO make null safe
        return message.charAt(0) == COMMAND_PREFIX
                && isValidCommandType(message, args);
    }

    private boolean isValidCommandType(String message, String[] args) {
        message = message +" ";
        for (String type : args){
            type = type +" ";
            if (message.toUpperCase().contains(type))
                return true;
        }
        return false;
    }
}
