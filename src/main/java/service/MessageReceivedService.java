package service;

public class MessageReceivedService {
    public boolean isCommandMessage(String message, String ...args) {
        return message.charAt(0) == '!'
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
