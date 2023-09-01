package lesson3;

public class Counter implements AutoCloseable {

    private int count;
    private boolean status;

    public Counter() {
        this.count = 0;
        this.status = true;
    }

    public int getCount() {
        return count;
    }

    public boolean isStatus() {
        return status;
    }

    public void add() throws ObjectNotAvailable {
        if (!this.status) {
            throw new ObjectNotAvailable("Объект недоступен");
        }
        this.count++;
    }

    @Override
    public void close() throws Exception {
        this.count = 0;
        this.status = false;
    }
}