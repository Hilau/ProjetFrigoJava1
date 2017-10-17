package Controler;

import Controler.AbstractControler;
import Model.FridgeModel;
import View.FridgeView;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

public class FridgeControler extends AbstractControler implements SerialPortEventListener {

	private SerialPort serialPort;
	/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = {
			"COM3", // Windows
	};
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public FridgeControler()
	{
		this.model = new FridgeModel();
		FridgeView view = new FridgeView(this);
		this.model.addObserver(view);

		this.initialize();
		Thread t=new Thread() {
			public void run() {
				//the following line will keep this app alive for 1000 seconds,
				//waiting for events to occur and responding to them (printing incoming messages to console).
				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
			}
		};
		t.start();

	}

	public void toggleDoor()
	{

	}

	public void updateTemperature()
	{

	}

	public void initialize() {
			CommPortIdentifier portId = null;
			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

			//First, Find an instance of serial port as set in PORT_NAMES.
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				for (String portName : PORT_NAMES) {
					if (currPortId.getName().equals(portName)) {
						portId = currPortId;
						break;
					}
				}
			}

			if (portId == null) {
				System.out.println("Could not find COM port.");
				return;
			}

			try {
				// open serial port, and use class name for the appName.
				serialPort = (SerialPort) portId.open(this.getClass().getName(),
						TIME_OUT);

				// set port parameters
				serialPort.setSerialPortParams(DATA_RATE,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				// open the streams
				input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
				output = serialPort.getOutputStream();

				// add event listeners
				serialPort.addEventListener((SerialPortEventListener) this);
				serialPort.notifyOnDataAvailable(true);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}

		/**
		 * This should be called when you stop using the port.
		 * This will prevent port locking on platforms like Linux.
		 */
		public synchronized void close() {
			if (serialPort != null) {
				serialPort.removeEventListener();
				serialPort.close();
			}
		}

		/**
		 * Handle an event on the serial port. Read the data and print it.
		 */
		public synchronized void serialEvent(SerialPortEvent oEvent) {

			//TODO : Add info to interface here !!!

			if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				try {
					//Lecture des données de l'arduino
					String inputLine=input.readLine();
					System.out.println("Update info");
					System.out.println(inputLine);

					this.model.setInternalTemperature(Integer.parseInt(inputLine));
					//FridgeInformation info = FridgeInformation.getINSTANCE();
					//info.setInternalTemperature(Integer.parseInt(inputLine));
					//float[] data;
					//data[0] = info.getInternalTemperature();
					//FridgeInterface.updateView(data);

				} catch (Exception e) {
					System.err.println(e.toString());
				}
			}

			// Ignore all the other eventTypes, but you should consider the other ones.
		}

	}
