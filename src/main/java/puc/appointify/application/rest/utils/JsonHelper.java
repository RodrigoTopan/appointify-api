package puc.appointify.application.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonHelper {

    private final ObjectMapper mapper;

    public <T> T toObject(final String pathJson, final Class<T> clazz) {
        try {
            return mapper.readValue(getJson(pathJson), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public URL getJson(final String pathJson) {
        return this.getClass().getClassLoader().getResource(pathJson);
    }

    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public <T> T fromJson(final String message, final Class<T> clazz) {
        try {
            return mapper.readValue(message, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public <T> List<T> toListObject(final String pathJson, final Class<T> clazz) {
        try {
            return mapper.readValue(
                    getJson(pathJson), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String objectToJson(final Object object) {
        try {
            return this.mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> Optional<T> deserialize(final String payload, final Class<T> clazz) {
        try {
            return Optional.ofNullable(mapper.readValue(payload, clazz));
        } catch (Exception e) {
            log.info("Error to convert payload to object: [{}]", payload);
            return Optional.empty();
        }
    }

}
