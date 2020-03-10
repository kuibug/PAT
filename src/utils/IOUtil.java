package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Helpful fast input and output on PAT systems.
 */
public class IOUtil {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter out;

    /**
     * initial InputStream & OutputStream
     * @param input  InputStream
     * @param output OutputStream
     */
    public static void init(InputStream input, OutputStream output) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
        out = new PrintWriter(new OutputStreamWriter(output));
    }

    /**
     *  read a words from InputStream
     */
    public static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();

    }

    /**
     * read a line from InputStream
     */
    public static String nextLine() throws IOException {
       return reader.readLine();
    }

    /**
     * read an Integer number.
     */
    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    /**
     * Read in a decimal.
     */
    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /**
     * print Object as a String and wrap it.
     */
    public static void println(Object object) {
        out.println(object);
    }

    /**
     * print Object as a String.
     */
    public static void print(Object object) {
        out.print(object);
    }

    /**
     * If it is not flush, it will not be output！
     */
    public static void flush() {
        out.flush();
    }
}