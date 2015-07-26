package com.oocl.kary.kk.client.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.Gson;
import com.oocl.kary.kk.client.model.KPacket;

public class Request implements Runnable {

	private Socket socket;
	private KPacket packet;

	public Request(Socket socket, KPacket packet) {
		this.socket = socket;
		this.packet = packet;
		if (packet.stamp == null) {
			SimpleDateFormat packetDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd-hh-mm-ss");
			packet.stamp = packetDateFormat.format(Calendar.getInstance()
					.getTime());
		}
	}

	@Override
	public void run() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(socket.getOutputStream());
			Gson gson = new Gson();
			String json = gson.toJson(packet, packet.getClass());

			System.out.println("SENT:\t" + json);

			out.println(json);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}