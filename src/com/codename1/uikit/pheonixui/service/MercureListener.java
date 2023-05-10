


public class MercureListener {
/*    private final AsyncHttpClient asyncHttpClient;
    private WebSocket webSocket;

    public MercureListener() {
        AsyncHttpClientConfig config = new DefaultAsyncHttpClientConfig.Builder().build();
        asyncHttpClient = new DefaultAsyncHttpClient(config);
    }

    public void startListening(String url, String topic, WebSocketListener listener) throws InterruptedException, ExecutionException {
        BoundRequestBuilder requestBuilder = asyncHttpClient.prepareGet(url);
        requestBuilder.addHeader("Topic", topic);
Future<WebSocket> futureWebSocket = requestBuilder.<WebSocket>execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(listener).build());

        // Wait for the WebSocket to be opened
        webSocket = futureWebSocket.get();
    }

    public void stopListening() {
        if (webSocket != null) {
            //webSocket.sendCloseFrame();
        }
        try {
            asyncHttpClient.close();
        } catch (IOException ex) {
            Logger.getLogger(MercureListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
