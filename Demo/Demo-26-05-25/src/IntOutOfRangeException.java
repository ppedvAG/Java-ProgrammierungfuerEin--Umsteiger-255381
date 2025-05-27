public class IntOutOfRangeException extends RuntimeException {
    public IntOutOfRangeException(String message) {
        super(message + "\n Int out of Range");
    }
}
