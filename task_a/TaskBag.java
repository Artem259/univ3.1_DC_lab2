public class TaskBag<T> {
    private final T[] data;
    private int currentIndex;

    public TaskBag(T[] data) {
        this.data = data;
        currentIndex = 0;
    }

    public T getNext() {
        synchronized (this) {
            currentIndex++;
            return data[currentIndex];
        }
    }

    public boolean isRunOut() {
        return currentIndex >= (data.length-1);
    }
}
