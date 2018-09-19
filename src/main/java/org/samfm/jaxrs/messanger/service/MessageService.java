package org.samfm.jaxrs.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.samfm.jaxrs.messanger.database.DatabaseClass;
import org.samfm.jaxrs.messanger.excptions.DataNotFoundException;
import org.samfm.jaxrs.messanger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages(); 
	
	public MessageService() {
	}
	
	public List<Message> getMessages(){
		return new ArrayList<Message>(messages.values());
	}

	
	public List<Message> getMessagesForYear(int year){
		List<Message> msgForYear = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {

			cal.setTime(message.getMessageDate());
			if (cal.get(Calendar.YEAR) == year) 
				msgForYear.add(message);
			
		}
		
		return msgForYear;
	}

	
	public List<Message> getMessagesPaginated(int start, int size){
		ArrayList<Message> msgPaginate = (ArrayList<Message>)getMessages();
		
		if ((start + size) > msgPaginate.size())
			return new ArrayList<Message>();
		
		return msgPaginate.subList(start, start + size);
		
	}

	
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		
		if (message == null) 
			throw new DataNotFoundException("The message with id " + id + " was not found");
		
		return message;
	}
	
	public Message putMessage(Message message) {
		if (!messages.containsKey(message.getId())) 
			return null;

		messages.put(message.getId(), message);
		return (message);
	}
	
	
	public Message postMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	
	public Message removeMessage(long id) {
		return (Message) messages.remove(id);
	}
}
