package com.oocl.kary.kk.client.action;

import java.awt.EventQueue;

import com.oocl.kary.kk.client.model.Packet;
import com.oocl.kary.kk.client.ui.MainFrame;

public class GroupChatAction implements Action {
	public void execute(Packet packet, final MainFrame frame) {
		packet.read = false;
		frame.getMsgPackets().add(packet);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame.updateChatContainer();
			}
		});
	}
}
