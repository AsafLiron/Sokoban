package controller.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Observer;

public interface ClientHandler {

	void start();

	void sendToClient(String message);

	void handleClient(InputStream inFromClient, OutputStream outToClient);

	void addObserver(Observer o);



}
