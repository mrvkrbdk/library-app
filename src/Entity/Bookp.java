package Entity;

public class Bookp {
	private int BookID;
	private String Name;
	private String Type;
	private String Writer;
	private String Definition;
	private int Active;
	
	public Bookp(int Book,String name,String type,String writer,String definition,int active)
	{
		this.BookID=Book;
		this.Name=name;
		this.Type=type;
		this.Writer=writer;
		this.Definition=definition;
		this.Active=active;
	}

	public int getBookID() {
		return BookID; 
	}
	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getDefinition() {
		return Definition;
	}

	public void setDefinition(String definition) {
		Definition = definition;
	}

	
	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public Bookp() {
		super();
		// TODO Auto-generated constructor stub
	}
}
