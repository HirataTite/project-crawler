import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class GmailWalker {

	public void openSession(String login, String pass) {

		Properties props = new Properties();

		try {
			props.load(new FileInputStream(
					new File("/home/patrickhirata/Documents/project/Crawler/Conf/gmail.properties")));
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", login, pass);
			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			int messageCount = inbox.getMessageCount();

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void crawler() {

	}

}
