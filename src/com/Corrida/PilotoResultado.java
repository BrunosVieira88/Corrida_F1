package com.Corrida;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

class PilotoResultado implements Comparable<PilotoResultado> {
    
	private int posicaoChegada;
    private String codigoPiloto;
    private String nomePiloto;
    private int qtdeVoltasCompletadas;
    private int tempoTotalProva;
    private static int contador = 1 ;

    public PilotoResultado(int posicaoChegada, String codigoPiloto, String nomePiloto, int qtdeVoltasCompletadas, int tempoTotalProva) {
        this.posicaoChegada = posicaoChegada;
        this.codigoPiloto = codigoPiloto;
        this.nomePiloto = nomePiloto;
        this.qtdeVoltasCompletadas = qtdeVoltasCompletadas;
        this.tempoTotalProva = tempoTotalProva;
    }

    public int getPosicaoChegada() {
        return posicaoChegada;
    }

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public int getQtdeVoltasCompletadas() {
        return qtdeVoltasCompletadas;
    }

    public int compareTo(PilotoResultado o) {
        int compare = Integer.compare(o.qtdeVoltasCompletadas, qtdeVoltasCompletadas);
        if (compare != 0) {
            return compare;
        }

        return Integer.compare(tempoTotalProva, o.tempoTotalProva);
    }

    @Override
    public String toString() {
    	   String str = null;
    	   
        if (qtdeVoltasCompletadas == 4) {
        	 str = "Posição Chegada: " + contador + "\n" +
                     "Código Piloto: " + codigoPiloto + "\n" +
                     "Nome Piloto: " + nomePiloto + "\n" +
                     "Qtde Voltas Completadas: " + qtdeVoltasCompletadas + "\n" +
                     "Tempo Total de Prova: " + formatarTempo(tempoTotalProva) + "\n"+
                     contador+";"+codigoPiloto+";"+nomePiloto+";"+qtdeVoltasCompletadas+";"+formatarTempo(tempoTotalProva)+";\n";
        	 		contador= contador + 1;       	 		
        }  
        
        if (qtdeVoltasCompletadas < 4) {
        	  str = "Posição Chegada: " + contador + "\n" +
        			  "Código Piloto: " + codigoPiloto + "\n" +
                     "Nome Piloto: " + nomePiloto + "\n" +
                     "Qtde Voltas Completas: " + qtdeVoltasCompletadas + "\n" +
                     "Tempo Total de Prova: " + formatarTempo(tempoTotalProva) + "\n"+
        	 		 "STATUS: Não completou a prova\n"+
        	 		 contador+";"+codigoPiloto+";"+nomePiloto+";"+qtdeVoltasCompletadas+";"+formatarTempo(tempoTotalProva)+";\n";
	  				posicaoChegada = contador +1 ; 
        }             
		return str;
    }

    private static String formatarTempo(int tempoEmMilisegundos) {
    	Duration duracao = Duration.ofMillis(tempoEmMilisegundos);
        long minutos = duracao.toMinutes();
        long segundos = duracao.minusMinutes(minutos).getSeconds();
        return String.format("%02d:%02d.%03d", minutos, segundos, duracao.toMillis() % 1000);
    }
}
