import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage.*;
import javax.imageio.ImageIO;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

class test
{
	
private JFrame j;
private JMenu jmenu1,jmenu2,jmenu3;
private JMenuBar jbar;
private JMenuItem jm1,jm2, jexit,jm3,jm4,jm5,jm6;
private JPanel jpanel, jpanelbar;
JButton b1, b2,b3,b4,b5,b6,b7,b8;
JTextField t1,t2,t3;
JLabel l1,l2,l3,l4,image,l5;
JPanel p1,p2,p3,p4;
ImageIcon ic;
Image img;
JCheckBox cb1,cb2;
File file;
String t1text,t3text;
public void init(){
			j = new JFrame("VISIBLE INVISIBLE WATERMARK");
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.setLocationByPlatform(true);
    			j.setLayout(null);
		}
  	
	test()
	{
		init();
            	t1= new JTextField("");
		t2= new JTextField("");
		t3= new JTextField("");
		j.setSize(850,650);
		b1= new JButton("...");
		b2= new JButton("...");
		b7= new JButton("...");
		b8= new JButton("EXTRACT");
		l1=new JLabel("SOURCE IMAGE");
		l2=new JLabel("WATERMARK IMAGE");
		l3=new JLabel("EXTRACT");
		l4=new JLabel("READWATERMARK");
		t1.setBounds(620,80,100,30);
		t1.setSize(100,30);
		l1.setBounds(620,50,150,20);
		b1.setBounds(750,80,70,30);
		b1.setSize(70,30);
		p4 = new JPanel();
		jpanel = new JPanel();
		p4.setBounds(0,100,500,500);
		b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    JFileChooser fc = new JFileChooser();
        		    int result = fc.showOpenDialog(null);
        		    if (result == JFileChooser.APPROVE_OPTION) {
                			File file = fc.getSelectedFile();
                			t1text = file.getName();
					String path =file.getAbsolutePath();
                			t1.setText(path);
            				}
        			}
    			});

		l2.setBounds(620,130,150,20);
		t2.setBounds(620,160,100,30);
		t2.setSize(100,30);
		b2.setBounds(750,160,50,20);
		b2.setSize(70,30);
		b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    JFileChooser fc = new JFileChooser();
        		    int result = fc.showOpenDialog(null);
        		    if (result == JFileChooser.APPROVE_OPTION) {
                			file = fc.getSelectedFile();
                			String sname = file.getName();
					String path = file.getAbsolutePath();
    					t2.setText(path);
            				}
        			}
    			});

		cb1= new JCheckBox("VISIBLE WATERMARK");
		cb1.setBounds(620,220,200,30);
		cb2= new JCheckBox("INVISIBLE WATERMARK");
		cb2.setBounds(620,270,200,30);
		b5= new JButton("PREVIEW");
		b5.setBounds(620,330,100,30);
		b5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        				if(cb1.isSelected()){	
					File src = new File(t1.getText());
					File dest = new File("newimage.png");



					File watermarkImageFile = new File(t2.getText());

					addImageWatermark(watermarkImageFile, src, dest);
					String sname = dest.getName();
					image = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
                			jpanel.add(image, BorderLayout.CENTER);
					jpanel.setBounds(0,50,600,500);
                			jpanel.revalidate();
                			jpanel.repaint();
					}
					if(cb2.isSelected()){
					      invisible(t1.getText(),t2.getText(),t1text);
					      File dest = new File(t1text);
					       String sname = dest.getName();
						image = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
                				jpanel.add(image, BorderLayout.CENTER);
						jpanel.setBounds(0,50,600,500);
                				jpanel.revalidate();
                				jpanel.repaint();
					}
            				}
        			
    			});
		

		b6= new JButton("SAVE");
		b6.setBounds(730,330,100,30);
		b6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    		JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save");   
 					int userSelection = fileChooser.showSaveDialog(null);
 					if(userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = file;
				    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				}
				}
				
    			});
		
		l3.setBounds(620,400,150,30);
		t3.setBounds(620,450,100,30);
		t3.setSize(100,30);
		b7.setBounds(750,450,70,30);
		b7.setSize(70,30);
		b7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    JFileChooser fc = new JFileChooser();
        		    int result = fc.showOpenDialog(null);
        		    if (result == JFileChooser.APPROVE_OPTION) {
                			file = fc.getSelectedFile();
                			String sname = file.getName();
					String path = file.getAbsolutePath();
    					t3.setText(path);
					t3text = file.getName();
            				}
        			}
    			});

		b8.setBounds(620,500,150,30);
		b8.setSize(150,30);
		b8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    			
							extrctedimg(t3.getText(),t3text);
							File dest = new File("wm.png");
						        String sname = dest.getName();
							image = new JLabel("", new ImageIcon(sname), JLabel.CENTER);
	                				jpanel.add(image, BorderLayout.CENTER);
							jpanel.setBounds(0,50,600,500);
	                				jpanel.revalidate();
	                				jpanel.repaint();	
        			}
    			});
		jbar = new JMenuBar();
        	    jmenu1 = new JMenu("File");
		    jmenu2 = new JMenu("view");
		    jmenu3 = new JMenu("help");
  		  jm1 = new JMenuItem("Add Source Image");
    		jm1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    JFileChooser fc = new JFileChooser();
        		    int result = fc.showOpenDialog(null);
        		    if (result == JFileChooser.APPROVE_OPTION) {
                			File file = fc.getSelectedFile();
                			String sname = file.getName();
					String path = file.getAbsolutePath();
                			t1.setText(path);
            				}
        			}
    			});
		
		jm2 = new JMenuItem("Add Watermark Image");
    		jm2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		    JFileChooser fc = new JFileChooser();
        		    int result = fc.showOpenDialog(null);
        		    if (result == JFileChooser.APPROVE_OPTION) {
                			File file = fc.getSelectedFile();
                			String sname = file.getName();
					String path = file.getAbsolutePath();
                			t2.setText(path);
            				}
        			}
    			});

   		 jexit = new JMenuItem("Exit");
    	 	jexit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
            		System.exit(0);
        		}
    		});
		jm3 = new JMenuItem("Language");
		jm3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
            					String msg = "ENGLISH";

    				JOptionPane optionPane = new NarrowOptionPane();
    				optionPane.setMessage(msg);
    				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
   				 JDialog dialog = optionPane.createDialog(null, "LANGUAGE");
   				 dialog.setVisible(true);
        		}
	});
		jm4 = new JMenuItem("Contents");
		jm4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
            					String msg = "This software contains two type of water marking:\n1. Visible watermarking\n2. Invisible watermarking";

    				JOptionPane optionPane = new NarrowOptionPane();
    				optionPane.setMessage(msg);
    				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
   				 JDialog dialog = optionPane.createDialog(null, "CONTENTS");
   				 dialog.setVisible(true);
        		}
	});
		jm5 = new JMenuItem("About");
		jm5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
            					String msg = "Project mentor:\n\nProf. Satarupa Bagchi\n\n\nThe team members:\n\nUpendra Nishad    1454017\nFalesh Rathor       1454037\nGanesh Kumar      1454036";

    				JOptionPane optionPane = new NarrowOptionPane();
    				optionPane.setMessage(msg);
    				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
   				 JDialog dialog = optionPane.createDialog(null, "ABOUT US");
   				 dialog.setVisible(true);
        		}
	});

		p1 = new JPanel();
		File top = new File("1.jpg");
		String sname1 = top.getName();
		image = new JLabel("", new ImageIcon(sname1), JLabel.CENTER);
                p1.add(image, BorderLayout.CENTER);
		p1.setBounds(0,0,850,50);
		

		p2 = new JPanel();
		File top1 = new File("2.jpg");
		String sname2 = top1.getName();
		image = new JLabel("", new ImageIcon(sname2), JLabel.CENTER);
                p2.add(image, BorderLayout.CENTER);
		p2.setBounds(600,0,250,650);


		p3 = new JPanel();
		File top2 = new File("1.jpg");
		String sname3 = top2.getName();
		image = new JLabel("", new ImageIcon(sname3), JLabel.CENTER);
                p3.add(image, BorderLayout.CENTER);
		p3.setBounds(0,500,650,150);

		
    		jmenu1.add(jm1);
		jmenu1.add(jm2);
    		jmenu1.add(jexit);
		jmenu2.add(jm3);
		jmenu3.add(jm4);
		jmenu3.add(jm5);
    		jbar.add(jmenu1);
		jbar.add(jmenu2);
		jbar.add(jmenu3);
    		j.setJMenuBar(jbar);
		j.add(jpanel);
		j.add(l1);
		j.add(b1);
		j.add(b2);
		j.add(l2);
		j.add(t1);
		j.add(t2);
		j.add(cb1);
		j.add(cb2);
		j.add(l3);
		j.add(t3);
		j.add(b7);
		j.add(b8);
		j.add(p2);
		j.add(p1);
		j.add(p3);
		j.add(b5);
		j.add(b6);
		j.add(p4);
		j.setVisible(true);
	}

