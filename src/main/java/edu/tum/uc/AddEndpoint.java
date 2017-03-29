package edu.tum.uc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import edu.tum.cal.add.AddNumbersRequest;
import edu.tum.cal.add.AddNumbersResponse;

@Endpoint
public class AddEndpoint {
	private static final String NAMESPACE_URI = "http://add.cal.tum.edu";
	
	private AddServiceImpl addService = null;
	
	@Autowired
	public AddEndpoint(AddServiceImpl addService){
		this.addService = addService;
	}
	
	@PayloadRoot(localPart = "AddNumbersRequest", namespace = NAMESPACE_URI)
	@ResponsePayload
	public AddNumbersResponse add(@RequestPayload AddNumbersRequest numbers){
		AddNumbersResponse _return = new AddNumbersResponse();
		double r = this.addService.add(Double.parseDouble(numbers.getN1()), Double.parseDouble(numbers.getN2()));
		_return.setN1(String.valueOf(r));
		return _return;
	}
}
