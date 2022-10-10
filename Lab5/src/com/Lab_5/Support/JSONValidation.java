package com.Lab_5.Support;

import com.Lab_5.HumanBeing.HumanBeing;
import com.Lab_5.exceptions.InJsonConversionException;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.LinkedList;

public class JSONValidation<T> {

    public String validation(T data) throws InJsonConversionException {
        final Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).create();

        try {
            final String json_data = gson.toJson(data, data.getClass());
            return json_data;
        }
        catch (Exception ex){
        throw new InJsonConversionException();
        }
    }
}
