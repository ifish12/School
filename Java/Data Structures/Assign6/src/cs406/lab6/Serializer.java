package cs406.lab6;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

/**
 * Created by ian on 15-03-20.
 */
public interface Serializer<T> {
    public int serialize(SeekableByteChannel channel) throws IOException, SerializationException;
    public int deserialize(SeekableByteChannel channel) throws IOException, DeserializationException;
    public T get();
    public void set(T x);
}
