package task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWorker {

    public void saveEncrypted(String text, char key, String path) throws IOException {
        try (Writer w = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
             EncryptWriter ew = new EncryptWriter(w, key);
             BufferedWriter bw = new BufferedWriter(ew)) {

            bw.write(text);
        }
    }

    public String loadDecrypted(char key, String path) throws IOException {
        try (Reader r = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
             DecryptReader dr = new DecryptReader(r, key);
             BufferedReader br = new BufferedReader(dr)) {

            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = br.read()) != -1) sb.append((char)c);
            return sb.toString();
        }
    }

    public void saveObject(Serializable obj, String path) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(obj);
        }
    }

    public Object loadObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return in.readObject();
        }
    }
}
