package nxt.perfume.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;

public class SocketIOServerConfig {
    private SocketIOServer server;
    private final String hostname;
    private final String port;
    private final String context;

    public SocketIOServerConfig(String hostname, String port, String context) {
        this.hostname = hostname;
        this.port = port;
        this.context = context;
    }

    public void start() {
        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setTcpKeepAlive(true);
        socketConfig.setReuseAddress(true);

        Configuration config = new Configuration();
        config.setHostname(hostname);
        config.setPort(Integer.parseInt(port));
        config.setContext(context);
        config.setTransports(Transport.WEBSOCKET);

        config.setSocketConfig(socketConfig);
        config.setPingTimeout(30000);
        config.setPingInterval(10000);

        server = new SocketIOServer(config);
        configureEventListeners();

        server.start();

    }

    private void configureEventListeners() {
        SocketIORegistrar connectionRegistrar = new ConnectionEvent();
        connectionRegistrar.registerEvent(server);

        SocketIORegistrar notificationRegistrar = new NotificationEvent();
        notificationRegistrar.registerEvent(server);

        //SocketIORegistrar messageRegistrar = new MessageEventRegistrar();
        //messageRegistrar.registerEvent(server);
    }

}
