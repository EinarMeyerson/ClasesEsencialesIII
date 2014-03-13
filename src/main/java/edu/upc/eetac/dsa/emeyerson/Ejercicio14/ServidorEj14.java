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
package edu.upc.eetac.dsa.emeyerson.Ejercicio14;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorEj14 {

	public static void main(String[] args) {

		ServerSocket puerto; // Socket servidor
		Socket sc; // Socket cliente

		PrintStream escribir;
		BufferedReader leer;

		Date now = new Date();
		Date now2 = new Date();

		try {
			// Creo el socket server

			puerto = new ServerSocket(1024);
			System.out.println("Esperando conexi�n");

			// Invoco el metodo accept del socket servidor, me devuelve una
			// referencia al socket cliente
			sc = puerto.accept();

			System.out.println("Nuevo cliente conectado");
			while (true) {
				escribir = new PrintStream(sc.getOutputStream());
				leer = new BufferedReader(new InputStreamReader(
						sc.getInputStream()));

				int mensajeRecibido;
				String mensajeEnviar;
				mensajeRecibido = Integer.parseInt(leer.readLine());

				switch (mensajeRecibido) {

				case 0:
					SimpleDateFormat fecha = new SimpleDateFormat(
							"dd/MM/yyyy HH:mm:ss");
					mensajeEnviar = fecha.format(now);
					escribir.println(mensajeEnviar);
					break;

				case 1:
					SimpleDateFormat fecha1 = new SimpleDateFormat(
							"EE,dd de MM de yyyy, HH:mm:ss");
					mensajeEnviar = fecha1.format(now2);
					escribir.println(mensajeEnviar);

					break;

				default:
					mensajeEnviar = "Operaci�n no encontrada";
					escribir.println(mensajeEnviar);
					break;

				}
				break;
			}
			sc.close();
			puerto.close();
			leer.close();
			escribir.close();

		} catch (IOException e) {
			System.out.println("No puedo crear el socket");
		}
	}
}