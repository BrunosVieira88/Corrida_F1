package com.Corrida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static List<String> todosPilotos = new ArrayList<>();
    private static List<String> codigosPilotos = new ArrayList<>();
    private static List<String> voltas = new ArrayList<>();
    private static int posicaoChegada = 1;


    public static void main(String[] args) throws FileNotFoundException {
    	
        File file = new File("C:/Users/bruno/eclipse-workspace/Corrida/src/com/Corrida/arquivo_de_entrada.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                ManipuladorDeLinhas.processarLinha(linha, todosPilotos, codigosPilotos, voltas);
            }
           
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Map<String, Integer> mapaTempoTotalPorPiloto = SomadasVoltas.getTempoTotalPorPiloto();
        Map<String, List<String>> mapaVoltasCompletadasPorPiloto = ManipuladorDeLinhas.getVoltasCompletadasPorPiloto();
        List<PilotoResultado> resultados = new ArrayList<>();

        for (Map.Entry<String, Integer> entrada : mapaTempoTotalPorPiloto.entrySet()) {
            String codigoPiloto = entrada.getKey();
            int tempoTotalProva = entrada.getValue();
            String nomePiloto = todosPilotos.get(codigosPilotos.indexOf(codigoPiloto));
            List<String> voltasCompletadas = mapaVoltasCompletadasPorPiloto.get(codigoPiloto);
            int qtdeVoltasCompletadas = (voltasCompletadas != null) ? voltasCompletadas.size() : 0;

       
			PilotoResultado resultado = new PilotoResultado(posicaoChegada, codigoPiloto, nomePiloto, qtdeVoltasCompletadas, tempoTotalProva);
            resultados.add(resultado);
            posicaoChegada++;
        }

	        Collections.sort(resultados);
	        
	        try {
	            FileWriter writer = new FileWriter("resultados.txt");
	            Collections.sort(resultados);
	            for (PilotoResultado resultado : resultados) {
	                writer.write(resultado.toString() + "\n");
	            }
	            System.out.println("Documento TXT criado!");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	   
	} 
}