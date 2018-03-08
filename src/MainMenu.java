import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class MainMenu {

	protected Shell shlMenu;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = new MainMenu();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMenu.open();
		shlMenu.layout();
		while (!shlMenu.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMenu = new Shell();
		shlMenu.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/File-delete-icon.png"));
		shlMenu.setBackground(SWTResourceManager.getColor(255, 102, 0));
		shlMenu.setSize(899, 578);
		shlMenu.setText("MENU");
		
		Menu menu = new Menu(shlMenu, SWT.BAR);
		shlMenu.setMenuBar(menu);
		
		MenuItem mnýtmBookLists = new MenuItem(menu, SWT.NONE);
		mnýtmBookLists.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//call booklist frame 
				BookListFrame window = new BookListFrame();
				window.open();
				
			}
		});
		mnýtmBookLists.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Business-Todo-List-icon.png"));
		mnýtmBookLists.setText("Book Lists");
		
		MenuItem mnýtmMemberList = new MenuItem(menu, SWT.NONE);
		mnýtmMemberList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//call memberlistframe
				MemberListFrame window = new MemberListFrame();
				window.open();
			}
		});
		mnýtmMemberList.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Misc-User-icon.png"));
		mnýtmMemberList.setText("Member List");
		
		MenuItem mnýtmNewItem = new MenuItem(menu, SWT.NONE);
		mnýtmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//call rent list
				RentListFrame rlf=new RentListFrame();
				rlf.open();
			}
		});
		mnýtmNewItem.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Time-And-Date-Calendar-icon.png"));
		mnýtmNewItem.setText("Rent List");
		
		Button btnNewButton = new Button(shlMenu, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//call booksettingsframe
				BookSettingsFrame window = new BookSettingsFrame();
				window.open();
			}
		});
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		btnNewButton.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Printing-Books-icon.png"));
		btnNewButton.setBounds(160, 176, 114, 112);
		
		Button btnNewButton_1 = new Button(shlMenu, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//call membersettingsframe
				MemberSettingsFrame window = new MemberSettingsFrame();
				window.open();
			}
		});
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		btnNewButton_1.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Add-User-icon.png"));
		btnNewButton_1.setBounds(367, 176, 114, 112);
		
		Button btnNewButton_2 = new Button(shlMenu, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RentingFrame rf=new RentingFrame();
				rf.open();
			}
		});
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		btnNewButton_2.setImage(SWTResourceManager.getImage(MainMenu.class, "/ikons/Business-Statistics-icon.png"));
		btnNewButton_2.setBounds(567, 176, 114, 112);

	}
}
