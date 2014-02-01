package com.fah.ws;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Converts JSON data to Java objects
 * @author piercb2
 */
@SuppressWarnings("rawtypes")
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class JsonMessageBodyReader implements MessageBodyReader {

	@Override
    public boolean isReadable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {

	    return true;
    }

	@SuppressWarnings("unchecked")
    @Override
    public Object readFrom(Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {

		return new ObjectMapper().readValue(entityStream, type);
    }
}