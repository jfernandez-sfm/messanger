package org.samfm.jaxrs.messanger.service.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.samfm.jaxrs.messanger.service.MessageService;

public class ServiceTest {

	@Test
	public void test() {
		MessageService ms = new MessageService();
		assertNotNull(ms);
		assertEquals("Se esperaba un numero de mensajes de", 2, ms.getMessages().size());
	}

}
