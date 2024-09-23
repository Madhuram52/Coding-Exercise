// FormOriginator.java
public class FormOriginator {
    private String state;
    private int step;

    public void setFormState(String state, int step) {
        try {
            Validator.validateState(state);
            this.state = state;
            this.step = step;
            Logger.info("Form state updated to step " + step);
        } catch (FormException e) {
            Logger.error("Error setting form state", e);
        }
    }

    public FormState saveState() {
        return new FormState(state, step);
    }

    public void restoreState(FormState memento) {
        try {
            Validator.validateMemento(memento);
            this.state = memento.getState();
            this.step = memento.getStep();
            Logger.info("Form state restored to step " + this.step);
        } catch (FormException e) {
            Logger.error("Error restoring form state", e);
        }
    }

    public String getCurrentState() {
        return state != null ? state : "No data available";
    }
}
