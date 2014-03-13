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

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerUDP {

	public static void main(String args[]) throws Exception {
		DatagramSocket server = new DatagramSocket(9090);
		byte[] enviar = new byte[1024];
		byte[] recibir = new byte[1024];
		String mensaje;
		Date now = new Date();

		while (true) {
			System.out.println("Escuchando");
			DatagramPacket p = new DatagramPacket(recibir, recibir.length);
			server.receive(p);
			InetAddress IPAddress = p.getAddress();
			int port = p.getPort();
			SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			mensaje = fecha.format(now);

			enviar = mensaje.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(enviar,
					enviar.length, IPAddress, port);
			server.send(sendPacket);
			break;
		}
		server.close();
	}
}
