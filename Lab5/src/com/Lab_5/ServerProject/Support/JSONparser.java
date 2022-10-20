package com.Lab_5.ServerProject.Support;

import com.Lab_5.ClientProject.HumanBeing.HumanBeing;
import com.Lab_5.ServerProject.Exceptions.InputFileContentException;
import com.Lab_5.ClientProject.Exceptions.InvalidIdException;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.LinkedList;

public class JSONparser implements Parser<LinkedList<HumanBeing>> {

    public LinkedList<HumanBeing> parsing(String jsonString) throws InputFileContentException {
        try {
            if(jsonString.equals(""))//если пустой файл
                return new LinkedList<HumanBeing>();
            final Gson g = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new JsonDeserializer<ZonedDateTime>() {
                @Override
                public ZonedDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString());
                }
            }).create();
            HumanBeing[] data = g.fromJson(jsonString, HumanBeing[].class);
            //проверка на id>0 и нет ли совпадений
            LinkedList<HumanBeing> Ldata = new LinkedList<HumanBeing>();
            LinkedList<Long> identifiers = new LinkedList<>();
            for (HumanBeing hum: data) {//проверяем на уникальность и положительность
                if(hum.getId()<0)
                    throw new InvalidIdException();
                if(identifiers.contains(hum.getId()))
                    throw new InvalidIdException();
                identifiers.add(hum.getId());
                Ldata.add(hum);
            }
            return Ldata;
        }
        catch (Exception ex){
            if(ex instanceof InvalidIdException)
                System.err.println(ex);
            throw new InputFileContentException();
        }
    }
}
