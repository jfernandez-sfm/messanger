package org.samfm.jaxrs.messanger.excptions;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.samfm.jaxrs.messanger.model.ErrorMessage;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		Status status = Status.INTERNAL_SERVER_ERROR;
		int errorCode = 5000 + status.getStatusCode();
		
		
		ErrorMessage errMsg = new ErrorMessage(exception.getMessage(), 
													errorCode, 
													"http://localhost:8080/messanger/webapi/documentation");
		
		return Response.status(status)
				.entity(errMsg)
				.header("Content-type", "application/json")
				.build();
					
	}

}
