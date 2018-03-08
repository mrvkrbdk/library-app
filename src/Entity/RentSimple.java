package Entity;

public class RentSimple {
	private String Name;
	private String NameSurname;
	private String Date;
	public RentSimple(String name, String nameSurname, String date) {
		super();
		Name = name;
		NameSurname = nameSurname;
		Date = date;
	}
	public RentSimple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNameSurname() {
		return NameSurname;
	}
	public void setNameSurname(String nameSurname) {
		NameSurname = nameSurname;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	

}
