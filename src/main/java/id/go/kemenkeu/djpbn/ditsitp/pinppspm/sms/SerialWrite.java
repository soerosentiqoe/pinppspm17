package id.go.kemenkeu.djpbn.ditsitp.pinppspm.sms;


import id.go.kemenkeu.djpbn.ditsitp.pinppspm.model.SmsCenter;

import javax.comm.*;
import java.io.*;
import java.util.*;

public class SerialWrite implements Runnable, SerialPortEventListener {
	static String output = "";
	public SmsCenter smsCenter;
	

	public void run() {
	}

	static Enumeration portList;
	static CommPortIdentifier portId;
	static String dest = "+6285280232766";	
	static String messageString = "Hello Testing";
	static String smsc ="";
	InputStream inputStream;

	static SerialPort serialPort;
	static OutputStream outputStream;

	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			System.out.println("Error");
			break;
		case SerialPortEvent.DATA_AVAILABLE: {

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String line = "";
			try {

				while ((line = reader.readLine()) != null) {

					if (line.equalsIgnoreCase("OK")
							|| (line.indexOf("+CMGS") != -1)) {
						output = line;

					}
					Thread.sleep(10);

				}
			} catch (Exception e) {
				System.err.println("Error while reading Port " + e);
			}
			break;

		}
		} // switch
	}

	public SerialWrite(SerialPort serial) {
		try {
			inputStream = serial.getInputStream();
			try {
				serial.addEventListener(this);
			} catch (TooManyListenersException e) {
				System.out.println("Exception in Adding Listener" + e);
			}
			serial.notifyOnDataAvailable(true);

		} catch (Exception ex) {
			System.out.println("Exception in getting InputStream" + ex);
		}

	}

	public static void main(String[] args) throws Exception {
		int i = 0;
		
		String line0 = "ATZ\r\n";
		String line1 = "AT+CMGF=1\r\n";
		String line2 = "AT+CSCA=\"+62816124\"\r\n";

		String line3 = "AT+CMGS="+"\""+ dest + "\""+"\r\n";
		//String line3 = "AT+CMGS=" + "\"" + args[0] + "\"" + "\r\n";
		String line4 = messageString;
		//String line4 = args[1];

		portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println("SMS Sending........");
				if (portId.getName().equals("COM6")) {
					System.out.println("SMS Sending....Port Found");
					try {
						serialPort = (SerialPort) portId.open("SerialTestApp",
								2000);
						SerialWrite wr = new SerialWrite(serialPort);
					} catch (PortInUseException e) {
						System.out.println("Port In Use " + e);
					}
					try {
						outputStream = serialPort.getOutputStream();
					} catch (IOException e) {
						System.out.println("Error writing to output stream "
								+ e);
					}
					try {
						serialPort.setSerialPortParams(115200,
								SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
					} catch (UnsupportedCommOperationException e) {
					}
					try {

						outputStream.write(line0.getBytes());
						Thread.sleep(10);
						while (!output.equalsIgnoreCase("ok"))
							Thread.sleep(10);

						output = "";
						outputStream.write(line1.getBytes());
						while (!output.equalsIgnoreCase("ok"))
							Thread.sleep(10);

						output = "";

						outputStream.write(line2.getBytes());
						while (!output.equalsIgnoreCase("ok"))
							Thread.sleep(10);

						output = "";
						for (i = 0; i < 3; i++) {
							outputStream.write(line3.getBytes());
							Thread.sleep(10);
							outputStream.write(line4.getBytes());
							Thread.sleep(10);
							outputStream.write(26);
							outputStream.write("\r\n".getBytes());
							outputStream.flush();
							while (!output.equalsIgnoreCase("ok"))
								Thread.sleep(10);

							output = "";

							System.out.println("Message Sent !!!!!!!!!1");
						}

					} catch (IOException e) {
						System.out.println("Error writing message " + e);
					}

				}
			}
		}
	}

	/**
	 * show text in the text window
	 * 
	 * @param Text
	 *            text string to show on the display
	 */
	public static void showText(String Text) {
		System.out.println("TEXT " + Text);
	}
}
