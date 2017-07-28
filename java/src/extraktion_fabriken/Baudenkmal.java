package extraktion_fabriken;


public class Baudenkmal {
	
	
	private String objekt;
	private String adresse;
	
	Baudenkmal(){
		this.objekt = "";
		this.adresse = "";
	}
	
	 Baudenkmal(String objekt, String adresse){
		this.objekt= objekt;
		this.adresse = adresse;
	}
	
	public String getObjekt(){
		return this.objekt; 
	}
	
	public String getAdresse(){
		return this.adresse; 
	}

}
