package gov.nih.nci.cagrid.rproteomics.client;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cql.CQLQueryType;
import gov.nih.nci.cagrid.rproteomics.common.RPDataI;
import gov.nih.nci.cagrid.rproteomics.stubs.RPDataPortType;
import gov.nih.nci.cagrid.rproteomics.stubs.service.RPDataServiceAddressingLocator;

import java.io.StringWriter;
import java.rmi.RemoteException;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axis.message.MessageElement;
import org.apache.axis.message.addressing.Address;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.globus.gsi.GlobusCredential;


/**
 * This class is autogenerated, DO NOT EDIT.
 * 
 * @created by Introduce Toolkit version 1.0
 */
public class RPDataClient implements RPDataI {

	private RPDataServiceAddressingLocator locator;
	private GlobusCredential proxy;
	private String url;


	public RPDataClient(String url) {
		this(url, null);
	}


	public RPDataClient(String url, GlobusCredential proxy) {
		this.proxy = proxy;
		this.url = url;
	}


	private RPDataPortType getPortType() {
		try {
			RPDataServiceAddressingLocator locator = new RPDataServiceAddressingLocator();
			EndpointReferenceType endpoint = new EndpointReferenceType();
			endpoint.setAddress(new Address(url));
			RPDataPortType port = locator.getRPDataPortTypePort(endpoint);
			return port;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Get the command-line options
	 */
	public static Options getOptions()
	{
		Option gsh = OptionBuilder.withArgName("gsh")
			.hasArg()
			.isRequired(false)
			.withDescription("grid service handle")
			.create("gsh");

		Option query = OptionBuilder.withArgName("query")
			.hasArg()
			.isRequired(false)
			.withDescription("query file")
			.create("query");

		Option printXml = OptionBuilder.withArgName("printXml")
			.isRequired(false)
			.withDescription("print xml results to stdout")
			.create("printXml");

		// add options
		Options options = new Options();

		options.addOption(gsh);
		options.addOption(query);
		options.addOption(printXml);

		return options;
	}

	public static void main(String[] args) 
		throws Exception
	{
//		args = new String[] {
//			//"-gsh", "http://ccis1716.duhs.duke.edu/wsrf/services/cagrid/RPData",
//			"-gsh", "http://localhost:8080/wsrf/services/cagrid/RPData",
//			//"-gsh", "http://140.254.80.99:8080/wsrf/services/cagrid/RPData",
//			"-query", "queries\\scanFeatures_query3.xml",
//			//"-printXml"
//		};
		
        Options options = getOptions();
        CommandLine cmd = null;
		try {			
			cmd = new BasicParser().parse(options, args);
		} catch(ParseException e) {						
			System.out.println("Error parsing arguments: " + e.getMessage());
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("RPDataClient", options);
			System.exit(-1);
			return;
		}
		RPDataClient client = new RPDataClient(cmd.getOptionValue("gsh"));

		CQLQueryType query = (CQLQueryType) Utils.deserializeDocument(cmd.getOptionValue("query"), CQLQueryType.class);

		gov.nih.nci.cagrid.cql.CQLQueryResultsType results = client.query(query);
		gov.nih.nci.cagrid.cql.CQLQueryResultType[] resultsArray = results.getCQLQueryResult();
		if (resultsArray != null) {
			System.out.println("Got " + resultsArray.length + " result(s)");
			
			for (int i = 0; i < resultsArray.length; i++) {
				gov.nih.nci.cagrid.cql.CQLQueryResultType result = resultsArray[i];

				// Deserialize and print out each element........
				MessageElement[] msgs = result.get_any();
				for (int j = 0; j < msgs.length; j++) {
					StringWriter output = new StringWriter();
					TransformerFactory.newInstance().newTransformer().transform(new DOMSource(msgs[j]), new StreamResult(output));
					if (cmd.hasOption("printXml")) System.out.println(output.toString());
				}
			}
		}
	}

    public gov.nih.nci.cagrid.cql.CQLQueryResultsType query(gov.nih.nci.cagrid.cql.CQLQueryType query) 
    	throws RemoteException, gov.nih.nci.cagrid.rproteomics.stubs.MalformedQueryException 
    {
		RPDataPortType port = this.getPortType();
		org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub) port;

        gov.nih.nci.cagrid.rproteomics.stubs.Query params = new gov.nih.nci.cagrid.rproteomics.stubs.Query();
        params.setQuery(query);
        gov.nih.nci.cagrid.rproteomics.stubs.QueryResponse boxedResult = port.query(params);
        return boxedResult.getResponse();
	}
}
