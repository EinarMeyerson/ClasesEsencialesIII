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
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

		Socket s;
		BufferedReader b;

		String host = "localhost";
		int port = 4444;
		String respuesta;

		try {

			// Creo una conexion al socket servidor
			s = new Socket(host, port);

			// Creo las referencias al canal de escritura y lectura del socket
			b = new BufferedReader(new InputStreamReader(s.getInputStream()));

			// Espero la respuesta por el canal de lectura
			respuesta = b.readLine();
			System.out.println(respuesta);

			b.close();
			s.close();

		} catch (UnknownHostException e) {
			System.out.println("No puedo conectarme a " + host + ":" + port);
		} catch (IOException e) {
			System.out.println("Error de E/S en " + host + ":" + port);
		}
	}
}
