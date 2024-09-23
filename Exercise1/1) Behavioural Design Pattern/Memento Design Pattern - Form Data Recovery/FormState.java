// FormState.java
public class FormState {
    private final String state;
    private final int step;

    public FormState(String state, int step) {
        this.state = state;
        this.step = step;
    }

    public String getState() {
        return state;
    }

    public int getStep() {
        return step;
    }
}
