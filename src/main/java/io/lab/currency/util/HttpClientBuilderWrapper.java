package io.lab.currency.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientBuilderWrapper {
	
	public static HttpClient build() {
		
		return HttpClientBuilder.create().build();
	}
}
