package nxt.perfume.socket;

import com.corundumstudio.socketio.SocketIOServer;

public interface SocketIORegistrar {
    void registerEvent(SocketIOServer server);
}
