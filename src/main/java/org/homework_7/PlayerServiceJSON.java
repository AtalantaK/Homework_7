package org.homework_7;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PlayerServiceJSON extends PlayerServiceClass{

    private static final String FILE_NAME = "playersJSON.json";

    protected PlayerServiceJSON(String method) {
        super(method);
    }

    protected static void saveToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), players);
    }
}
