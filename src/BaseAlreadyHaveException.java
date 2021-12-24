public class BaseAlreadyHaveException extends Exception {
    public BaseAlreadyHaveException() {
        super("На базе уже есть такая техника");
    }
}