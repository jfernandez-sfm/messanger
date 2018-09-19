package org.samfm.jaxrs.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.samfm.jaxrs.messanger.database.DatabaseClass;
import org.samfm.jaxrs.messanger.model.Comment;
import org.samfm.jaxrs.messanger.model.Message;

public class CommentService {

	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getComments(long messageId) {
		if (!messages.containsKey(messageId))
			return new ArrayList<>();
		
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	
	
	public Comment getComment(long messageId, long commentId) {
		return (Comment)messages.get(messageId).getComments().get(commentId);
	}
	
	
	public Comment postComment(long messageId, Comment comment) {
		if (!messages.containsKey(messageId))
			return null;

		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		
		return comment;
	}
	
	
	public Comment putComment(long messageId, long commentId, Comment comment) {
		
		if (!messages.containsKey(messageId))
			return null;
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		
		if (!comments.containsKey(commentId))
			return null;
		
		comment.setId(commentId);
		comments.put(commentId, comment);
		
		return comment;
	}
	
	
	public Comment deleteComment(long messageId, long commentId) {
		if(!messages.containsKey(messageId))
			return null;
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}



}
