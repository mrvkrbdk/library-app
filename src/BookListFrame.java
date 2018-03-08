import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import Entity.Bookp;
import Model.BookpModel;



public class BookListFrame {

	protected Shell shlBookList;
	private Table table;
	private BookpModel bm=new BookpModel();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BookListFrame window = new BookListFrame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private void FillData(){
		table.removeAll();
		for(Bookp b:bm.FindAll())
		{
			TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {String.valueOf(b.getBookID()),b.getName(),b.getType(),b.getWriter(),b.getDefinition(),String.valueOf(b.getActive())});
		}
		
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		FillData();
		shlBookList.open();
		shlBookList.layout();
		while (!shlBookList.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBookList = new Shell();
		shlBookList.setSize(921, 557);
		shlBookList.setText("Book List");
		shlBookList.setLayout(null);
		
		table = new Table(shlBookList, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 10, 926, 433);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("BookID");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("Name");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(133);
		tblclmnNewColumn_2.setText("Type");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(147);
		tblclmnNewColumn_3.setText("Writer");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(240);
		tblclmnNewColumn_5.setText("Definition");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		//tblclmnNewColumn_4.setObject(boolean);
		tblclmnNewColumn_4.setWidth(172);
		tblclmnNewColumn_4.setText("Active");
		
		
		

	}
}
