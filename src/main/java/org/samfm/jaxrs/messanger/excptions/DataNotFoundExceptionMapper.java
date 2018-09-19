package org.samfm.jaxrs.messanger.excptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.samfm.jaxrs.messanger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException arg0) {
		Status status = Status.NOT_FOUND;
		int errorCode = 5000 + status.getStatusCode();
		
		ErrorMessage errMsg = new ErrorMessage(arg0.getMessage(), 
										errorCode, 
										"http://localhost:8080/messanger/webapi/documentation");
		
		return Response.status(status)
					.entity(errMsg)
					.build();
	}
	

}
