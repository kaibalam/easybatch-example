package com.ericsson.crm.security.dto;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		ApiData data = (ApiData) value;
		gen.writeObjectField(data.getName(), data.getData());
		gen.writeEndObject();
	}
	
	

}
