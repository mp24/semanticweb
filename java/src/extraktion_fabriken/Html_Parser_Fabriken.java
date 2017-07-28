package extraktion_fabriken;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import com.google.gson.*;

import extraktion_fabriken.Baudenkmal;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.List;

public class Html_Parser_Fabriken {

	public static void main(String[] args) {
		
		Document doc = null;
		Elements tds = null; //HIER AENDERUNG
		
		Gson gson1 = new Gson();
		Gson gson2 = new Gson();
		String json1 ="";
		String json2 ="";
		
		
		
		//*für Testen*//
		Document doc2 = null;
		
		Elements alle_tab = null; 
		Element tabelle1 = null;
		Element tabelle2 = null;
		
		Elements fabr_und_strass1= null;
		Elements fabr_und_strass2= null;
		
		String objekt = null;
		String adresse = null;
		
		String objekt2 = null;
		String adresse2 = null;
		
		List<Baudenkmal> baudenkmale1 = new ArrayList<>();
		List<Baudenkmal> baudenkmale2 = new ArrayList<>();
		
		try {
			doc2 = Jsoup.connect("http://www.leerstehende-baudenkmale.de/baudenkmale/sachsen/l/startleipzig.htm").get();
			
			
			
			alle_tab = doc2.getElementsByTag("tbody");
			
			tabelle1 = alle_tab.get(0);
			tabelle2 = alle_tab.get(1);
			
			fabr_und_strass1 = tabelle1.getElementsByTag("td");
			fabr_und_strass2= tabelle2.getElementsByTag("td");
			
			
			
			for (int i= 0; i < 7; i++){
				
				objekt = fabr_und_strass1.get(i).getElementsByTag("h1").get(0).text();
				adresse = fabr_und_strass1.get(i).getElementsByTag("h1").get(2).text();
				
				
				
				baudenkmale1.add(new Baudenkmal(objekt, adresse));
				
				json1 = gson1.toJson(baudenkmale1);
			}
			
			for (int i= 0; i < 15; i++){
				
				objekt2 = fabr_und_strass2.get(i).getElementsByTag("h1").get(0).text();
				adresse2 = fabr_und_strass2.get(i).getElementsByTag("h1").get(2).text();
				
				
				
				baudenkmale2.add(new Baudenkmal(objekt2, adresse2));
				
				json2 = gson2.toJson(baudenkmale2);
				
			}
			
			
		}catch (IOException e2) { 
            e2.printStackTrace(); 
        } 
		
		System.out.println(json1);
		System.out.println(json2);
		
		try (FileWriter writer = new FileWriter("D:\\staff1.json")) {

            gson1.toJson(baudenkmale1, writer);

      } catch (IOException e3) {
            e3.printStackTrace();
     }
		
		try (FileWriter writer = new FileWriter("D:\\staff2.json")) {

            gson1.toJson(baudenkmale2, writer);

      } catch (IOException e4) {
            e4.printStackTrace();
     }
		
		
		
	}

}


