package br.com.jardimtech.brainlang.dsl;

import java.util.logging.Logger;

import br.com.jardimtech.brainlang.bridge.DeviceBCI;
import br.com.jardimtech.brainlang.interfaces.CallError;
import br.com.jardimtech.brainlang.interfaces.CallSucess;

public final class BCI {
	
	private BCI() {
		
	}
	
	public static ConnectType connect(DeviceBCI deviceBCI) {
		return new ConnectType();
	}
	
	public static final class ConnectType {
		
		public final ConnectTypeBluetooth bluetooth() {
			System.out.println("Escolhido bluetooth");
			return new ConnectTypeBluetooth();
		}
		
		public final ConnectTypeWifi wifi() {
			return new ConnectTypeWifi();
		}
	}
	
	public static final class ConnectTypeBluetooth  {
		
		private String address = "";
		private String pinCode = "";

		public ConnectTypeBluetooth mac(String address) {
			this.address = address;
			System.out.println("mac "+address);
			return this;
		}
		
		public ConnectTypeBluetooth pinCode(String pinCode) {
			this.pinCode = pinCode;
			System.out.println("pinCode "+pinCode);
			return this;
		}
		
		public Response initialize() {
			System.out.println("initialize.......... ");
			return new Response();
		}
	}
	
	public static final class Response {
		
		public Response done(CallSucess call) {
			System.out.println("done!");
			return this;
		}
		
		public Response failed(CallError call) {
			System.out.println("failed!");
			return this;
		}
	}
	
	public static final class ConnectTypeWifi  {
		
		private String SSID = "";
		private String password = "";

		
		public ConnectTypeWifi SSID(String sSID) {
			SSID = sSID;
			return this;
		}


		public ConnectTypeWifi password(String password) {
			this.password = password;
			return this;
		}


		public void initialize(Response response) {
		}
	}
	
	// training
	
	public static TrainingBCI training() {
		return new TrainingBCI();
	}
	
	

}