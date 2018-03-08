import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.Random;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import Entity.Bookp;
import Model.BookpModel;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BookSettingsFrame {

	protected Shell shlBookSSettings;
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Combo combo;
	private Combo combo_1;
	private BookpModel bm=new BookpModel();
	private Random r;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BookSettingsFrame window = new BookSettingsFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	/*
	 * bm clasýnda db verilerini aldýk listbooks listesiyle döndürdük bookp sýnýfýnda kalýtým ile 
	 * view tarafýna yani buraya metotla alýpp tek tek tablo satýrlarýna ayýrdýk
	 */
	
	private void FillData(){
		table.removeAll();
		for(Bookp b:bm.FindAll())
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {String.valueOf(b.getBookID()),b.getName(),b.getType(),b.getWriter(),b.getDefinition(),String.valueOf(b.getActive())});
		}
		
	}
	
	private void ClearCells(){
		
		text.setText("");
		text_1.setText("");
		text_2.setText("");
		text_3.setText(String.valueOf(r.nextInt(10000)));
		combo.setText("");
		combo_1.setText("");
		
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		FillData();
		shlBookSSettings.open();
		shlBookSSettings.layout();
		while (!shlBookSSettings.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBookSSettings = new Shell();
		shlBookSSettings.setImage(SWTResourceManager.getImage(BookSettingsFrame.class, "/ikons/Pencil-icon.png"));
		shlBookSSettings.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		shlBookSSettings.setSize(1050, 576);
		shlBookSSettings.setText("Book s Settings");
		
		table = new Table(shlBookSSettings, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			//WHEN SELECT ROW ITS GOING TO FILL TEXTBOX'S
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[]row=table.getSelection();
				int id=Integer.parseInt(row[0].getText());  //secili satýrýn ýdsini aldýk
				Bookp b=bm.Find(id);                       //ýd yi metoda yonlendirip query baþlattýk
				text_3.setText(String.valueOf(b.getBookID()));
				text.setText(b.getName());
				combo.setText(b.getType());
				text_1.setText(b.getWriter());
				text_2.setText(b.getDefinition());
				combo_1.setText(String.valueOf(b.getActive()));
				
			}
		});
		table.setBackground(SWTResourceManager.getColor(255, 140, 0));
		table.setBounds(25, 24, 523, 467);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnBookd = new TableColumn(table, SWT.NONE);
		tblclmnBookd.setWidth(72);
		tblclmnBookd.setText("BookID");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnType = new TableColumn(table, SWT.NONE);
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");
		
		TableColumn tblclmnWriter = new TableColumn(table, SWT.NONE);
		tblclmnWriter.setWidth(100);
		tblclmnWriter.setText("Writer");
		
		TableColumn tblclmnDefinition = new TableColumn(table, SWT.NONE);
		tblclmnDefinition.setWidth(207);
		tblclmnDefinition.setText("Definition");
		
		TableColumn tblclmnActive = new TableColumn(table, SWT.NONE);
		tblclmnActive.setWidth(89);
		tblclmnActive.setText("Active");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");
		
		Label lblNewLabel = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(623, 158, 94, 20);
		lblNewLabel.setText("Book Name:");
		
		Label lblNewLabel_1 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel_1.setBounds(623, 200, 94, 20);
		lblNewLabel_1.setText("Type :");
		
		Label lblNewLabel_2 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel_2.setBounds(623, 251, 94, 20);
		lblNewLabel_2.setText("Writer :");
		
		Label lblNewLabel_3 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel_3.setBounds(623, 305, 94, 20);
		lblNewLabel_3.setText("Definition :");
		
		Label lblNewLabel_4 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		lblNewLabel_4.setBounds(623, 364, 94, 20);
		lblNewLabel_4.setText("Active :");
		
		text = new Text(shlBookSSettings, SWT.BORDER);
		text.setBounds(756, 157, 193, 26);
		
		text_1 = new Text(shlBookSSettings, SWT.BORDER);
		text_1.setBounds(756, 250, 193, 26);
		
		 combo = new Combo(shlBookSSettings, SWT.NONE);
		combo.setItems(new String[] {"Science fiction", "Drama", "Action and Adventure", "Romance", "Mystery", "Horror", "Health", "Travel", "Children's", "Religion, Spirituality & New Age", "Science", "History", "Math", "Poetry", "Dictionaries", "Comics", "Art", "Cookbooks", "Diaries", "Journals", "Series", "Biographies", "Autobiographies", "Fantasy"});
		combo.setBounds(756, 199, 193, 28);
		
		combo_1 = new Combo(shlBookSSettings, SWT.NONE);
		combo_1.setItems(new String[] {"1", "0"});
		combo_1.setBounds(756, 363, 193, 28);
		
		text_2 = new Text(shlBookSSettings, SWT.BORDER);
		text_2.setBounds(756, 304, 193, 26);
		
		Button btnNewButton = new Button(shlBookSSettings, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//UPDATE CLICK
				Bookp b=new Bookp();
				
				b.setName(text.getText());
				b.setType(combo.getText());
				b.setWriter(text_1.getText());
				b.setDefinition(text_2.getText());
				b.setActive(Integer.parseInt(combo_1.getText()));
				b.setBookID(Integer.parseInt(text_3.getText()));
				if(bm.edit(b))
				{
					JOptionPane.showMessageDialog(null,"succesful to editing book!");
					FillData();
					ClearCells();
				}
				else{
					JOptionPane.showMessageDialog(null,"unsuccesful to editing book!");
				}
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(BookSettingsFrame.class, "/ikons/User-Interface-Available-Updates-icon.png"));
		btnNewButton.setBounds(623, 422, 90, 51);
		
		Button btnNewButton_1 = new Button(shlBookSSettings, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//	DELETE
				TableItem[]row=table.getSelection();
				int id=Integer.parseInt(row[0].getText());
				Bookp b=bm.Find(id);
				bm.delete(b);
				FillData();
				ClearCells();
				
			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(BookSettingsFrame.class, "/ikons/delete-icon.png"));
		btnNewButton_1.setBounds(744, 422, 90, 51);

		
		Button btnNewButton_2 = new Button(shlBookSSettings, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//ADDING BOOK
				Bookp b=new Bookp();
				b.setBookID(Integer.parseInt(text_3.getText()));
				b.setName(text.getText());
				b.setType(combo.getText());
				b.setWriter(text_1.getText());
				b.setDefinition(text_2.getText());
				b.setActive(Integer.parseInt(combo_1.getText()));
				if(bm.create(b))
				{
					JOptionPane.showMessageDialog(null,"succesful to adding book!");
					FillData();
					ClearCells();
				}
				else{
					JOptionPane.showMessageDialog(null,"unsuccesful to adding book!");
				}
			}
		});
		btnNewButton_2.setImage(SWTResourceManager.getImage(BookSettingsFrame.class, "/ikons/Arrow-Right-icon.png"));
		btnNewButton_2.setBounds(859, 422, 90, 51);
		
		Label label = new Label(shlBookSSettings, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		label.setImage(SWTResourceManager.getImage(BookSettingsFrame.class, "/ikons/Security-Question-Shield-icon.png"));
		label.setBounds(859, 22, 97, 74);
		
		Label lblNewLabel_5 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_5.setBounds(659, 48, 150, 20);
		lblNewLabel_5.setText("Book Information");
		
		Label lblNewLabel_6 = new Label(shlBookSSettings, SWT.NONE);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel_6.setBounds(621, 113, 70, 20);
		lblNewLabel_6.setText("ID:");
		
		 r=new Random();
		int rId=r.nextInt(10000);
		
		text_3 = new Text(shlBookSSettings, SWT.BORDER);
		text_3.setEnabled(false);
		text_3.setText(String.valueOf(rId));
		text_3.setBounds(756, 113, 78, 26);
		
	}
}
