package gov.nci.nih.cagrid.validator.steps;

import java.util.Properties;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.*;

import com.atomicobject.haste.framework.Step;

public class TestHttpServices extends Step{
	
	private String serviceURL;

	public TestHttpServices(String serviceURL) {
		System.out.println("Checking whether Service is UP...");
		this.serviceURL = serviceURL;
		// connect to the url and validate a return

		try {
			URL url = new URL(serviceURL);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(5000);	
			
			if (connection instanceof HttpURLConnection ) {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
							
				try{
					System.out.println("----------");
					System.out.println("Trying to connect: " +serviceURL );
					httpConnection.connect();	
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					System.out.println("The URL specified was unable to connect. Connection Timed out");
					return;
				}
				
				int response = httpConnection.getResponseCode();
				System.out.println("Response Code: " + response);
				// print header fields
				
				int n = 1;
				String key;
				while ((key = connection.getHeaderFieldKey(n)) != null) {
					String value = connection.getHeaderField(n);
					System.out.println(key + ": " + value);
					n++;
				}

				System.out.println("ContentEncoding: "
						+ connection.getContentEncoding());
				System.out.println("Date: " + connection.getDate());
				System.out.println("Expiration: "
						+ connection.getExpiration());
				System.out.println("LastModifed: "
						+ connection.getLastModified());
				System.out.println("----------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void runStep() throws Throwable {

	}
}

