public class Pair<T, Y> {

    private T first;
    private Y second;

    public Pair(T first, Y second) {
        this.first = first;
        this.second = second;
    }

    public void changeSecond(Y second) {
        this.second = second;
    }

    public void changeFirst(T first) {this.first = first;}

    public T getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }
}
