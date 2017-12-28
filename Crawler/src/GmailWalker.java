import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class GmailWalker {

	
	public void crawler_mail(String ... args) {

		Properties props = new Properties();
		String login = args[0];
		String pass = args[1];
		
		try {
			props.load(new FileInputStream(
					new File("C:\\Users\\Patrick\\Documents\\project\\project\\Crawler\\conf\\gmail.properties")));
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", login, pass);
			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			
			Message[] messages = inbox.getMessages();
			
			for(Message message: messages) {
				System.out.println("Titulo: " + message.getSubject());
				System.out.println("Email: " + message.getContent());
			}
			
			inbox.close(true);
			store.close();
			
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
