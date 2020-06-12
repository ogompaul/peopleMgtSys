package com.websocket.controller;


/*this class is provided in order to connect to remote SockJS endpoints WITHOUT USING A BROWSER This can be especially useful when there is a 
 * need for bidirectional communication between 2 SERVERS over a public network, i.e. where network proxies may preclude the use of the
 *  WebSocket protocol. A SockJS Java client is also very useful for testing purposes, for example to simulate a large number of concurrent 
 *  users. The SockJS Java client supports the "websocket", "xhr-streaming", and "xhr-polling" transports. The remaining ones only make sense 
 *  for use in a browser.*/

public class SockJsJavaClient {
	/*List<Transport> transports = new ArrayList<WebSocketTransport>(2);
	transports.add(new WebSocketTransport(new StandardWebSocketClient()));
	transports.add(new RestTemplateXhrTransport());

	SockJsClient sockJsClient = new SockJsClient(transports);
	sockJsClient.doHandshake(new MyWebSocketHandler(), "ws://example.com:8080/sockjs");*/
}
