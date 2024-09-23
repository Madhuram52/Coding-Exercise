// FormCaretaker.java
import java.util.ArrayList;
import java.util.List;

public class FormCaretaker {
    private final List<FormState> mementos = new ArrayList<>();

    public void addMemento(FormState memento) {
        try {
            if (memento == null) throw new IllegalArgumentException("Invalid Memento");
            mementos.add(memento);
            Logger.info("Form state saved");
        } catch (Exception e) {
            Logger.error("Error saving form state", e);
        }
    }

    public FormState getMemento(int index) {
        try {
            if (index < 0 || index >= mementos.size()) throw new IndexOutOfBoundsException("Invalid memento index");
            return mementos.get(index);
        } catch (Exception e) {
            Logger.error("Error retrieving form state", e);
            return null;
        }
    }

    public FormState getLastMemento() {
        if (mementos.isEmpty()) {
            return null;
        }
        return getMemento(mementos.size() - 1);
    }
}
