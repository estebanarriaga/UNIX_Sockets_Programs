/*
	DEF: Un cliente UDP enviando un mensaje a un servidor y recogiendo
	su respuesta

	Este programa muestra una crea un conector de cliente que envía
	mensajes a un servidor en el puerto 9000 y después espera la respuesta.
	
	Los argumentos para el main proporcionan un mensaje y el nombre
	de host del servidor.

	El mensaje se combierte en una cadena de bytes, y el nombre de host
	a la correspondiente direccion Internet.
*/

import java.net.*;
import java.io.*;

public class ClienteUDP {
		public static void main(String args[]) {
				// Args proporciona el mensaje y el nombre del servidor
				try {
						DatagramSocket unSocket = new DatagramSocket();
						byte [] m = args[0].getBytes();
						InetAddress unHost = InetAddress.getByName(args[1]);
						int puerto = 9000;
						DatagramPacket peticion =
								new DatagramPacket(m, args[0].length(), unHost, puertoServidor);
						unSocket.send(peticion);
						byte [] buffer = new byte[1000];
						DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
						unSocket.receive(respuesta);
						System.out.println("Respuesta " + new String(respuesta.getData()));
						unSocket.close();
				} catch (socketException e){
						System.out.println("Socket " + e.getMessage());
				} catch (IOException e) {
						System.out.println("IO: " + e.getMessage());
				}
		}
}
