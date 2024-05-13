package CodingProblems.DesignPatterns.BehavioralPatterns;

import java.util.Deque;
import java.util.LinkedList;

public class MementoPattern {
    public class Editor {

        private final TextArea textArea;
        private final Deque<TextArea.Memento> stateHistory;

        public Editor() {
            textArea = new TextArea();
            stateHistory = new LinkedList<>();
        }

        public void write(String text) {
            textArea.set(text);
            stateHistory.offer(textArea.takeSnapshot());
        }

        public void undo() {
            if (stateHistory.isEmpty()) {
                return;
            }
            stateHistory.pollLast();
            textArea.restore(stateHistory.peekLast());
        }

        public void printText() {
            System.out.println(textArea.getText());
        }

    }

    public class TextArea {

        private String text;

        public void set(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public Memento takeSnapshot() {
            return new Memento(this.text);
        }

        public void restore(Memento memento) {
            this.text = memento != null ? memento.getSavedText() : null;
        }

        public static class Memento {
            private final String text;

            private Memento(String textToSave) {
                text = textToSave;
            }

            private String getSavedText() {
                return text;
            }
        }

    }

    public void main(String[] args) {

        Editor editor = new Editor();
        editor.write("Like and");
        editor.printText();
        editor.write("Like and Subscribe");
        editor.printText();
        editor.write("Like and Subscribe to Geekific!");
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();
        editor.undo();
        editor.printText();

    }
}
