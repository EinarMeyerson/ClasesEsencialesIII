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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteJuego {
	// Funci�n principal de la clase.
	public static void main(String args[]) {

		// leer del teclado
		Scanner sr = new Scanner(System.in);
		String op;

		// Creamos una instancia a null, de la clase socket.
		Socket s = null;

		DataInputStream leer = null;
		DataOutputStream escribir = null;

		// Establecesmos el puerto a utilizar en la variable serverPort.
		int serverPort = 1024;

		// Creamos una instancia para un flujo de entrada de datos.

		// data almacena los datos a enviar.
		String mensajeEnviado;
		String mensajeRecibido;

		try {

			// Creamos un nuevo Socket, con el nombre de host pasado por
			// argumento
			// y con el puerto establecido anteriormente.
			s = new Socket("localhost", serverPort);

			escribir = new DataOutputStream(s.getOutputStream());
			leer = new DataInputStream(s.getInputStream());

			// Control de excepciones.
		} catch (UnknownHostException ex) {
			Logger.getLogger(ex.getMessage());
			System.out.println("\nHost no encontrado");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		try {
			mensajeRecibido = leer.readUTF();
			System.out.println(mensajeRecibido);

			System.out
					.println("Introduce el nombre del jugador para empezar una partida");
			op = sr.next();
			mensajeEnviado = "PLAY " + op;

			escribir.writeUTF(mensajeEnviado);

			mensajeRecibido = leer.readUTF();
			String[] linea = mensajeRecibido.split(" ");

			while (mensajeRecibido != null) {
				switch (linea[0]) {

				case "WAIT":
					System.out.println(mensajeRecibido);
					break;

				case "VERSUS":
					System.out.println(mensajeRecibido);
					break;

				case "YOUR":
					System.out.println(mensajeRecibido);

					System.out
							.println("Introduce el n�mero de moendas que quieres jugar seguido de las que tienes separadas por /");
					op = sr.next();
					mensajeEnviado = "MY BET " + op;
					escribir.writeUTF(mensajeEnviado);
					break;
				case "BET":
					System.out.println(mensajeRecibido);
					break;

				case "NONE":
					System.out.println(mensajeRecibido);
					mensajeRecibido = null;
					break;

				case "WINNER":
					System.out.println(mensajeRecibido);
					mensajeRecibido = null;
					break;

				}
				mensajeRecibido = leer.readUTF();
				linea = mensajeRecibido.split(" ");

			}

			s.close();
			escribir.close();
			leer.close();
			sr.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
}
