package org.samfm.jaxrs.messanger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.samfm.jaxrs.messanger.beans.MessagesFilterBean;
import org.samfm.jaxrs.messanger.model.Message;
import org.samfm.jaxrs.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessagesFilterBean mfb) {
		
		if (mfb.getYear() > 0 ) return messageService.getMessagesForYear(mfb.getYear());
		
		if (mfb.getStart() >= 0 && mfb.getSize() > 0)
			return messageService.getMessagesPaginated(mfb.getStart(), mfb.getSize());
		
		return messageService.getMessages();
	}

	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id); 
		String messageId = String.valueOf(message.getId());
		
		message.addLink("self", getUriForSelf(uriInfo, messageId));
		
		return message;
	}


	private String getUriForSelf(UriInfo uriInfo, String messageId) {
		return uriInfo.getBaseUriBuilder()
								.path(MessageResource.class)
								.path(messageId)
								.build()
								.toString();
	}
	
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.postMessage(message);
		
		String newId = String.valueOf(newMessage.getId());
		
		URI uri = uriInfo.getAbsolutePathBuilder()
						.path(newId)
						.build();
		
		return Response.created(uri)
						.entity(newMessage)
						.build();
	}

	@PUT
	@Path("/{messageId}")
	public Response putMessage(@PathParam("messageId")long id, Message message, @Context UriInfo uriInfo) {

		URI uri = uriInfo.getAbsolutePathBuilder().build();
		
		message.setId(id);
		Message messageUpdate = messageService.putMessage(message);
		
		return Response.created(uri)
				.entity(messageUpdate)	
				.build(); 
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id ) {
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComments(){
		return new CommentResource();
	}
	
}
