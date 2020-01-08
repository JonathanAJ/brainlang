package br.com.jardimtech.brainlang;

import br.com.jardimtech.brainlang.bridge.Emotiv;
import br.com.jardimtech.brainlang.dsl.BCI;
import br.com.jardimtech.brainlang.dsl.MentalBCI;
import br.com.jardimtech.brainlang.dsl.TrainingBCI;
import br.com.jardimtech.brainlang.dsl.View;
import br.com.jardimtech.brainlang.enums.TrainingDirection;
import br.com.jardimtech.brainlang.interfaces.MentalEvent;

public class App {
	
    public static void main( String[] args ) {
    	
    	BCI.connect(new Emotiv())
		   .bluetooth()
 	       .mac("10:20:30:10:00:01")
 	       .pinCode("a1b2c3")
 	       .initialize()
	 	       .failed(error -> {
					View.show("Conection failed with " + error);
	 	       })
	 	       .done(() -> {
	 	    	   
	 	    	   // To do start training
	 	    	   
	 	       });
    	

  	   new TrainingBCI()
  	   		.setRepeatMax(10)
  	   		.setRepeatUntilSucced(Boolean.TRUE)
  	   		.training(TrainingDirection.Neutral)
  	   			.progress( progress -> {
  	   				View.show("Your training " + 
  	   							TrainingDirection.Neutral.toName() + 
  	   							" has "+ progress + "% done.");
  	   			})
  	   			.failed( error -> {
  	   				View.show("Training failed with " + error);
  	   			})
  	   			.done(() -> {
  	   				View.show("Training of "
  	   						+ TrainingDirection.Neutral.toName()
  	   						+ " done!");
  	   			});
  	   
  	   
  	  new MentalBCI()
  	  		.commandEvent(new MentalEvent() {
				public void top(Integer force) {
					// TODO make here the action of event
					
				}
				public void right(Integer force) {
					// TODO make here the action of event
					
				}
				public void neutral(Integer force) {
					// TODO make here the action of event
					
				}
				public void left(Integer force) {
					// TODO make here the action of event
					
				}
				public void bottom(Integer force) {
					// TODO make here the action of event
					
				}
			});
  	   
  	   
  	   
  	   
    }
}