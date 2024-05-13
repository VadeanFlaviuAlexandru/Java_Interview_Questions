package CodingProblems.DesignPatterns.BehavioralPatterns;

import lombok.Data;
import lombok.ToString;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IteratorPattern {
    // extract the traversal behavior of a collection into a separate object called an iterator
    // several iterators can go through the same collection and traverses the elements
    // traverse the elements without exposing its underlying representation

    public interface Iterator<T> {

        boolean hasNext();

        Vertex<T> getNext();

        void reset();

    }

    public static class DepthFirstIterator<T> implements Iterator<T> {

        private final Vertex<T> startVertex;
        private final Deque<Vertex<T>> stack = new LinkedList<>();

        public DepthFirstIterator(Vertex<T> startVertex) {
            this.startVertex = startVertex;
            stack.push(startVertex);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Vertex<T> getNext() {
            if (!hasNext()) {
                return null;
            }
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                current.getNeighbors().forEach(stack::push);
                return current;
            }
            return getNext();
        }

        @Override
        public void reset() {
            stack.clear();
            stack.push(startVertex);
        }

    }

    @Data
    public static class Vertex<T> {

        private final T data;

        private boolean visited;

        @ToString.Exclude
        private List<Vertex<T>> neighbors = new LinkedList<>();

    }

    public static void main(String[] args) {

        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(List.of(v1, v5, v6));
        v1.setNeighbors(List.of(v3, v4, v5));
        v4.setNeighbors(List.of(v2, v6));
        v6.setNeighbors(List.of(v0));

        DepthFirstIterator<Integer> dfs = new DepthFirstIterator<>(v0);
        while (dfs.hasNext()) {
            System.out.println(dfs.getNext());
        }

    }
}
