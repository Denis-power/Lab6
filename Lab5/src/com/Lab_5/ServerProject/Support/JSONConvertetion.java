package com.Lab_5.ServerProject.Support;

import com.Lab_5.ServerProject.Exceptions.InJsonConversionException;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONConvertetion<T> {

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
