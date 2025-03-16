package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		 // Oppretta ein klient og kobble tiil broker
		 Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		 client.connect();
 
		 // Publisera temperaturdata COUNT gangar
		 for (int i = 0; i < COUNT; i++) {
			 int temp = sn.read();
			 System.out.println("READING: " + temp);
			 client.publish("temperature", String.valueOf(temp));
 
			 // Simulera ventetida mellom målingar
			 try {
				 Thread.sleep(1000); 
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 }
 
		 // Koblarr frå broker
		 client.disconnect();

		System.out.println("Temperature device stopping ... ");

		throw new UnsupportedOperationException(TODO.method());

	}
}
