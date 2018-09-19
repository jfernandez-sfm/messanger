package org.samfm.jaxrs.messanger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.samfm.jaxrs.messanger.model.Comment;
import org.samfm.jaxrs.messanger.model.Message;
import org.samfm.jaxrs.messanger.service.MessageService;

@Path("/testdata")
public class TestdataResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String createTestdata() {
		MessageService ms = new MessageService();
		
		Message ms1 = new Message(1, "Primer mensaje", "jorge");
		Message ms2 = new Message(2, "Segundo mensaje", "miriam");
		Message ms3 = new Message(3, "Tercer mensaje", "jorgev");
		Message ms4 = new Message(4, "Cuarto mensaje", "samuel");
		
		Comment cm1 = new Comment(1, "Comment 1 a mensaje2", "jorge");
		Comment cm2 = new Comment(2, "Comment 2 a mensaje2", "jorgev");
		Comment cm3 = new Comment(3, "Comment 3 a mensaje2", "samuel");
		
		ms2.getComments().put(cm1.getId(), cm1);
		ms2.getComments().put(cm2.getId(), cm2);
		ms2.getComments().put(cm3.getId(), cm3);
		
		ms.postMessage(ms1);
		ms.postMessage(ms2);
		ms.postMessage(ms3);
		ms.postMessage(ms4);
		
		
		return "Test data created";
	}
	
	
}
