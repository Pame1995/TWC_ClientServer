package ec.edu.epn.rede.cs.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
public class clienteS {
	public static void main(String[] args) throws IOException{
		Socket clientSocket = new Socket("192.168.1.7",9000); // ip, puerto
		//192.168.1.10
		try
		{            
			//Flujo de datos hacia el servidor
			DataInputStream salidaServidor = new DataInputStream(clientSocket.getInputStream());// Para poder leer 
			PrintWriter alServidor  = new PrintWriter(clientSocket.getOutputStream(),true);//  Para poder mandar el string leido al servidor
			String linea;
			//Se enviarán un mensaje y finalizara el programa
			for (int i = 0; i < 1; i++)
			{
				//Se escribe en el servidor usando su flujo de datos

				linea =JOptionPane.showInputDialog(null,"ingrese en minuscula las palabras ") ;//obtiene los caracteres deseados
				//Control de error de ingreso de letras mayusculas
				if (linea.equals(linea.toLowerCase()))
					alServidor.println(linea);    //envia al servidor el caracter en minuscula         
				else 
				{
					JOptionPane.showMessageDialog(null, "Error de ingreso en minusculas");//mensaje de error de lectura
					System.exit(0);//salida de la coneccion
				}
			} 
			JOptionPane.showMessageDialog(null, salidaServidor.readUTF());//se imprime el resultado en caracter
			clientSocket.close();//Fin de la conexión

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}


		System.exit(0);

	}

}
