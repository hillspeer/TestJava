import java.util.UUID;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrClient {

	public static void main(String[] args) throws Exception{

		String urlString = "http://localhost:8983/solr/VRM";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());

		final SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "2018-9-17T12:05:10Z");
		doc.addField("name", "<<>>");

		final UpdateResponse updateResponse = solr.add(doc);

		solr.commit();

		SolrQuery query = new SolrQuery();
		query.set("q", "price:599.99");
		QueryResponse response = solr.query(query);

		SolrDocumentList docList = response.getResults();

		System.out.println(docList);

	}

}