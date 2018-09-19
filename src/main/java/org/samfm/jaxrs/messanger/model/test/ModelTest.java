package org.samfm.jaxrs.messanger.model.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.samfm.jaxrs.messanger.model.Message;


public class ModelTest {

	@Test
	public void test() {
		
		int id = 1;
		String msgText = "Hello Wordl";
		String author = "Jorge";
				
		Message msg = new Message(id, msgText, author);
		assertEquals("El id es correcto", msg.getId(), id);
		assertEquals("El id es correcto", msg.getMessage(), msgText);
		assertEquals("El id es correcto", msg.getAuthor(), author);
	}

}
