package firstHomeTask;


import firstHomeTask.Service.DeserialisePerson;
import firstHomeTask.Service.SerialisePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import firstHomeTask.domen.Person;

public class MainApp {
    public static void main(String[] args) {
        Person person = new Person("Jack", "Jackson", 20);
        SerialisePerson serialisePerson = new SerialisePerson();
        Gson gsonSerialize = new GsonBuilder().registerTypeAdapter(Person.class, serialisePerson).create();
        System.out.println(gsonSerialize.toJson(person));

        String jsstr = gsonSerialize.toJson(person);
        Person person1 = gsonSerialize.fromJson(jsstr, Person.class);
        System.out.println(person1.toString());

        DeserialisePerson deserialisePerson = new DeserialisePerson();
        Gson gsonDeserialize = new GsonBuilder().registerTypeAdapter(Person.class, deserialisePerson).create();
        Person person2 = gsonDeserialize.fromJson(gsonSerialize.toJson(person), Person.class);
        System.out.println(person2);


    }
}
