package Entity;

public class Members {
	
	private int MemberID;
	private String NameSurname;
	private String Adress;
	private int Tel;
	private int Active;
	
	
	
	public Members(int memberID, String nameSurname, String adress, int tel, int active) {
		super();
		MemberID = memberID;
		NameSurname = nameSurname;
		Adress = adress;
		Tel = tel;
		Active = active;
	}

	public int getMemberID() {
		return MemberID;
	}

	public void setMemberID(int memberID) {
		MemberID = memberID;
	}

	public String getNameSurname() {
		return NameSurname;
	}

	public void setNameSurname(String nameSurname) {
		NameSurname = nameSurname;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public int getTel() {
		return Tel;
	}

	public void setTel(int tel) {
		Tel = tel;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
