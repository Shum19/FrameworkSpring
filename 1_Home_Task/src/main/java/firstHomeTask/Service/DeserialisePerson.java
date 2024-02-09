package firstHomeTask.Service;

import com.google.gson.*;
import firstHomeTask.domen.Person;

import java.lang.reflect.Type;


public class DeserialisePerson implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        String surname = jsonObject.get("surname").getAsString();
        int age = jsonObject.get("age").getAsInt();
        return new Person(name,surname, age);
    }
}
