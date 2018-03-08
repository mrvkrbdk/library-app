package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.Bookp;



public class BookpModel {

public  List<Bookp>FindAll(){
		
		try{
			    List<Bookp> listBooks=new ArrayList<Bookp>();
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select * from bookp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Bookp b=new Bookp(); //ýnherýtance
				b.setBookID(rs.getInt("BookID")); //get ile return yapýyoruz
				b.setName(rs.getString("Name"));  // set ile settings yapýyoruz
				b.setType(rs.getString("Type"));
				b.setWriter(rs.getString("Writer"));
				b.setDefinition(rs.getString("Definition"));
				b.setActive(rs.getInt("Active"));
				listBooks.add(b);
			}
			return listBooks;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
		
	}

public  List<Bookp>FindAll2(){
	
	try{
		    List<Bookp> listBooks=new ArrayList<Bookp>();
		PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select * from bookp where Active=0");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Bookp b=new Bookp();
			b.setBookID(rs.getInt("BookID"));
			b.setName(rs.getString("Name"));
			b.setType(rs.getString("Type"));
			b.setWriter(rs.getString("Writer"));
			b.setDefinition(rs.getString("Definition"));
			b.setActive(rs.getInt("Active"));
			listBooks.add(b);
		}
		return listBooks;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
		return null;
	}
	
	
}

public boolean create(Bookp b){
	
	try{
		PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("insert into  bookp values(?,?,?,?,?,?)");
		ps.setInt(1,b.getBookID());
		ps.setString(2,b.getName());
		ps.setString(3,b.getType());
		ps.setString(4,b.getWriter());
		ps.setString(5,b.getDefinition());
		ps.setInt(6,b.getActive());
		
		return ps.executeUpdate()>0;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
		return false;
	}
	
	
}


public Bookp Find(int id){
	
	try{
		List<Bookp> listBooks=new ArrayList<Bookp>();
		PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select * from bookp where BookID=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		Bookp b=new Bookp();
		while(rs.next()){
			b.setBookID(rs.getInt("BookID"));
			b.setName(rs.getString("Name"));
			b.setType(rs.getString("Type"));
			b.setWriter(rs.getString("Writer"));
			b.setDefinition(rs.getString("Definition"));
			b.setActive(rs.getInt("Active"));
			listBooks.add(b);
		}
		return b;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
		return null;
	}
	
	
}

public int FindBookID(String bookname){
	
	try{
		List<Bookp> listBooks=new ArrayList<Bookp>();
		PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select BookID from bookp where Name=?");
		ps.setString(1,bookname);
		ResultSet rs=ps.executeQuery();
		Bookp b=new Bookp();
		while(rs.next()){
			b.setBookID(rs.getInt("BookID"));
			listBooks.add(b);
		}
		return b.getBookID();
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
		return 0;
	}
	
	
}
public boolean edit(Bookp b){
	
	try{
		PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("update bookp SET Name='"+b.getName()+"',Type='"+b.getType()+"',Writer='"+b.getWriter()+"',Definition='"+b.getDefinition()+"',Active='"+b.getActive()+"' where BookID='"+b.getBookID()+"'");
//		ps.setString(0,b.getName());
//		ps.setString(1,b.getType());
//		ps.setString(2,b.getWriter());
//		ps.setString(3,b.getDefinition());
//		ps.setBoolean(4,b.isActive());
//		ps.setInt(5,b.getBookID());
		return ps.executeUpdate()>0;
	}
	catch(Exception e){
		//JOptionPane.showMessageDialog(null,e);
		System.out.print(e);
		return false;
	}
	
	
}



public boolean delete(Bookp b){

try{
	PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("delete from bookp where BookID='"+b.getBookID()+"'");
	//ps.setInt(1,b.getBookID());
	return ps.executeUpdate()>0;
}
catch(Exception e){
	JOptionPane.showMessageDialog(null,e);
	return false;
}


}






}
