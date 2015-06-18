package pl.pawel;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

public class TestTest {

    @Test
    public void test1() throws IOException {
        Main.main();

            Socket s = new Socket("localhost", 8080);
            s.close();
    }

    @AfterClass
    public static void cleanup() {
        Main.stop();
    }
}
