package br.com.jardimtech.brainlang;

import br.com.jardimtech.brainlang.dsl.BCI;
import br.com.jardimtech.brainlang.dsl.VIEW;

public class App {
	
    public static void main( String[] args ) {
    	
    	BCI.connect()
		   .bluetooth()
 	       .mac("10:20:30:10:00:01")
 	       .pinCode("kjh77hk")
 	       .initialize()
	 	       .failed(() -> {
					VIEW.show("Não foi possível conectar o dispositivo..");
	 	       })
	 	       .done(() -> {
	 	    	   
	 	       });
    }
}