static void addImageWatermark(File watermarkImageFile,
			File sourceImageFile, File destImageFile) {
		try {
			BufferedImage sourceImage = ImageIO.read(sourceImageFile);
			BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

			
			Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
			AlphaComposite alphaChannel = AlphaComposite.getInstance(
					AlphaComposite.SRC_OVER, 0.3f);
			g2d.setComposite(alphaChannel);

		
			int topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
			int topLeftY = (sourceImage.getHeight() - watermarkImage
					.getHeight()) / 2;

			
			g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);

			ImageIO.write(sourceImage, "png", destImageFile);
			g2d.dispose();

			

		} catch (IOException e) {
			System.err.println(e);
		}
	}


public void invisible(String s1,String s2,String s3){
    try{
    		 int width = 1024;    
    int height = 720;   
    BufferedImage image1 = null;
    BufferedImage image2 = null;
    File f1=null;
    File f2=null;
    File f4 = new File(s3+".txt");
    if (!f4.exists()) {
				f4.createNewFile();
			}

    try{
      f1 = new File(s1); 
      image1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image1 = ImageIO.read(f1);

      f2 = new File(s2); 
      image2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image2 = ImageIO.read(f2);
      
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
   
	int w1 = image1.getWidth();
    	int h1 = image1.getHeight();

	int w2 = image2.getWidth();
    	int h2 = image2.getHeight();
	int img1[][][]=new int[h1][w1][4];
	int img2[][][]=new int[h2][w2][4];
	int code[]= new int[400*400*8];
	
    for (int i = 0; i < h1; i++) {
      for (int j = 0; j < w1; j++) {
        int pixel = image1.getRGB(j,i);
    	img1[i][j][1] = (pixel >> 16) & 254;
    	img1[i][j][2] = (pixel >> 8) & 254;
    	img1[i][j][3] = (pixel) & 254;
	
      }
    }

	for (int i = 0; i < h2; i++) {
	      for (int j = 0; j < w2; j++) {
	        int pixel = image2.getRGB(j, i);
	    	img2[i][j][1] = (pixel >> 16) &0xff;
	    	img2[i][j][2] = (pixel >> 8) &0xff;
	    	img2[i][j][3] = (pixel) &0xff;
		
      }
    }
	
	int arr[]=new int[h2*w2*8*3];
	int k=0;
	for (int i = 0; i < h2; i++) {
	      for (int j = 0; j < w2; j++) {
		int xy=img2[i][j][1];
			for(int l=0;l<8;l++)
				{
					arr[k++]=xy%2;
					xy/=2;
				}
		 xy=img2[i][j][2];
			for(int l=0;l<8;l++)
				{
					arr[k++]=xy%2;
					xy/=2;
				}
		 xy=img2[i][j][3];
			for(int l=0;l<8;l++)
				{
					arr[k++]=xy%2;
					xy/=2;
				}
      }
    }

	int m=0;
	int n=0;
	System.out.println(h1+" "+w1);
	System.out.println(h2+" "+w2);
	  
	 for (int i = 0; i < h1; i++) {
      for (int j = 0; j < w1; j++) {	
	  if(m<k)
	   {
		 
    		img1[i][j][1] +=arr[m++]; 
	    }
	  if(m<k)
	   {
		  
    		img1[i][j][2] +=arr[m++];

		
	    }
	  if(m<k)
	   {
		 
    		img1[i][j][3] +=arr[m++];
		
	    }
			 
      }
    }
 FileWriter fw1 = new FileWriter(f4.getAbsoluteFile());
    BufferedWriter bw1 = new BufferedWriter(fw1);
    bw1.write(h2+"\n"+w2+"\n");
 for (int i = 0; i < h1; i++) {
      for (int j = 0; j < w1; j++) {
        int col = (img1[i][j][1] << 16) | (img1[i][j][2] << 8) | (img1[i][j][3]);
	bw1.write(img1[i][j][1]+"\n"+img1[i][j][2]+"\n"+img1[i][j][3]+"\n");
	image1.setRGB(j, i, col);
      }
    }
	
	bw1.close();

 	   
    try{
      f1 = new File(s3);  
      ImageIO.write(image1, "jpg", f1);
      System.out.println("Writing complete.");
    }catch(Exception e){
      System.out.println("Error: "+e);
    }

	}catch(Exception e){
      System.out.println("Error: "+e);
    }
  }

 public void extrctedimg(String s1,String s2)
{
	try{
		int width = 1024;    
    int height = 720;   
    BufferedImage image1 = null;
    BufferedImage image2 = null;
    File f1 = null;
    File f2 = null;
    File f3 = new File("g.txt");
    if (!f3.exists()) {
				f3.createNewFile();
			}


    try{
      f1 = new File(s1); 
      image1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      image1 = ImageIO.read(f1);

      
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
   
	int w1 = image1.getWidth();
    	int h1 = image1.getHeight();
	int w2,h2;

	int img1[][][]=new int[h1][w1][4];
	int img2[][][]=new int[h1][w1][4];
	int arr[]= new int[h1*w1*8*3];
 	int k=0;

	BufferedReader br = new BufferedReader(new FileReader(s2+".txt"));
	h2=Integer.parseInt(br.readLine());
	w2=Integer.parseInt(br.readLine());
	for (int i = 0; i < h1; i++) {
      for (int j = 0; j < w1; j++) {
 	  
	img1[i][j][1] =Integer.parseInt(br.readLine());
    	img1[i][j][2] =Integer.parseInt(br.readLine());
    	img1[i][j][3] =Integer.parseInt(br.readLine()); 
	arr[k++]=(img1[i][j][1]&1);
	arr[k++]=(img1[i][j][2]&1);
	arr[k++]=(img1[i][j][3]&1);
	
      }
    }
	br.close();

	int m=0;
	int n=0;
	int r,g,b;
   	
	FileWriter fw = new FileWriter(f3.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
	for (int i = 0; i < h2; i++) {
        for (int j = 0; j <w2; j++) {
	    if(m<k-8)
	     {
		       
    	        img2[i][j][1] =arr[m]+(arr[m+1]<<1)+(arr[m+2]<<2)+(arr[m+3]<<3)+(arr[m+4]<<4)+(arr[m+5]<<5)+(arr[m+5]<<5)+(arr[m+6]<<6)+(arr[m+7]<<7);
    		  
			m=m+8;
	
	    }
	if(m<k-8)
	     {
		       
    	        img2[i][j][2] =arr[m]+(arr[m+1]<<1)+(arr[m+2]<<2)+(arr[m+3]<<3)+(arr[m+4]<<4)+(arr[m+5]<<5)+(arr[m+5]<<5)+(arr[m+6]<<6)+(arr[m+7]<<7);
    		  
			m=m+8;
	
	    }

	if(m<k-8)
	     {
		       
    	        img2[i][j][3] =arr[m]+(arr[m+1]<<1)+(arr[m+2]<<2)+(arr[m+3]<<3)+(arr[m+4]<<4)+(arr[m+5]<<5)+(arr[m+5]<<5)+(arr[m+6]<<6)+(arr[m+7]<<7);
    		  
			m=m+8;
	
	    }
	   else
		{
			img2[i][j][1] =255;
    		   	img2[i][j][2] =255; 
    			img2[i][j][3] =255;
		}
	   bw.write(img2[i][j][1]+"\n"+img2[i][j][2]+"\n"+img2[i][j][3]+"\n");
      }
    }
	bw.close();



	for (int i = 0; i < h1; i++) {
        for (int j = 0; j < w1; j++) {
	if(i<h2&&j<w2){
        int col = (img2[i][j][1] << 16) | (img2[i][j][2] << 8) | img2[i][j][3];
	image1.setRGB(j, i, col);
	}
	else
	{
		int col = (255 << 16) |( 255 << 8) | 255;
			image1.setRGB(j, i, col);
	}
      }
    }


 	   
    try{
      f1 = new File("wm.png");  
      ImageIO.write(image1, "png", f1);
      System.out.println("Writing complete.");
    }catch(IOException e){
      System.out.println("Error: "+e);
    }
	
		
		}catch(Exception e){
      System.out.println("Error: "+e);
    }

}




public static void main(String s[]) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new test();
        }
    });
}
}

class NarrowOptionPane extends JOptionPane {

  NarrowOptionPane() {
  }

  public int getMaxCharactersPerLineCount() {
    return 100;
  }
}
