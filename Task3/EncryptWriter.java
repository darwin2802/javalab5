package task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class EncryptWriter extends FilterWriter {
    private final int key;

    public EncryptWriter(Writer out, char key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + key);
    }

    @Override
    public void write(char[] buf, int off, int len) throws IOException {
        for (int i = off; i < off + len; i++)
            buf[i] = (char)(buf[i] + key);
        super.write(buf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        char[] chars = str.substring(off, off + len).toCharArray();
        for (int i = 0; i < chars.length; i++)
            chars[i] = (char)(chars[i] + key);
        super.write(chars, 0, chars.length);
    }
}
