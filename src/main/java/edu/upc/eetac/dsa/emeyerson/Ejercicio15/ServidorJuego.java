/*
 * Copyright [13/03/2014] [Einar Meyerson Uriarte]
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.upc.eetac.dsa.emeyerson.Ejercicio15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJuego {
	static int cont = 0;

	public static void main(String args[]) {

		// Establecemos el n�mero de puerto a utilizar.
		int serverPort = 1024;

		// Creamos una instancia para esperar las peticiones de los
		// clientes.
		ServerSocket listenSocket;

		// Socket para conexi�n.
		Socket clientSocket;

		// Usamos la clase conection.
		Conexion c;

		try {

			// Creamos el objeto para esperar peticiones de los clientes.
			listenSocket = new ServerSocket(serverPort);

			while (true) {

				// Dejamos invocado el servidor esperando haste que un
				// cliente
				// se conecte. clientSocket = Socket nuevo para
				// comunicaciones
				System.out.println("Esperando nueva conexi�n");
				clientSocket = listenSocket.accept();
				// Se establece la conexi�n, y se vuelve a esperar un nuevo
				// cliente.
				c = new Conexion(clientSocket);
				cont++;

			}

			// Control de excepciones.
		} catch (IOException e) {
			System.out.println("Error en socket: " + e.getMessage());
		}
	}
}