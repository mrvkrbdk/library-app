import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import Entity.RentSimple;
import Model.BookMemberModel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RentListFrame {

	protected Shell shlRentList;
	private Table table;
	private BookMemberModel bm=new BookMemberModel();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RentListFrame window = new RentListFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	private void FillData(){
		table.removeAll();
		for (RentSimple r:bm.FindRent()) 
		{
			TableItem tableItem= new TableItem(table, SWT.NONE);
		tableItem.setText(new String[]{r.getName(),r.getNameSurname(),r.getDate()} );
		}
		
		
		
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		FillData();
		shlRentList.open();
		shlRentList.layout();
		while (!shlRentList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRentList = new Shell();
		shlRentList.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		shlRentList.setImage(SWTResourceManager.getImage(RentListFrame.class, "/ikons/Business-Statistics-icon.png"));
		shlRentList.setSize(676, 421);
		shlRentList.setText("Rent List");
		
		table = new Table(shlRentList, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[]row=table.getSelection();
				String id=row[0].getText();
				RentSimple r=bm.Find(id);
				bm.del(id);
				bm.delete(r);
				FillData();
				
				
			}
		});
		table.setBackground(SWTResourceManager.getColor(60, 179, 113));
		table.setBounds(10, 21, 623, 329);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnBookname = new TableColumn(table, SWT.NONE);
		tblclmnBookname.setWidth(246);
		tblclmnBookname.setText("Name");
		
		TableColumn tblclmnMemberName = new TableColumn(table, SWT.NONE);
		tblclmnMemberName.setWidth(249);
		tblclmnMemberName.setText("MemberID");
		
		TableColumn tblclmnRentdate = new TableColumn(table, SWT.NONE);
		tblclmnRentdate.setWidth(136);
		tblclmnRentdate.setText("RentDate");

	}

}
