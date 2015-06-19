package pl.pawel;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;

public class MainTestIntegration {

    public static final int PORT_8080 = 8080;
    public static final int PORT_14192 = 14192;

    @AfterClass
    public static void cleanup() {
        Main.close();
    }

    @Test
    public void mainTest() throws IOException {
        Main.main();

        OkHttpClient client = new OkHttpClient();

        Request request8080 = new Request.Builder()
                .url("http://127.0.0.1:" + PORT_8080)
                .build();

        Request request14192 = new Request.Builder()
                .url("http://127.0.0.1:" + PORT_14192)
                .build();


        assert client.newCall(request8080).execute() != null;
        assert client.newCall(request14192).execute() != null;

    }
}
