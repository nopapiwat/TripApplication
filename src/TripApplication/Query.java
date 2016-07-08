package TripApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.BigqueryScopes;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;

public class Query {

	private static GetQueryResultsResponse res;
	
	private static Bigquery createAuthorizedClient() throws IOException {
		// Create the credential
		HttpTransport transport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();
		GoogleCredential credential = GoogleCredential.getApplicationDefault(transport, jsonFactory);

		if (credential.createScopedRequired()) {
			credential = credential.createScoped(BigqueryScopes.all());
		}

		return new Bigquery.Builder(transport, jsonFactory, credential).setApplicationName("Bigquery Samples").build();
	}

	private static GetQueryResultsResponse executeQuery(String querySql, Bigquery bigquery, String projectId)
			throws IOException {
		QueryResponse query = bigquery.jobs().query(projectId, new QueryRequest().setQuery(querySql)).execute();

		// Execute it
		GetQueryResultsResponse queryResult = bigquery.jobs()
				.getQueryResults(query.getJobReference().getProjectId(), query.getJobReference().getJobId()).execute();

		return queryResult;
	}

	public List<TableCell> printResults() throws IOException {
		TableSchema schema = res.getSchema();
		List<TableRow> rows = res.getRows();
		List<TableCell> lc = new ArrayList<TableCell>();
		for (TableRow row : rows) {
			TableCell c = new TableCell();
	    	for(int i = 0; i < schema.getFields().size(); i++){	    		
	    		c.put(schema.getFields().get(i).getName(),row.getF().get(i).getV());
	    	}
	    	lc.add(c);
	    }		
		return lc;
	}

	public Query() throws IOException {

		String projectId = "cobalt-carver-136223";
		Bigquery bigquery = createAuthorizedClient();

		res = executeQuery(
				"SELECT month,station,count FROM ("
    		+ " SELECT STRFTIME_UTC_USEC(date,\"%m/%Y\") as month,Start_Station as station,count(Start_Station ) as count,RANK() OVER (PARTITION BY month ORDER BY count DESC) rank"
    		+ " FROM(SELECT Timestamp(NTH(3,SPLIT(First(SPLIT(Start_Date,\" \")),\"/\"))+\"-\"+FIRST(SPLIT(First(SPLIT(Start_Date,\" \")),\"/\")) +\"-\"+ NTH(2,SPLIT(First(SPLIT(Start_Date,\" \")),\"/\"))) WITHIN RECORD date"
    				+ " ,Start_Station FROM [trip_data.201402])"
    				+ " group by month,station)"
    				+ " WHERE rank=1 order by month",bigquery, projectId);		
	}
	
}
