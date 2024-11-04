package nxt.perfume.socket;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketIOClientConfig {
    private Socket socket;

    public SocketIOClientConfig(String host, String path) {
        try {
            IO.Options options = new IO.Options();

            options.path = path;
            options.forceNew = true;
            options.reconnection = true;
            options.transports = new String[]{"websocket"};

            socket = IO.socket(host, options);

            socket.on(Socket.EVENT_CONNECT, (Object... args) -> {
                System.out.printf("Connected to %s%s%n", host, path);
            });

            socket.connect();
        } catch (URISyntaxException e) {
            Logger.getLogger(SocketIOClientConfig.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
