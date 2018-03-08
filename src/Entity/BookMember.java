package Entity;

public class BookMember {
 private int BookID;
 private int MemberID;
 private String RentDate;
public BookMember(int bookID, int memberID, String rentDate) {
	super();
	BookID = bookID;
	MemberID = memberID;
	RentDate = rentDate;
}
public int getBookID() {
	return BookID;
}
public void setBookID(int bookID) {
	BookID = bookID;
}
public int getMemberID() {
	return MemberID;
}
public void setMemberID(int memberID) {
	MemberID = memberID;
}
public String getRentDate() {
	return RentDate;
}
public void setRentDate(String rentDate) {
	RentDate = rentDate;
}
public BookMember() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
 
}
