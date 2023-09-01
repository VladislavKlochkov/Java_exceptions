package lesson3;

import java.io.IOException;

public class ObjectNotAvailable extends IOException {
    public ObjectNotAvailable(String msg) {
        super(msg);
    }
}
