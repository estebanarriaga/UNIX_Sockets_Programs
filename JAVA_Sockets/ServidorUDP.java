/* 
	Un servidor UDP recive peticiones y las devuelve al 
	cliente de forma repetitiva

	Este es el programa del lado del servidor, el cual crea
	un conector ligado al puerto 9000 y espera repetidamente
	a los mensajes de peticion de los clientes, a los cuales
	responde mandando de vuelta el mismo mensaje.
*/

import java.net.*;
import java.io.*;

public class ServidorUDP {
		public static void main(String args[]) {
				try {
						DatagramSocket unSocket = new DatagramSocket(9000);
						byte [] buffet = new byte[1000];
						while (true) {
								DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
								unSocket.receive(peticion);
								DatagramPacket respuesta = new DatagramPacket(peticion.getData(),
												peticion.getLength(), peticion.getAddress(), peticion.getPort());
								unSocket.send(respuesta);
						}
				} catch (SocketException e) {
						System.out.println("Socket: " + e.getMessage());
				} catch (IOException e) {
						System.out.println("IO: " + e.getMessage());
				}
		}
}
