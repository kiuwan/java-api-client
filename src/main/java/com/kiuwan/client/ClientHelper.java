package com.kiuwan.client;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.glassfish.jersey.client.HttpUrlConnectorProvider.ConnectionFactory;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
 
public class ClientHelper {
	
	public static Client createClient() {
		return createClient(null, null, null, null, null);
	}
	
	public static Client createClient(String proxyHost, Integer proxyPort, Proxy.Type proxyType, String proxyUser, String proxyPassword) {
		JerseyClientBuilder clientBuilder = new JerseyClientBuilder();
		
		clientBuilder.hostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
        });
		
		TrustManager[ ] certs = new TrustManager[ ] {
	            new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
				}
	    };
	    SSLContext sslContext = null;
	    try {
	    	sslContext = SSLContext.getInstance("TLS");
	    	sslContext.init(null, certs, new SecureRandom());
	    } catch (java.security.GeneralSecurityException ex) {
	    }
		
		clientBuilder.sslContext(sslContext);
		
		Client client = null;
		if(proxyHost != null && proxyPort != null && proxyType != null){
			client = clientBuilder.newClient(ClientHelper.configureClient(proxyHost, proxyPort, proxyType, proxyUser, proxyPassword));
		}
		else{
			client = clientBuilder.newClient();
		}
		
		JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
		jsonProvider.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	    return client.register(jsonProvider).register(JacksonFeature.class);
	}
	
	private static ClientConfig configureClient(String proxyHost, Integer proxyPort, Proxy.Type proxyType, String proxyUser, String proxyPassword) {
		ConnectionFactory connectionFactory = buildConnectionFactoryWithProxy(proxyHost, proxyPort, proxyType);
		if(proxyUser != null){
			configureProxyAuthentication(proxyUser, proxyPassword);
		}
		HttpUrlConnectorProvider httpUrlConnectorProvider = new HttpUrlConnectorProvider().connectionFactory(connectionFactory);
	    
	    return new ClientConfig().connectorProvider(httpUrlConnectorProvider);
	}
	
	private static ConnectionFactory buildConnectionFactoryWithProxy(String proxyHost, Integer proxyPort, Proxy.Type proxyType) {
		final Proxy proxy = new Proxy(proxyType, new InetSocketAddress(proxyHost, proxyPort));
		ConnectionFactory connectionFactory = new ConnectionFactory() {

			public HttpURLConnection getConnection(URL url) throws IOException {
				return (HttpURLConnection) url.openConnection(proxy);
			}

		};
		return connectionFactory;
	}

	private static void configureProxyAuthentication(final String proxyUser, String proxyPassword) {
		if(proxyPassword == null){
			proxyPassword = "";
		}
		final String secret = proxyPassword;
		Authenticator.setDefault(new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(proxyUser, secret.toCharArray());
			}
		});
	}
}