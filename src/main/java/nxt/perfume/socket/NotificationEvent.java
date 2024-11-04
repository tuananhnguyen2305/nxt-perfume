package nxt.perfume.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class NotificationEvent implements SocketIORegistrar {
    @Override
    public void registerEvent(SocketIOServer server) {
        server.addEventListener("notification", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient client, String s, AckRequest ackRequest) throws Exception {
                client.sendEvent("notification", s);

            }
        });
    }
}
