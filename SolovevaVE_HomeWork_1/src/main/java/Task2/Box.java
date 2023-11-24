package Task2;

public interface Box<T> {
    public T open();
    public void put(T item);
    public T removeFromBox();
}
