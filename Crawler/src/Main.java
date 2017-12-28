
public class Main {

	public static void main(String[] args) throws Exception {
		
		if (args[0].equals("file")) {
			String path = args[1];
			FileWalker fw = new FileWalker();
			fw.walk(path);
		} else if (args[0].equals("web")) {
			WebWalker ww = new WebWalker();
			String url = args[1];
			String depth = args[2];
			ww.getPageLinks(url, depth);
		} else if(args[0].equals("gmail")){
			GmailWalker gw = new GmailWalker();
			String login = args[1];
			String pass = args[2];
			gw.crawler_mail(login, pass);
		}

	}
}
