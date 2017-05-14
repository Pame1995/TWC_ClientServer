package ec.edu.epn.rede.cs.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class servidorS {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(9000);//puerto
		System.out.println("Server listening on port "+9000);//IP,puerto
		Socket socket = serverSocket.accept();
		//Flujo de datos hacia al cliente
		DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());// flujo para poder mandar un string
		BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // flujo para poder leer del socket un string, con el método readline()
		String mensajeServidor;
		String  a;
		int i;
		for(i=0; i<1; i++){
			mensajeServidor=entrada.readLine();//recive datos del cliente
			System.out.println("Llego: " + mensajeServidor);//imprime en consola lo leido por el servidor
			a= mensajeServidor.toUpperCase();//cambia lo recibido por letras mayusculas
			salidaCliente.writeUTF(a);////reenvia el mensaje en letras mayusculas
		}
		//salidaCliente.writeUTF(a);//envia a al cliente
		System.out.println("Fin de la conexión");
		//Se finaliza la conexión con el cliente

		socket.close();
		serverSocket.close();


	}
}
