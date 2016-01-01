package cs406.lab6;
import cs406.lab6.util.LinkedList;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;


/**
 * TODO
 */
public class LinkedListSerializer<T> implements Serializer<LinkedList<T>> {

    private static final int SERIAL_ID = 0x00000002;

    @Override
    public int serialize(SeekableByteChannel channel) throws IOException, SerializationException {
        return 0;
    }

    @Override
    public int deserialize(SeekableByteChannel channel) throws IOException, DeserializationException {
        return 0;
    }

    @Override
    public LinkedList<T> get() {
        return null;
    }

    @Override
    public void set(LinkedList<T> x) {

    }
}
