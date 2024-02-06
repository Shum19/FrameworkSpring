package firstHomeTask.Service;

import com.google.gson.*;
import firstHomeTask.domen.Person;

import java.lang.reflect.Type;

public class SerialisePerson implements JsonSerializer<Person> {

    @Override
    public JsonElement serialize(Person person, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject serialised = new JsonObject();
        serialised.add("name", new JsonPrimitive(person.getName()));
        serialised.add("surname", new JsonPrimitive(person.getSurname()));
        serialised.add("age", new JsonPrimitive(person.getAge()));
        return serialised;
    }

}
