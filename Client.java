import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			System.out.println("Etablir une connexion vers le serveur");
			Socket socket=new Socket("localhost", 1234);
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			
			Scanner scanner=new Scanner(System.in);
			System.out.print("Donner un nombre:");
			int nb=scanner.nextInt();
			System.out.println("J'envoie la requête au serveur");
			os.write(nb);
			System.out.println("J'attend la réponse du serveur");
			int rep=is.read();
			System.out.println("Réponse ="+rep);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
