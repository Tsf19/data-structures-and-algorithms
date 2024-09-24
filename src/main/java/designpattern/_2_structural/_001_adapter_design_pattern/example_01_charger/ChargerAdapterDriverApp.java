package designpattern._2_structural._001_adapter_design_pattern.example_01_charger;

class AndroidCharger {

	void chargingAndroidPhone() {
		System.out.println("charging android phone");
	}

}

class AppleCharger {

	void chargingApplePhone() {
		System.out.println("charging apple phone");
	}

}

class AndroidPhone {

	void charge(AndroidCharger charger) {
		charger.chargingAndroidPhone();
	}

}

class ApplePhone {

	void charge(AppleCharger charger) {
		charger.chargingApplePhone();
	}

}

class AndroidToAppleChargerAdapter extends AppleCharger {

	private AndroidCharger charger;
	
	AndroidToAppleChargerAdapter(AndroidCharger charger) {
		System.out.println("Android To Apple Charger Adapter Detected... ");
		this.charger = charger;
	}

	@Override
	void chargingApplePhone() {
		System.out.println("Now it will charge apple phone with android charger... ");
		charger.chargingAndroidPhone();
	}

}

class ChargerAdapterDriverApp {

	public static void main(String[] args) {

		AndroidPhone androidPhone = new AndroidPhone();

		AndroidCharger androidCharger = new AndroidCharger();
		androidPhone.charge(androidCharger); // charging android phone

		
		
		ApplePhone applePhone = new ApplePhone();

		AppleCharger appleCharger = new AppleCharger();
		applePhone.charge(appleCharger); // charging apple phone
		
		
		AppleCharger adapter = new AndroidToAppleChargerAdapter(androidCharger);
		applePhone.charge(adapter);
		// Android To Apple Charger Adapter Detected... 
		// Now it will charge apple phone with android charger... 
		// charging android phone
		
	}

}
