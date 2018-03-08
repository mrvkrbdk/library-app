import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import Entity.Members;
import Model.MembersModel;

public class MemberListFrame {

	protected Shell shlMemberList;
	private Table table;
    private MembersModel mm=new MembersModel();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MemberListFrame window = new MemberListFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	//fill the table methods
	private void FillData(){
		table.removeAll();
		for(Members m:mm.FindAll())
		{
			TableItem tableItem= new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{String.valueOf(m.getMemberID()),m.getNameSurname(),String.valueOf(m.getTel()),m.getAdress(),String.valueOf(m.getActive())});
			
		}
		
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		FillData();
		shlMemberList.open();
		shlMemberList.layout();
		while (!shlMemberList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMemberList = new Shell();
		shlMemberList.setImage(SWTResourceManager.getImage(MemberListFrame.class, "/ikons/Misc-User-icon.png"));
		shlMemberList.setSize(839, 542);
		shlMemberList.setText("Member List");
		
		table = new Table(shlMemberList, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		table.setBackground(SWTResourceManager.getColor(72, 61, 139));
		table.setBounds(10, 10, 797, 477);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMemberd = new TableColumn(table, SWT.NONE);
		tblclmnMemberd.setWidth(83);
		tblclmnMemberd.setText("MemberID");
		
		TableColumn tblclmnNamesurname = new TableColumn(table, SWT.NONE);
		tblclmnNamesurname.setWidth(192);
		tblclmnNamesurname.setText("NameSurname");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(159);
		tblclmnNewColumn.setText("Tel");
		
		TableColumn tblclmnAdress = new TableColumn(table, SWT.NONE);
		tblclmnAdress.setWidth(271);
		tblclmnAdress.setText("Adress");
		
		TableColumn tblclmnActive = new TableColumn(table, SWT.NONE);
		tblclmnActive.setWidth(89);
		tblclmnActive.setText("Active");

	}

}
