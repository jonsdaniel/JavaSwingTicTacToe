import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerTwo {

	/*
	 * Connect to server as soon as the
	 */
	private static final double LOSS_RATE = 0.25;
	private static final int AVERAGE_DELAY = 150; // milliseconds

	public static void main(String[] args) throws Exception {
		// Initialize common variables
		int portNumber = 12282;
		String clientMessage = "";
		String serverOneMessage = "";

		try (ServerSocket serverTwoSocket = new ServerSocket(portNumber);
				Socket serverOneConnectionSocket = serverTwoSocket.accept();
				DataOutputStream outToServerOne = new DataOutputStream(serverOneConnectionSocket.getOutputStream());
				BufferedReader inFromServerOne = new BufferedReader(
						new InputStreamReader(serverOneConnectionSocket.getInputStream()));) {
			while (true) {
				System.out.println("Waiting for client two connection");
				try (Socket clientTwoConnectionSocket = serverTwoSocket.accept();
						DataOutputStream outToClientTwo = new DataOutputStream(
								clientTwoConnectionSocket.getOutputStream());
						BufferedReader inFromClientTwo = new BufferedReader(
								new InputStreamReader(clientTwoConnectionSocket.getInputStream()));) {
					while(inFromServerOne.ready()) {
						inFromServerOne.readLine();
					}
					while (true) {
						System.out.println("Waiting for server one response");
						
						serverOneMessage = inFromServerOne.readLine();
						System.out.println("Received response from server one - " + serverOneMessage);
						outToClientTwo.writeChars(serverOneMessage + "\n");
						System.out.println("Wrote to client one");
						System.out.println("Waiting for client two response");
						clientMessage = inFromClientTwo.readLine();
						System.out.println("Received client two response - " + clientMessage);
						outToServerOne.writeChars(clientMessage + "\n");	
					}

				}
				catch (Exception e) {
					outToServerOne.writeChars("bigwillystyle"+"\n");
					continue;
				}
			}
		} catch (Exception e) {
		}
	}
}
