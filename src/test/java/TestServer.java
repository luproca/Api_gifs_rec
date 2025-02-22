import java.io.IOException;
import java.net.ServerSocket;

public class TestServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server running on port 8080...");
            while (true) {
                serverSocket.accept();
                System.out.println("Connection accepted!");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}