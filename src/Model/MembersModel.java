package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.Members;
public class MembersModel {

	public List<Members>FindAll(){
       try {
    	   List<Members> listMembers=new ArrayList<Members>();
    	   PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select * from members");
    	   ResultSet rs=ps.executeQuery();
    	   while(rs.next()){
    		   Members m=new Members();
    		   m.setMemberID(rs.getInt("MemberID"));
    		   m.setNameSurname(rs.getString("NameSurname"));
    		   m.setTel(rs.getInt("Tel"));
    		   m.setAdress(rs.getString("Adress"));
    		   m.setActive(rs.getInt("Active"));
    		   listMembers.add(m);
    	   }
    	   return listMembers;
    	   
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null,e); 
		return null;
	}
	}
	
	
	public boolean create(Members b){
		
		try{
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("insert into  members values(?,?,?,?,?)");
			ps.setInt(1,b.getMemberID());
			ps.setString(2,b.getNameSurname());
			ps.setInt(3,b.getTel());
			ps.setString(4,b.getAdress());
			ps.setInt(5,b.getActive());
			
			return ps.executeUpdate()>0;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return false;
		}
		
		
	}
	
	
	
	public Members Find(int id){
		
		try{
			List<Members> listMembers=new ArrayList<Members>();
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select * from members where MemberID=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			Members b=new Members();
			while(rs.next()){
				b.setMemberID(rs.getInt("MemberID"));
				b.setNameSurname(rs.getString("NameSurname"));
				b.setTel(rs.getInt("Tel"));
				b.setAdress(rs.getString("Adress"));
				b.setActive(rs.getInt("Active"));
				listMembers.add(b);
			}
			return b;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
		
	}
	
	
public int FindMemberId(String name){
		
		try{
			List<Members> listMembers=new ArrayList<Members>();
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("select MemberID from members where NameSurname=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			Members b=new Members();
			while(rs.next()){
				b.setMemberID(rs.getInt("MemberID"));
				listMembers.add(b);
			}
			return b.getMemberID();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return 0;
		}
		
		
	}
	
	
	public boolean edit(Members b){
		
		try{
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("update members SET NameSurname='"+b.getNameSurname()+"',Tel='"+b.getTel()+"',Adress='"+b.getAdress()+"',Active='"+b.getActive()+"' where MemberID='"+b.getMemberID()+"'");
//			ps.setString(0,b.getName());
//			ps.setString(1,b.getType());
//			ps.setString(2,b.getWriter());
//			ps.setString(3,b.getDefinition());
//			ps.setBoolean(4,b.isActive());
//			ps.setInt(5,b.getBookID());
			return ps.executeUpdate()>0;
		}
		catch(Exception e){
			//JOptionPane.showMessageDialog(null,e);
			System.out.print(e);
			return false;
		}
		
		
	}
	
	public boolean delete(Members b){

		try{
			PreparedStatement ps=ConnectionDB.ConnDb().prepareStatement("delete from members where MemberID='"+b.getMemberID()+"'");
			//ps.setInt(1,b.getBookID());
			return ps.executeUpdate()>0;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return false;
		}


		}
	
	
	
	
	
	
}
