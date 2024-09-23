// Validator.java
public class Validator {
    public static void validateState(String state) throws FormException {
        if (state == null || state.isEmpty()) {
            throw new FormException("Invalid form state");
        }
    }

    public static void validateMemento(FormState memento) throws FormException {
        if (memento == null || memento.getState() == null) {
            throw new FormException("Invalid memento");
        }
    }
}
