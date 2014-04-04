import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		// on startup

		Node node = nodeBuilder().clusterName("test1").client(true).node();

		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "test1").build();
		TransportClient client = new TransportClient(settings);
		client.addTransportAddress(new InetSocketTransportAddress("127.0.0.1",
				9300));

		// on shutdown
		node.close();
	}

	public static Map<String, Object> putJsonDocument(String title,
			String content, Date postDate, String[] tags, String author) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();

		jsonDocument.put("title", title);
		jsonDocument.put("conten", content);
		jsonDocument.put("postDate", postDate);
		jsonDocument.put("tags", tags);
		jsonDocument.put("author", author);

		return jsonDocument;
	}
}
