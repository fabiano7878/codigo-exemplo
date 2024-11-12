package br.com.codigo.exemplo.codigo.exemplo.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploApplication {

    public static void main(String[]args){
    
        
        Carta cartaBR = new Carta("BR");
    		Carta cartaFR = new Carta("FR");
    		Carta cartaUS = new Carta("US");

    		List<Carta> cartas = new ArrayList();
    
    		//cartas.add(cartaBR);
    		//cartas.add(cartaFR);
    		cartas.add(cartaUS);
     

    
    //List<Carta> cartas = Arrays.asList(new Carta("BR"),new Carta("FR"), new Carta("US"));
    
    List<String> cargas = Arrays.asList("A", "B","C", "D", "E");
    
    
        loopHere:
        for(int i=0; i<= cargas.size(); i++){
            System.out.println("iniciando for externo");
            for (Carta c: cartas){
                System.out.println("iniciando for interno");
                if(c.getOrigem().equals("BR")){
                    System.out.println("Brasil");
                    System.out.println("break interno");                    
                }
                if(c.getOrigem().equals("US")){
                    System.out.println("Estados Unidos");
                    System.out.println("Aqui aciona loopHere");
                    break loopHere;
                }
                if(c.getOrigem().equals("FR")){
                    System.out.println("França");
                    System.out.println("break interno");
                    break;
                }
                System.out.println("break externo");                
            }
        }
    }
}

class Carta {
    private String origem;

    public Carta() {
    }

    public Carta(String origem) {
        this.origem = origem;
    }

    public void setOrigem(String o) {
        this.origem = o;
    }

    public String getOrigem() {
        return this.origem;
    }
}
