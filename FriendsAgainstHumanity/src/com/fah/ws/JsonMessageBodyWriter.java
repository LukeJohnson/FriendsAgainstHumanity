package com.fah.ws;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * Converts Java Objects to JSON data
 * @author piercb2
 */
@SuppressWarnings("rawtypes")
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonMessageBodyWriter implements MessageBodyWriter {

	@Override
	public long getSize(Object obj, Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {

		return -1;
	}

	@Override
	public boolean isWriteable(Class type, Type genericType, Annotation annotations[], MediaType mediaType) {

		return true;
	}

	@Override
	public void writeTo(Object target, Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, OutputStream outputStream) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		mapper.writeValue(outputStream, target);
	}

}