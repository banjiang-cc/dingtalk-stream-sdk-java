package com.dingtalk.open.app.stream.network.api;

import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author feiyin
 * @date 2022/12/28
 */
public class EndPointConnection {
    private final String clientId;
    private final URI endPoint;
    private final String connectionId;

    private final Proxy proxy;

    public EndPointConnection(String clientId, String endPoint, String connectionId, Proxy proxy) {
        this.clientId = clientId;
        try {
            this.endPoint = new URI(endPoint);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        this.connectionId = connectionId;
        this.proxy = proxy;
    }

    public URI getEndPoint() {
        return this.endPoint;
    }

    public String getConnectionId() {
        return this.connectionId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public TransportProtocol getProtocol() {
        return TransportProtocol.parseScheme(endPoint.getScheme());
    }

    public Proxy getProxy() {
        return proxy;
    }
}
