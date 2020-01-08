package br.com.jardimtech.brainlang.dsl;

import br.com.jardimtech.brainlang.dsl.BCI.Response;
import br.com.jardimtech.brainlang.enums.TrainingDirection;
import br.com.jardimtech.brainlang.interfaces.CallAny;
import br.com.jardimtech.brainlang.interfaces.CallError;
import br.com.jardimtech.brainlang.interfaces.CallSucess;

public class TrainingBCI {
	
	private Boolean repeatUntilSucced;
	private Integer repeatMax;
	
	
	public TrainingBCI setRepeatUntilSucced(Boolean repeatUntilSucced) {
		this.repeatUntilSucced = repeatUntilSucced;
		return this;
	}

	public TrainingBCI setRepeatMax(Integer repeatMax) {
		this.repeatMax = repeatMax;
		return this;
	}

	public Response training(TrainingDirection trainingDirection) {
		return new Response();
	}
	
	public static final class Response {
		
		public Response done(CallSucess call) {
			System.out.println("done!");
			return this;
		}
		
		public Response failed(CallError call) {
			System.out.println("failed!");
			return this;
		}
		
		public Response progress(CallAny<Integer> callProgress) {
			System.out.println("progress!");
			return this;
		}
	}

}
