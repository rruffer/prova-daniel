package br.com.rruffer.prova.util;

import org.jsoup.Jsoup;

public class UtilLimparDado {
	
	public static void main(String[] args) {
		
		String dado = "<TD style=\"width:85%;\"><span id=\"PCTapplicants\" class=\"notranslate\"><B>BSH BOSCH UND SIEMENS HAUSGERÄTE GMBH <não sei> </B> [DE/DE]; Zentralabteilung Patente und Lizenzen, Hochstr. 17, 81669 München (DE) <I>(For All Designated States Except US)</I>.<BR/><B>WOLDENBERG, Walter</B> [DE/DE];  (DE) <I>(For US Only)</I>.<BR/><B>KRANZ, Thomas</B> [DE/DE];  (DE) <I>(For US Only)</I>";
		
/*		String dadolimpo = dado.trim().replace("<TD style=\"width:85%;\"><span id=\"PCTapplicants\" class=\"notranslate\">", "").replace("</B>", "").replace("<I>", "").replace("</I>", "").replace("<BR/>", "");
		
		String[] arrayRequerentes = dadolimpo.split("<B>");
		
		for(String d : arrayRequerentes) {
			System.out.println("Requerente: " + d);
		}
		
		String texto = "<html><b>teste</b></html><fuuuuu>";*/
		
		//System.out.println(dado.replaceAll("\\<.*?\\>", ""));
		System.out.println(Jsoup.parse(dado).text());
		
		
	}

}
