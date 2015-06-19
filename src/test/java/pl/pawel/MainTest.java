package pl.pawel;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

public class MainTest {

    @AfterClass
    public static void cleanup() {
        Main.close();
    }

    @Test
    public void mainTest() throws IOException {
        Main.main();

        Socket socket = new Socket("localhost", 8080);

        assert socket != null;
    }
}
