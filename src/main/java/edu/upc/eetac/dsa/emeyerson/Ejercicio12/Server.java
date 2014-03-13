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
package edu.upc.eetac.dsa.emeyerson.Ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public static void main(String[] args) {

		ServerSocket s; // Socket servidor
		Socket sc; // Socket cliente

		PrintStream p; // Canal de escritura
		BufferedReader b; // Canal de Lectura
		String mensaje;

		Date now = new Date();

		try {
			// Creo el socket server

			s = new ServerSocket(4444);
			System.out.println("Esperando conexi�n");

			// Invoco el metodo accept del socket servidor, me devuelve una
			// referencia al socket cliente
			sc = s.accept();

			// Obtengo una referencia a los canales de escritura y lectura del
			// socket cliente
			p = new PrintStream(sc.getOutputStream());

			while (true) {
				SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				mensaje = fecha.format(now);

				// Escribo en canal de escritura el mismo mensaje recibido
				p.println(mensaje);
				break;
			}
			p.close();

			sc.close();
			s.close();
		} catch (IOException e) {
			System.out.println("No puedo crear el socket");
		}
	}

}
