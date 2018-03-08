import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import Entity.BookMember;
import Entity.Bookp;
import Entity.Members;
import Model.BookMemberModel;
import Model.BookpModel;
import Model.MembersModel;

import org.eclipse.swt.widgets.Table;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class RentingFrame {

	protected Shell shlRenting;
	private Table table;
	private Table table_1;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private BookpModel bm=new BookpModel();
	private MembersModel mm=new MembersModel();
	private BookMemberModel bmm=new BookMemberModel();
	private Label label;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Text text;
	private Text text_1;
	private Label label_1;
	private DateTime dateTime;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RentingFrame window = new RentingFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
	
//	private void filcombo(){
//		combo.removeAll();
//		for(Bookp b:bm.FindAll())
//		{
//			
//			Combo combo = new Combo(shlRenting, SWT.DROP_DOWN);
//			combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//			combo.setItems(new String[] {b.getName()});
//			
//		}
//		
//	}
	
//	private void filcombo_1(){
//		for(Members m:mm.FindAll()){
//			combo_1 = new Combo(shlRenting, SWT.NONE);
//			combo_1.setItems(new String[]{m.getNameSurname()});
//		}
//		
//	}
	
	
	private void filtables(){
		table.removeAll();
		for(Bookp b:bm.FindAll2())
		{
			TableItem tableItem= new TableItem(table, SWT.NONE);
			tableItem.setText(new String[] {b.getName()});
		}
		
		
	}
	
	private void filtables_1(){
		table_1.removeAll();
		
		for(Members m:mm.FindAll()){
			TableItem tableItem_1= new TableItem(table_1, SWT.NONE);
			tableItem_1.setText(new String[]{m.getNameSurname()});
		}
		
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		//filcombo();
		//filcombo_1();
		filtables();
		filtables_1();
		shlRenting.open();
		shlRenting.layout();
		while (!shlRenting.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRenting = new Shell();
		shlRenting.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		shlRenting.setImage(SWTResourceManager.getImage(RentingFrame.class, "/ikons/Business-Statistics-icon.png"));
		shlRenting.setSize(803, 504);
		shlRenting.setText("Renting");
		
		table = new Table(shlRenting, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackground(SWTResourceManager.getColor(255, 182, 193));
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//booklist ten tbaloda seçileni getir
				TableItem[]row=table.getSelection();
				text.setText(String.valueOf(bm.FindBookID(row[0].getText())));
				
			}
		});
		table.setBounds(10, 56, 180, 349);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(172);
		tblclmnName.setText("Name");
		
		
		
		table_1 = new Table(shlRenting, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBackground(SWTResourceManager.getColor(255, 182, 193));
		table_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//member seçme
				TableItem[]row=table_1.getSelection();
				text_1.setText(String.valueOf(mm.FindMemberId(row[0].getText())));
				
			}
		});
		table_1.setBounds(250, 56, 200, 349);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNamesurname = new TableColumn(table_1, SWT.NONE);
		tblclmnNamesurname.setWidth(180);
		tblclmnNamesurname.setText("NameSurname");
		
		lblNewLabel = new Label(shlRenting, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel.setBounds(24, 26, 70, 20);
		lblNewLabel.setText("Book");
		
		lblNewLabel_1 = new Label(shlRenting, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel_1.setBounds(265, 26, 70, 20);
		lblNewLabel_1.setText("Member");
		
		label = new Label(shlRenting, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label.setImage(SWTResourceManager.getImage(RentingFrame.class, "/ikons/Arrows-Right-icon.png"));
		label.setBounds(185, 212, 70, 64);
		
		lblNewLabel_2 = new Label(shlRenting, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(463, 92, 132, 20);
		lblNewLabel_2.setText("Book Name:");
		
		lblNewLabel_3 = new Label(shlRenting, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(463, 148, 132, 20);
		lblNewLabel_3.setText("Member Name:");
		
		lblNewLabel_4 = new Label(shlRenting, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(463, 208, 132, 20);
		lblNewLabel_4.setText("Rent Date:");
		
		text = new Text(shlRenting, SWT.BORDER);
		text.setEnabled(false);
		text.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		text.setBounds(601, 85, 161, 36);
		
		text_1 = new Text(shlRenting, SWT.BORDER);
		text_1.setEnabled(false);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		text_1.setBounds(601, 141, 161, 36);
		
		 dateTime = new DateTime(shlRenting, SWT.BORDER | SWT.LONG);
		dateTime.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		dateTime.setBounds(601, 204, 161, 28);
		
		Button btnNewButton = new Button(shlRenting, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BookMember r=new BookMember();
				r.setBookID(Integer.parseInt(text.getText()));
				r.setMemberID(Integer.parseInt(text_1.getText()));
				r.setRentDate(""+String.valueOf(dateTime.getDay())+"."+String.valueOf(dateTime.getMonth())+"."+String.valueOf(dateTime.getYear()));           
				if(bmm.createRent(r))
				{
					label_1.setText("Succesful to renting !");
					
				}
				else{
					label_1.setText("unsuccesful to renting book!");
				}
				
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnNewButton.setBounds(561, 298, 90, 43);
		btnNewButton.setText("RENT");
		
		label_1 = new Label(shlRenting, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		label_1.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label_1.setBounds(505, 368, 241, 36);

	}
}
