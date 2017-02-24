package chapter03.section06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Multiple Bounds.
 */
public class MultipleBounds {

    /**
     * For maximum flexibility, we might want to write a copy method that takes any source that implements both Readable and Closeable
     * and any target that implements both Appendable and Closeable:
     */
    public static <S extends Readable & Closeable, T extends Appendable & Closeable> void copy(S src, T trg, int size) throws IOException {
        try {
            CharBuffer buf = CharBuffer.allocate(size);
            int i = src.read(buf);
            while (i >= 0) {
                buf.flip(); // prepare buffer for writing
                trg.append(buf);
                buf.clear(); // prepare buffer for reading
                i = src.read(buf);
            }
        } finally {
            src.close();
            trg.close();
        }
    }

    public static void main(String[] args) throws IOException {
        int bufSize = 32;

        FileReader r = new FileReader("file.in");
        FileWriter w = new FileWriter("file.out");
        copy(r, w, bufSize);

        BufferedReader br = new BufferedReader(new FileReader("file.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("file.out"));
        copy(br, bw, bufSize);
    }
}
