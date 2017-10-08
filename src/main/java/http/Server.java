package http;

import api.Dispatcher;

public class Server {
    private Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
        case GET:
            dispatcher.doGet(request, response);
            break;
        default:
        }
        return response;
    }

}
