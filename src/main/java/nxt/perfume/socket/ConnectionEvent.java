package nxt.perfume.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

public class ConnectionEvent implements SocketIORegistrar {
    @Override
    public void registerEvent(SocketIOServer server) {
        server.addConnectListener(socketIOClient -> System.out.println("Client connected: " + socketIOClient.getSessionId().toString()));
    }
}
