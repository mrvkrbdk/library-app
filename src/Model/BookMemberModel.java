package Model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.BookMember;
import Entity.RentSimple;

public class BookMemberModel {
	
	
	//storedproc
	public List<BookMember>FindAll(){
		try {
			BookMember bm=new BookMember();
			List<BookMember> listbookmember=new ArrayList<BookMember>();
			CallableStatement ps=ConnectionDB.ConnDb().prepareCall("select bookp.Name,members.NameSurname,RentDate from (bookmemberr inner join bookp  on bookmemberr.BookID=bookp.BookID) inner join members on bookmemberr.MemberID=members.MemberID ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				bm.setBookID(rs.getInt("Name"));
				bm.setMemberID(rs.getInt("NameSurname"));
				bm.setRentDate(rs.getString("RentDate"));
				listbookmember.add(bm);
			}
			return listbookmember;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	public List<RentSimple>FindAl(){
		try {
			List<RentSimple> listbookmember=new ArrayList<RentSimple>();
			CallableStatement ps=ConnectionDB.ConnDb().prepareCall("select * from rent");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				RentSimple bm=new RentSimple();
				bm.setName(rs.getString("Name"));
				bm.setNameSurname(rs.getString("NameSurname"));
				bm.setDate(rs.getString("RentDate"));
				listbookmember.add(bm);
			}
			return listbookmember;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	
	public List<RentSimple>FindRent(){
		try {
			List<RentSimple> listbookmember=new ArrayList<RentSimple>();
			CallableStatement ps=ConnectionDB.ConnDb().prepareCall("{call books_from_members()};");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				RentSimple bm=new RentSimple();
				bm.setName(rs.getString("Name"));
				bm.setNameSurname(rs.getString("NameSurname"));
				bm.setDate(rs.getString("RentDate"));
				listbookmember.add(bm);
			}
			return listbookmember;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	
	
	public boolean createRent(BookMember r){
		try {
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("INSERT INTO bookmemberr (`BookID`, `MemberID`, `RentDate`) VALUES (?,?,?)");
			ps.setInt(1,r.getBookID());
			ps.setInt(2,r.getMemberID());
			ps.setString(3,r.getRentDate());
			
			return ps.executeUpdate()>0;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return false;
		}
	}
	public RentSimple Find(String id){
		
		try{
			List<RentSimple> listBooks=new ArrayList<RentSimple>();
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select bookp.Name,members.NameSurname,RentDate from (bookmemberr inner join bookp  on bookmemberr.BookID=bookp.BookID) inner join members on bookmemberr.MemberID=members.MemberID where bookp.Name='"+id+"'");
			//ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			RentSimple b=new RentSimple();
			while(rs.next()){
				b.setName(rs.getString("Name"));
				b.setNameSurname(rs.getString("NameSurname"));
				b.setDate(rs.getString("RentDate"));
				listBooks.add(b);
			}
			return b;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
		
	}

	public boolean delete(RentSimple r){
		
		try {
			//ConnectionDB.ConnDb().prepareStatement("SET SQL_SAFE_UPDATES=0");
			//ConnectionDB.ConnDb().prepareStatement("update bookp set Active=0 where Name='"+r.getName()+"'");
			
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("delete from bookmemberr where BookID=(select BookID from bookp where Name='"+r.getName()+"')");
			
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}
	
public boolean del(String id){
		
		try {
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("update bookp set Active=0 where Name='"+id+"'");
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}



}
