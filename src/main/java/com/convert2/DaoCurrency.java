package com.convert2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DaoCurrency {

	private Gson gson;
	private final String url = "convertone/src/main/resources/info.json";
	public DaoCurrency(){
		this.gson = new GsonBuilder().setPrettyPrinting().create();
		
	}

	public CurrencyR deserialize(String body){
		return this.gson.fromJson(body, CurrencyR.class);
	}
	
    public void saveConversion(Convertion conversion) throws IOException {
        try (FileWriter writer = new FileWriter(url)) {
            String json = this.gson.toJson(conversion);
            writer.write(json);
		}
		
    } 

}
