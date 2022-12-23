package database;

import java.awt.*;//Usa il frame per la app grafica java

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import database.Main.*;

public class GraphicApp  extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Oggetti
	JPanel panel = new JPanel();//Pannello di visione
	JButton query1 = new JButton("RECEPTIONIST NON IN TURNO");//Bottone per la prima query
	JButton query2 = new JButton("ADDETTI STIPENDI>1000");//Bottone per la seconda query
	JButton query3 = new JButton("PACCHETTI ACQUISTATI");//Bottone per la terza query
	JButton query4 = new JButton("PARTECIPANTI EVENTO");//Bottone per la quarta query
	JButton query5 = new JButton("ACQUISTO ATTRAZIONE");//Bottone per la quinta query
	JButton query6 = new JButton("ACQUISTO PACCHETTO");//Bottone per la sesta query
	JButton query7 = new JButton("ANIMALI DA NUTRIRE");//Bottone per la settima query
	JButton query8 = new JButton("ACQUISTO EVENTO");//Bottone per la ottava query
	JButton query9 = new JButton("ETÀ CLIENTI");//Bottone per la nona query
	JButton query10 = new JButton("LAVORATORI CON BENEFIT");//Bottone per la decima query
	JButton query11 = new JButton("ASSUMERE DIPENDENTE");//Bottone per la undicesima query
	JButton query12 = new JButton("ASSUMERE ADDESTRATORE");//Bottone per la dodicesima query
	JButton query11a = new JButton("BONUS DIPENDENTE");//Bottone per la undicesimaa query
	JButton query12a = new JButton("BONUS ADDESTRATORE");//Bottone per la dodicesimaa query
	JButton select = new JButton("ESPLORA DATABASE");//Bottone per esplorare il database
	JButton insert = new JButton("INSERISCI IN DATABASE");//Bottone per esplorare il database
	JButton submit = new JButton("SUBMIT");//Bottone per la prima query
	JTextArea queryfield = new JTextArea("Query result: ");
	JScrollPane scroll = new JScrollPane(queryfield);
	BufferedImage br;
	final JTextArea input = new JTextArea();
	final ArrayList<String> inputText = new ArrayList<String>();
	final ArrayList<String[]> inputArray = new ArrayList<String[]>();
	final boolean isGained = false;
	
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(br,0, 0, getWidth(), getHeight(), null);
		super.paint(g);
		
	}
	/**
	 * Costruttore
	 */
	public GraphicApp() {
		
		//Chiudere la finestra
		addWindowListener((WindowListener) new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
		
		//Impostazioni di finestra
		setLayout(null);
		setSize(new Dimension(1200,1200));
		setTitle("FunCampApp");
			    
		//Impostazioni e disposizioni bottoni e aree testo		
		scroll.setBounds(50, 670, 1100, 150);	
		queryfield.setEditable(false);queryfield.setLineWrap(true);queryfield.setBackground(new Color(255,255,255));queryfield.setBorder(new LineBorder(Color.black,2));		
    	input.setEditable(true);input.setBounds(50, 610, 200, 50);input.setLineWrap(true);input.setBackground(Color.white);input.setBorder(new LineBorder(Color.black,2));
		
		query1.setBounds(50, 50, 200, 50);query1.setBackground(Color.white);query1.setMargin(new Insets(-1,-1,-1,-1));query1.setBorder(new LineBorder(Color.black,2));
		query2.setBounds(350, 50, 200, 50);query2.setBackground(Color.white);query2.setMargin(new Insets(-1,-1,-1,-1));query2.setBorder(new LineBorder(Color.black,2));
		query3.setBounds(650, 50, 200, 50);query3.setBackground(Color.white);query3.setMargin(new Insets(-1,-1,-1,-1));query3.setBorder(new LineBorder(Color.black,2));
		query4.setBounds(950, 50, 200, 50);query4.setBackground(Color.white);query4.setMargin(new Insets(-1,-1,-1,-1));query4.setBorder(new LineBorder(Color.black,2));
		query5.setBounds(50, 200, 200, 50);query5.setBackground(Color.white);query5.setMargin(new Insets(-1,-1,-1,-1));query5.setBorder(new LineBorder(Color.black,2));
		query6.setBounds(350, 200, 200, 50);query6.setBackground(Color.white);query6.setMargin(new Insets(-1,-1,-1,-1));query6.setBorder(new LineBorder(Color.black,2));
		query7.setBounds(650, 200, 200, 50);query7.setBackground(Color.white);query7.setMargin(new Insets(-1,-1,-1,-1));query7.setBorder(new LineBorder(Color.black,2));
		query8.setBounds(950, 200, 200, 50);query8.setBackground(Color.white);query8.setMargin(new Insets(-1,-1,-1,-1));query8.setBorder(new LineBorder(Color.black,2));
		query9.setBounds(50, 350, 200, 50);query9.setBackground(Color.white);query9.setMargin(new Insets(-1,-1,-1,-1));query9.setBorder(new LineBorder(Color.black,2));
		query10.setBounds(350, 350, 200, 50);query10.setBackground(Color.white);query10.setMargin(new Insets(-1,-1,-1,-1));query10.setBorder(new LineBorder(Color.black,2));
		query11.setBounds(650, 350, 200, 50);query11.setBackground(Color.white);query11.setMargin(new Insets(-1,-1,-1,-1));query11.setBorder(new LineBorder(Color.black,2));
		query12.setBounds(950, 350, 200, 50);query12.setBackground(Color.white);query12.setMargin(new Insets(-1,-1,-1,-1));query12.setBorder(new LineBorder(Color.black,2));
		query11a.setBounds(650, 500, 200, 50);query11a.setBackground(Color.white);query11a.setMargin(new Insets(-1,-1,-1,-1));query11a.setBorder(new LineBorder(Color.black,2));
		query12a.setBounds(950, 500, 200, 50);query12a.setBackground(Color.white);query12a.setMargin(new Insets(-1,-1,-1,-1));query12a.setBorder(new LineBorder(Color.black,2));
		select.setBounds(350, 500, 200, 50);select.setBackground(Color.white);select.setMargin(new Insets(-1,-1,-1,-1));select.setBorder(new LineBorder(Color.black,2));
		insert.setBounds(50, 500, 200, 50);insert.setBackground(Color.white);insert.setMargin(new Insets(-1,-1,-1,-1));insert.setBorder(new LineBorder(Color.black,2));
		submit.setBounds(300, 610, 100, 50);submit.setBackground(Color.white);submit.setMargin(new Insets(-1,-1,-1,-1));submit.setBorder(new LineBorder(Color.black,2));
		
		//Aggiunta di componenti all'app
		add(panel);
		add(query1);add(query2);add(query3);
		add(query4);add(query5);add(query6);
		add(query7);add(query8);add(query9);
		add(query10);add(query11);add(query12);
		add(query11a);add(query12a);
		add(scroll);
		add(select);
		add(insert);
		
		try {
			br=ImageIO.read(new File("C:\\Users\\vava5\\eclipse-workspace\\FunCampApp\\immagini\\Background.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Listeners
		query1.addActionListener(new query1Listener());
		query2.addActionListener(new query2Listener());
		query3.addActionListener(new query3Listener());
		query4.addActionListener(new query4Listener());
		query5.addActionListener(new query5Listener());
		query6.addActionListener(new query6Listener());
		query7.addActionListener(new query7Listener());
		query8.addActionListener(new query8Listener());
		query9.addActionListener(new query9Listener());
		query10.addActionListener(new query10Listener());
		query11.addActionListener(new query11Listener());
		query11a.addActionListener(new query11aListener());
		query12.addActionListener(new query12Listener());
		query12a.addActionListener(new query12aListener());
		select.addActionListener(new selectListener());
		insert.addActionListener(new insertListener());
		setVisible(true);//Visibilità
	}
	
	private void finish()
	{
		remove(input);
		remove(submit);
	}
	
	private void restart()
	{
	  System.out.println("Sto ripartendo");
	  final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	  File currentJar;
		try {
			currentJar = new File(GraphicApp.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			currentJar=null;
		}

	  /* is it a jar file? */
	  if(!currentJar.getName().endsWith(".jar"))
	    return;

	  /* Build command: java -jar application.jar */
	  final ArrayList<String> command = new ArrayList<String>();
	  command.add(javaBin);
	  command.add("-jar");
	  command.add(currentJar.getPath());

	  final ProcessBuilder builder = new ProcessBuilder(command);
	  try {
		builder.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.exit(0);
	}
	/**
	 * Listener della prima query
	 * @author vava5
	 */
	private class query1Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  		
			 	finish();
			 	inputText.clear();
			 	inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert date: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(!(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));	
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							queryfield.setText(queryfield.getText()+"\n"+Main.query1(inputText.get(0)));
							inputText.clear();
						
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della seconda query
	 * @author vava5
	 */
	private class query2Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
			 	inputText.clear();
			 	inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	try 
				 {
					queryfield.setText(queryfield.getText()+"\n"+Main.query2());
					inputText.clear();
				 } catch (Exception e1)
				 {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					restart();
				 }
		    }
	}
	
	/**
	 * Listener della terza query
	 * @author vava5
	 */
	private class query3Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
			 	inputText.clear();
			 	inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert date: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))inputText.add(input.getText().substring(input.getText().indexOf(":")+1));							 
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							queryfield.setText(queryfield.getText()+"\n"+Main.query3(inputText.get(0)));
							inputText.clear();
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della quarta query
	 * @author vava5
	 */
	private class query4Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert date: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))inputText.add(input.getText().substring(input.getText().indexOf(":")+1));							 
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							queryfield.setText(queryfield.getText()+"\n"+Main.query4(inputText.get(0)));
							inputText.clear();
							FocusListener[] f = input.getListeners(FocusListener.class);
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della quinta query
	 * @author vava5
	 */
	private class query5Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
			 	inputText.clear();
			 	inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(!input.getText().isEmpty())
						{
							if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							for(String ss:inputText)System.out.println(ss);
							if(inputText.size()==1) input.setText("Insert surname: ");
							else if(inputText.size()==2) input.setText("Insert age: ");
							else if(inputText.size()==3) input.setText("Insert date: ");
							else if(inputText.size()==4) input.setText("Insert attraction code: ");
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query5(inputText.get(0), inputText.get(1), inputText.get(2), inputText.get(3),inputText.get(4)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della sesta query
	 * @author vava5
	 */
	private class query6Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert surname: ");
							else if(inputText.size()==2) input.setText("Insert age: ");
							else if(inputText.size()==3) input.setText("Insert date: ");
							else if(inputText.size()==4) input.setText("Insert pack code: ");
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query6(inputText.get(0), inputText.get(1), inputText.get(2), inputText.get(3),inputText.get(4)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della settima query
	 * @author vava5
	 */
	private class query7Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert surname: ");
							
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query7(inputText.get(0), inputText.get(1)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della ottava query
	 * @author vava5
	 */
	private class query8Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  			 
			 	finish();
			 	inputText.clear();
			 	inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert surname: ");
							else if(inputText.size()==2) input.setText("Insert age: ");
							else if(inputText.size()==3) input.setText("Insert date: ");
							else if(inputText.size()==4) input.setText("Insert event name: ");
							else if(inputText.size()==5) input.setText("Insert event date: ");
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query8(inputText.get(0), inputText.get(1), inputText.get(2), inputText.get(3),inputText.get(4),inputText.get(5)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della nona query
	 * @author vava5
	 */
	private class query9Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert age: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))inputText.add(input.getText().substring(input.getText().indexOf(":")+1));							 
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							queryfield.setText(queryfield.getText()+"\n"+Main.query9(inputText.get(0)));
							inputText.clear();
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della decima query
	 * @author vava5
	 */
	private class query10Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	try 
				 {
					queryfield.setText(queryfield.getText()+"\n"+Main.query10());
					inputText.clear();
				 } catch (Exception e1)
				 {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					restart();
				 }
		    }
	}
	
	/**
	 * Listener della undicesima query
	 * @author vava5
	 */
	private class query11Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert surname: ");
							else if(inputText.size()==2) input.setText("Insert workerType: ");
							else if(inputText.size()==3) input.setText("Insert wage: ");
							else if(inputText.size()==4) input.setText("Insert years of contract: ");
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query11(inputText.get(0), inputText.get(1), inputText.get(2), inputText.get(3),inputText.get(4)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della dodicesima query
	 * @author vava5
	 */
	private class query12Listener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert surname: ");
							else if(inputText.size()==2) input.setText("Insert Fiscal Code: ");
							else if(inputText.size()==3) input.setText("Insert wage: ");
							else if(inputText.size()==4) input.setText("Insert days of contract: ");
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query12(inputText.get(0), inputText.get(1), inputText.get(2), inputText.get(3),inputText.get(4)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}

	/**
	 * Listener della undicesima query a
	 * @author vava5
	 */
	private class query11aListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert worker code: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert benefit code: ");
							
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query11(inputText.get(0), inputText.get(1)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della dodicesima query a
	 * @author vava5
	 */
	private class query12aListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert fiscal code: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							inputText.add(input.getText().substring(input.getText().indexOf(":")+1));
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1) input.setText("Insert benefit code: ");
							
							else
							{
								queryfield.setText(queryfield.getText()+"\n"+Main.query12(inputText.get(0), inputText.get(1)));
								inputText.clear();
							}							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	/**
	 * Listener della select
	 * @author vava5
	 */
	private class selectListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert table name: ");
	 
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(!input.getText().isEmpty())inputText.add(input.getText().substring(input.getText().indexOf(":")+1));							 
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							queryfield.setText(queryfield.getText()+"\n"+Main.select(inputText.get(0)));
							inputText.clear();
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	
	/**
	 * Listener della insert
	 * @author vava5
	 */
	private class insertListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		    {  
			 	finish();
				inputText.clear();
				inputArray.clear();
			 	queryfield.setText("Query result: ");
		    	add(input);
		    	add(submit);
	    		input.setText("Insert table name: ");
	    		//Ascolta l'input
		    	input.addFocusListener(new FocusListener()
		    	{
					@Override
					public void focusGained(FocusEvent e) {}

					@Override
					public void focusLost(FocusEvent e)
					{
						if(inputText.size()==0 || !(input.getText().substring(input.getText().indexOf(":")+1).contentEquals(inputText.get(inputText.size()-1))))
						{
							if((input.getText().substring(input.getText().indexOf(":")+1).split(",").length>1))
							{
								inputArray.add(input.getText().substring(input.getText().indexOf(":")+1).split(","));
							}
							else inputText.add(input.getText().substring(input.getText().indexOf(":")+1));							 
						}
					}
		    		
		    	});
		    	//Sottomette l'input
		    	submit.addActionListener(new ActionListener()
		    	{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try 
						 {
							if(inputText.size()==1 && !(inputArray.size()>=1)) input.setText("Insert columns: ");
							else if(inputArray.size()==1) input.setText("Insert values: ");
							else
							{								
								queryfield.setText(queryfield.getText()+"\n"+Main.ins(inputText.get(0), inputArray.get(0), inputArray.get(1)));
								inputText.clear();
							}
							
						 } catch (Exception e1)
						 {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							finish();
							restart();
						 }
					}
		    		
		    	});
			   
		    }
	}
	/**
	 * Main
	 * @param argv
	 */
	public static void main(String[] argv)
	{
		new GraphicApp();
	}
}
