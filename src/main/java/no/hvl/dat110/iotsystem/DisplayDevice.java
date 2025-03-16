package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// Opprettar klient og koblee til broker
        Client client = new Client("display", Common.BROKERHOST, Common.BROKERPORT);
        client.connect();

        // Oppretta temperatur-topic
        client.createTopic("temperature");

        // Abonnera på temperatur-topic
        client.subscribe("temperature");

        // Mottar COUNT meldinger
        for (int i = 0; i < COUNT; i++) {
            PublishMsg msg = (PublishMsg) client.receive();
            System.out.println("DISPLAY: " + msg.getMessage());
        }

        // Avsluttar abonnement
        client.unsubscribe("temperature");

        // Kobla frå broker
        client.disconnect();
		
		System.out.println("Display stopping ... ");
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
