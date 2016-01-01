package com.cs406.lab6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/**
 * Created by ian on 15-03-21.
 */
public class StringSerializer implements Serializer<String> {

    private static final int SERIAL_ID = 0x00000001;
    private String s;


    @Override
    public int serialize(SeekableByteChannel channel) throws IOException {

        // the total # bytes for this serial representation
        int length = (2 * Integer.BYTES) + s.length();

        // allocated byte-buffer and write all data into it
        ByteBuffer buffer = ByteBuffer.allocate(length);
        buffer.putInt(SERIAL_ID);
        buffer.putInt(s.length());
        for(int i=0; i<s.length(); i++)
            buffer.put((byte)s.charAt(i));

        // "flip" the buffer to enable reading from buffer (a.k.a.: writing to channel)
        buffer.flip();
        channel.write(buffer);

        return length; // post-condition: return the total number of bytes written to the channel.
    }

    @Override
    public int deserialize(SeekableByteChannel channel) throws IOException, DeserializationException {

        // byte buffer for reading the "header"
        ByteBuffer buffer = ByteBuffer.allocate(2 * Integer.BYTES);
        int bytesRead = 2 * Integer.BYTES;

        // read the "header" data from the channel and flip the buffer for reading
        channel.read(buffer);
        buffer.flip();

        // Check #1: serial ID matches
        int serialIdRetrieved = buffer.getInt();
        if (serialIdRetrieved != SERIAL_ID)
            throw new DeserializationException("Serial ID check fails.");

        int length = buffer.getInt();
        if(length < 0)
            throw new DeserializationException("Impossible String length");
        else if(length == 0)
            s = null;
        else {
            // allocate byte buffer for the string
            buffer = ByteBuffer.allocate(length);
            channel.read(buffer);
            buffer.flip();

            // read all data into a char[]
            char[] characters = new char[length];
            int c = 0;
            while(buffer.hasRemaining())
                characters[c++] = (char)buffer.get();

            // initialize the String by calling char[] version of the constructor
            s = new String(characters);

            // keep track of the number of bytes read
            bytesRead += length;
        }

        return bytesRead; // postcondition return the number of bytes read from the channel
    }

    @Override
    public String get() {
        return s;
    }

    @Override
    public void set(String x) {
        this.s = x;
    }
}
