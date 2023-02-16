package com.Corrida;

import java.util.HashMap;
import java.util.Map;

public class SomadasVoltas {
	
	private static Map<String, Integer> tempoTotalPorPiloto = new HashMap<>();
	
	public static void tempoTotal(String tempoVoltaString , String codigoPiloto) {
				
		String[] tempoVoltaParts = tempoVoltaString.split("\\.");
		int minutos = Integer.parseInt(tempoVoltaParts[0].split(":")[0]);
		int segundos = Integer.parseInt(tempoVoltaParts[0].split(":")[1]);
		int milisegundos = Integer.parseInt(tempoVoltaParts[1]);
		int tempoVolta = (minutos * 60000) + (segundos * 1000) + milisegundos;
		
		if (!tempoTotalPorPiloto.containsKey(codigoPiloto)) {
            tempoTotalPorPiloto.put(codigoPiloto, 0);
        }   
		
        tempoTotalPorPiloto.put(codigoPiloto, tempoTotalPorPiloto.get(codigoPiloto) + tempoVolta);     
	}
	
	 public static Map<String, Integer> getTempoTotalPorPiloto() {
	    return tempoTotalPorPiloto;
	  }
}
