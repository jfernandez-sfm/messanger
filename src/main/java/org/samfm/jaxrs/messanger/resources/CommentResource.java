package org.samfm.jaxrs.messanger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.samfm.jaxrs.messanger.model.Comment;
import org.samfm.jaxrs.messanger.service.CommentService;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	CommentService cs = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId) {
		return cs.getComments(messageId);
	}

	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId")long messageId, 
								@PathParam("commentId")long commentId) {
		return cs.getComment(messageId, commentId);
	}
	
	@POST
	public Comment postComment(@PathParam("messageId")long messageId, Comment comment) {
		return cs.postComment(messageId, comment);
	}
	
	
	@PUT
	@Path("/{commentId}")
	public Comment putComment(@PathParam("messageId")long messageId, 
								@PathParam("commentId")long commentId, Comment comment) {
		
		return cs.putComment(messageId, commentId, comment);
	}
	
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId")long messageId,
									@PathParam("commentId")long commentId) {
		return cs.deleteComment(messageId, commentId);
	}
	
	
}
