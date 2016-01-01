package cs406.lab6;

import cs406.lab6.util.HashMap;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

/**
 * TODO
 */
public class HashMapSerializer<K,V> implements Serializer<HashMap<K,V>> {

    private static final int SERIAL_ID = 0x00000003;

    @Override
    public int serialize(SeekableByteChannel channel) throws IOException, SerializationException {
        return 0;
    }

    @Override
    public int deserialize(SeekableByteChannel channel) throws IOException, DeserializationException {
        return 0;
    }

    @Override
    public HashMap<K, V> get() {
        return null;
    }

    @Override
    public void set(HashMap<K, V> x) {

    }
}
