
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebWalker {

	private HashSet<String> links = new HashSet<String>();

	public void getPageLinks(String... args) {

		String URL = args[0];
		String depth = args[1];
		int tmp_depth = Integer.parseInt(depth);

		if (!links.contains(URL) && tmp_depth > 0) {
			System.out.println(">> Profundidade: " + depth + "(" + URL + ")");

			try {
				links.add(URL);
				Document document = Jsoup.connect(URL).get();
				Elements linksOnPage = document.select("a[href]");

				tmp_depth++;
				for (Element page : linksOnPage) {
					getPageLinks(page.attr("abs:href"), depth);
				}

			} catch (IOException e) {
				System.err.println("Erro: " + e.getMessage());
			}
		}

	}
}
