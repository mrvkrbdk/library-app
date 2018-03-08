import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.Random;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import Entity.Members;
import Model.MembersModel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MemberSettingsFrame {

	protected Shell shell;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private MembersModel mm=new MembersModel();
	private Random r;
	private Combo combo;

	/**
	 * Launch the application.
	 * @param args
	 */
	
	
	
	private void FillData(){
		table.removeAll();
		for(Members m:mm.FindAll())
		{
			TableItem tableItem= new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{String.valueOf(m.getMemberID()),m.getNameSurname(),String.valueOf(m.getTel()),m.getAdress(),String.valueOf(m.getActive())});
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			MemberSettingsFrame window = new MemberSettingsFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	
private void ClearCells(){
		
		text.setText(String.valueOf(r.nextInt(10000)));
		text_1.setText("");
		text_2.setText("");
		text_3.setText("");
		combo.setText("");
		
	}
	
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		FillData();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		shell.setSize(971, 625);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//selectedrow
				TableItem[]row=table.getSelection();
				int id=Integer.parseInt(row[0].getText());
				Members b=mm.Find(id);
				text.setText(String.valueOf(b.getMemberID()));
				text_1.setText(b.getNameSurname());
				text_2.setText(String.valueOf(b.getTel()));
				text_3.setText(b.getAdress());
				combo.setText(String.valueOf(b.getActive()));
			}
		});
		table.setBackground(SWTResourceManager.getColor(119, 136, 153));
		table.setBounds(10, 23, 539, 520);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMemberd = new TableColumn(table, SWT.NONE);
		tblclmnMemberd.setWidth(100);
		tblclmnMemberd.setText("MemberID");
		
		TableColumn tblclmnNamesurname = new TableColumn(table, SWT.NONE);
		tblclmnNamesurname.setWidth(142);
		tblclmnNamesurname.setText("NameSurname");
		
		TableColumn tblclmnTel = new TableColumn(table, SWT.NONE);
		tblclmnTel.setWidth(100);
		tblclmnTel.setText("Tel");
		
		TableColumn tblclmnAdress = new TableColumn(table, SWT.NONE);
		tblclmnAdress.setWidth(202);
		tblclmnAdress.setText("Adress");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(104);
		tblclmnNewColumn.setText("Active");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel.setBounds(586, 122, 119, 20);
		lblNewLabel.setText("ID:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_1.setBounds(586, 170, 119, 20);
		lblNewLabel_1.setText("Name Surname:");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_2.setBounds(586, 226, 119, 20);
		lblNewLabel_2.setText("Telephone:");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_3.setBounds(586, 285, 119, 20);
		lblNewLabel_3.setText("Adress:");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_4.setBounds(586, 351, 119, 20);
		lblNewLabel_4.setText("Active:");
		
		r=new Random();
		int rId=r.nextInt(10000);
		
		text = new Text(shell, SWT.BORDER);
		text.setEnabled(false);
		text.setText(String.valueOf(rId));
		text.setBounds(767, 122, 78, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(765, 173, 163, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(765, 229, 163, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(765, 282, 163, 26);
		
	    combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"0", "1"});
		combo.setBounds(767, 351, 97, 28);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//update
				Members b=new Members();
				b.setNameSurname(text_1.getText());
				b.setTel(Integer.parseInt(text_2.getText()));
				b.setAdress(text_3.getText());
				b.setActive(Integer.parseInt(combo.getText()));
				b.setMemberID(Integer.parseInt(text.getText()));
				if(mm.edit(b))
				{
					JOptionPane.showMessageDialog(null,"succesful to editing member!");
					FillData();
					ClearCells();
				}
				else{
					JOptionPane.showMessageDialog(null,"unsuccesful to editing member!");
				}
				
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(MemberSettingsFrame.class, "/ikons/User-Interface-Available-Updates-icon.png"));
		btnNewButton.setBounds(586, 434, 90, 49);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				TableItem[]row=table.getSelection();
				int id=Integer.parseInt(row[0].getText());
				Members b=mm.Find(id);
				mm.delete(b);
				FillData();
				ClearCells();
				
			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(MemberSettingsFrame.class, "/ikons/delete-icon.png"));
		btnNewButton_1.setBounds(716, 434, 90, 49);
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//ekleme
				Members b=new Members();
				b.setMemberID(Integer.parseInt(text.getText()));
				b.setNameSurname(text_1.getText());
				b.setTel(Integer.parseInt(text_2.getText()));
				b.setAdress(text_3.getText());
				b.setActive(Integer.parseInt(combo.getText()));
				if(mm.create(b))
				{
					JOptionPane.showMessageDialog(null,"succesful to adding member!");
					FillData();
					ClearCells();
				}
				else{
					JOptionPane.showMessageDialog(null,"unsuccesful to adding member!");
				}
				
				
			}
		});
		btnNewButton_2.setImage(SWTResourceManager.getImage(MemberSettingsFrame.class, "/ikons/Arrow-Right-icon.png"));
		btnNewButton_2.setBounds(838, 434, 90, 49);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_5.setImage(SWTResourceManager.getImage(MemberSettingsFrame.class, "/ikons/Misc-User-icon (1).png"));
		lblNewLabel_5.setBounds(851, 66, 97, 82);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel_6.setBounds(663, 59, 182, 28);
		lblNewLabel_6.setText("Person Information");

	}

}
