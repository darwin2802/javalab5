package task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class DecryptReader extends FilterReader {
    private final int key;

    public DecryptReader(Reader in, char key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c == -1) return -1;
        return c - key;
    }

    @Override
    public int read(char[] buf, int off, int len) throws IOException {
        int count = super.read(buf, off, len);
        if (count == -1) return -1;
        for (int i = off; i < off + count; i++)
            buf[i] = (char)(buf[i] - key);
        return count;
    }
}
