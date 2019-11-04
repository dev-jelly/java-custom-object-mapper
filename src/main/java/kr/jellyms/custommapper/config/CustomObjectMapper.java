package kr.jellyms.custommapper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

class CustomObjectMapper extends ObjectMapper {
    CustomObjectMapper() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(String.class, new CustomStringSerializer());
        simpleModule.addDeserializer(String.class, new CustomStringDeserializer());

        registerModule(simpleModule);
    }
}
