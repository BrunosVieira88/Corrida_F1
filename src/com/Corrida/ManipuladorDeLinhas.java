package com.Corrida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ManipuladorDeLinhas {
	
	private static Map<String, List<String>> voltasCompletadasPorPiloto = new HashMap<>();
	
	public static void processarLinha(String linha, List<String> todosPilotos, List<String> codigosPilotos , List<String> Voltas) {
		
		String[] parts = linha.split(";");		
		String hora = parts[0];
		String codigoPiloto = parts[1];
		String piloto = parts[2];
		String numeroDaVolta = parts[3];
		String tempoVoltaString = parts[4];
		SomadasVoltas.tempoTotal(tempoVoltaString, codigoPiloto);
		
		if (!todosPilotos.contains(piloto)) {
			todosPilotos.add(piloto);
		}
		
		if (!codigosPilotos.contains(codigoPiloto)) {
			codigosPilotos.add(codigoPiloto);
		}
		
		if (!Voltas.contains(numeroDaVolta)) {
			Voltas.add(numeroDaVolta);
		}
		
		if (!voltasCompletadasPorPiloto.containsKey(codigoPiloto)) {
			voltasCompletadasPorPiloto.put(codigoPiloto, new ArrayList<>());
		}
		
		voltasCompletadasPorPiloto.get(codigoPiloto).add(numeroDaVolta);
	}
		
	public static Map<String, List<String>> getVoltasCompletadasPorPiloto() {
		return voltasCompletadasPorPiloto;
	}
}