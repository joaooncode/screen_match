package domain.exceptions;

import resources.TerminalColor;

public class InvalidRatingException extends Exception {
    public InvalidRatingException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return TerminalColor.RED_BOLD + super.getMessage() + TerminalColor.RESET;
    }
}
