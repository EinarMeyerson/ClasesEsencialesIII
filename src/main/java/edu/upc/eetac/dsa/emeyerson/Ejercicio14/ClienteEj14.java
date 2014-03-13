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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteEj14 {

	public static void main(String[] args) {

		// leer del teclado
		Scanner sr = new Scanner(System.in);
		int op;

		try {

			Socket s;
			PrintStream escribir;
			BufferedReader leer;
			s = new Socket("127.0.0.1", 1024);
			String mensajeRecibido;

			escribir = new PrintStream(s.getOutputStream());
			leer = new BufferedReader(new InputStreamReader(s.getInputStream()));

			System.out.println("Introduce la operaci�n que quiere realizar");
			System.out.println("0:formato dia/mes/a�o hora:minutos:segundos");
			System.out
					.println("1:formato d�a de la semana,d�a del mes de mes de a�o, hora:minutos:segundos");
			op = sr.nextInt();
			escribir.println(op);

			// Espero la respuesta por el canal de lectura
			mensajeRecibido = leer.readLine();
			System.out.println(mensajeRecibido);

			escribir.close();
			leer.close();
			s.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
