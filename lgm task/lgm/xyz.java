
import java.util.*;

  class Document {
    private int id;
    private String content;

    public Document(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

class SimpleSearchEngine {
    private Map<String, List<Document>> index;

    public SimpleSearchEngine() {
        this.index = new HashMap<>();
    }

    public void addDocument(Document document) {
        String[] words = document.getContent().split("\\s+");

        for (String word : words) {
            word = word.toLowerCase();
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(document);
        }
    }

    public List<Document> search(String query) {
        query = query.toLowerCase();
        if (index.containsKey(query)) {
            return index.get(query);
        } else {
            return Collections.emptyList();
        }
    }
}

public class xyz {
    public static void main(String[] args) {
        SimpleSearchEngine searchEngine = new SimpleSearchEngine();

        // Create some sample documents
        Document doc1 = new Document(1, "This is a sample document about Java programming.");
        Document doc2 = new Document(2, "Java is a popular programming language.");
        Document doc3 = new Document(3, "Searching in Java is fun.");

        // Add documents to the search engine
        searchEngine.addDocument(doc1);
        searchEngine.addDocument(doc2);
        searchEngine.addDocument(doc3);

        // Search for documents containing specific keywords
        String query = "Java";
        List<Document> results = searchEngine.search(query);

        if (!results.isEmpty()) {
            System.out.println("Search results for query '" + query + "':");
            for (Document result : results) {
                System.out.println("Document " + result.getId() + ": " + result.getContent());
            }
        } else {
            System.out.println("No documents found for query '" + query + "'.");
        }
    }
}
