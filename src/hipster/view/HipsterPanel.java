package hipster.view;

import hipster.controller.HipsterController;
import hipster.model.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpringLayout;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		phraseComboBox = new JComboBox<String>();
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change books");
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrase();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(phraseComboBox);
		this.add(bookPageCountLabel);
		this.add(bookAuthorLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(bookTitleLabel);
		this.add(changeBookButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 6, SpringLayout.SOUTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPriceLabel, 22, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookPageCountLabel, 0, SpringLayout.EAST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPriceLabel, 6, SpringLayout.SOUTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookPriceLabel, -97, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, -97, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookPageCountLabel, 6, SpringLayout.SOUTH, bookSubjectLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookTitleLabel, -103, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, bookAuthorLabel, 66, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -6, SpringLayout.NORTH, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, bookTitleLabel, 6, SpringLayout.SOUTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.EAST, bookAuthorLabel, -97, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, changeBookButton, -1, SpringLayout.NORTH, phraseComboBox);
		baseLayout.putConstraint(SpringLayout.EAST, changeBookButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 10, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				setBackground(new Color(red, green, blue));
				String updatedTitle = phraseComboBox.getSelectedItem().toString();
				baseController.getBaseFrame().setTitle(updatedTitle);
			}
		});
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject: " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book pages: " + tempBooks[startClick].getPrice());
					bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title: ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
			}
		});
	}
}
