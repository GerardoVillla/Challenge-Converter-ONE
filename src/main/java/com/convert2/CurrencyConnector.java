package com.convert2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.convert2.*;

public class CurrencyConnector {
	private String key = "e6aa23dc869b134f5bb179e7";
	private String baseUrl = "https://v6.exchangerate-api.com/v6/";

	public CurrencyConnector(){
	}

	private String getHttpCurrency(String currency) throws IOException, InterruptedException {
		// Api credentials
		String direction = this.baseUrl + this.key + "/latest/" + currency;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(direction))
				.build();
		// get response body
		HttpResponse<String> response = client
				.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	
	public CurrencyR processResponse(String currency) throws IOException, InterruptedException{
		DaoCurrency dao = new DaoCurrency();
		return dao.deserialize(getHttpCurrency(currency));
	}
}