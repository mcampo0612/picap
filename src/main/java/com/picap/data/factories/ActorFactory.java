package com.picap.data.factories;

import com.picap.exceptions.ActorNotFoundException;
import com.picap.models.actor.Picap;
import com.picap.util.GetEnvironment;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class ActorFactory {

    private static final String ACTORS_PATH = "/actors/picap-actors.json";

    public static List<Picap> getActors()  {
        return Arrays.asList(from(getActorsFile()).getObject("actors", Picap[].class));
    }

    public static Picap getActorById(int id)  {
        return getActors().stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new ActorNotFoundException(String.format("user with id %s not found", id)));
    }
    @SneakyThrows
    private static URL getActorsFile()  {
        String path = GetEnvironment.actual() + ACTORS_PATH;
        URL filePath = ActorFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for actors: " + path);
        }
        return filePath;
    }
}
