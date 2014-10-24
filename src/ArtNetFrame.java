/*
 * 
 * @author Felix Schulze
 *
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

import javax.swing.JSlider;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.net.* ;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;


public class ArtNetFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField textField_0;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;
  private JTextField textField_6;
  private JTextField textField_7;
  private JTextField textField_8;
  private JTextField textField_9;
  private JTextField textField_10;
  private JTextField textField_11;
  private JTextField textField_ip;
  private JTextField textField_port;
  
  private JSlider slider_0;
  private JSlider slider_1;
  private JSlider slider_2;
  private JSlider slider_3;
  private JSlider slider_4;
  private JSlider slider_5;
  private JSlider slider_6;
  private JSlider slider_7;
  private JSlider slider_8;
  private JSlider slider_9;
  private JSlider slider_10;
  private JSlider slider_11;
  
  private JLabel label_0;
  private JLabel label_1;
  private JLabel label_2;
  private JLabel label_3;
  private JLabel label_4;
  private JLabel label_5;
  private JLabel label_6;
  private JLabel label_7;
  private JLabel label_8;
  private JLabel label_9;
  private JLabel label_10;
  private JLabel label_11;
  
  private JButton btnConnect;
  
  private final static int dmx_def[] = {0x41, 0x72, 0x74, 0x2D, 0x4E, 0x65, 0x74, 0x00, 0x00, 0x50, 0x00, 0x0E, 0x00, 0x00, 0x00, 0x00, 0x02, 0x00};
  private static byte data[] = new byte[530];
  private static DatagramSocket socket = null;
  private static InetAddress host;
  private static int port;
  private JMenu mnInfo;
  
  
  public static void main(String[] args)
  {
    for (int i = 0; i<18; i++)
    data[i] = (byte)dmx_def[i];
    
    
      EventQueue.invokeLater(new Runnable()
      {
        public void run()
        {
            try
            {
              ArtNetFrame frame = new ArtNetFrame();
              frame.setVisible(true);
            }
            catch (Exception e)
            {
              e.printStackTrace();
            }
        }
      });
  }
  
  
  public ArtNetFrame()
  {
      setIconImage(Toolkit.getDefaultToolkit().getImage(ArtNetFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
      setResizable(false);
      setTitle("Art-Net DMX");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 540, 300);
      
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      
      JMenu mnFile = new JMenu("File");
      menuBar.add(mnFile);
      
      JMenuItem mntmExit = new JMenuItem("Exit");
      mntmExit.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
            System.exit(0);
        }
      });
      mnFile.add(mntmExit);
      
      mnInfo = new JMenu("Info");
      mnInfo.addMouseListener(new MouseAdapter()
      {
        @Override
        public void mouseClicked(MouseEvent arg0)
        {
            JOptionPane.showMessageDialog(null, "Felix Schulze\nArt-Net DMX\n2014", "About", JOptionPane.NO_OPTION);
        }
      });
      menuBar.add(mnInfo);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      GridBagLayout gbl_contentPane = new GridBagLayout();
      gbl_contentPane.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 31, 30, 30, 30, 30, 30, 48, 0, 0};
      gbl_contentPane.rowHeights = new int[]{22, 0, 0, 133, 25, 0};
      gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      contentPane.setLayout(gbl_contentPane);
      
      label_0 = new JLabel("0");
      GridBagConstraints gbc_label_0 = new GridBagConstraints();
      gbc_label_0.fill = GridBagConstraints.VERTICAL;
      gbc_label_0.insets = new Insets(0, 0, 5, 5);
      gbc_label_0.gridx = 0;
      gbc_label_0.gridy = 0;
      contentPane.add(label_0, gbc_label_0);
      
      label_1 = new JLabel("0");
      GridBagConstraints gbc_label_1 = new GridBagConstraints();
      gbc_label_1.fill = GridBagConstraints.VERTICAL;
      gbc_label_1.insets = new Insets(0, 0, 5, 5);
      gbc_label_1.gridx = 1;
      gbc_label_1.gridy = 0;
      contentPane.add(label_1, gbc_label_1);
      
      label_2 = new JLabel("0");
      GridBagConstraints gbc_label_2 = new GridBagConstraints();
      gbc_label_2.fill = GridBagConstraints.VERTICAL;
      gbc_label_2.insets = new Insets(0, 0, 5, 5);
      gbc_label_2.gridx = 2;
      gbc_label_2.gridy = 0;
      contentPane.add(label_2, gbc_label_2);
      
      label_3 = new JLabel("0");
      GridBagConstraints gbc_label_3 = new GridBagConstraints();
      gbc_label_3.fill = GridBagConstraints.VERTICAL;
      gbc_label_3.insets = new Insets(0, 0, 5, 5);
      gbc_label_3.gridx = 3;
      gbc_label_3.gridy = 0;
      contentPane.add(label_3, gbc_label_3);
      
      label_4 = new JLabel("0");
      GridBagConstraints gbc_label_4 = new GridBagConstraints();
      gbc_label_4.fill = GridBagConstraints.VERTICAL;
      gbc_label_4.insets = new Insets(0, 0, 5, 5);
      gbc_label_4.gridx = 4;
      gbc_label_4.gridy = 0;
      contentPane.add(label_4, gbc_label_4);
      
      label_5 = new JLabel("0");
      GridBagConstraints gbc_label_5 = new GridBagConstraints();
      gbc_label_5.fill = GridBagConstraints.VERTICAL;
      gbc_label_5.insets = new Insets(0, 0, 5, 5);
      gbc_label_5.gridx = 5;
      gbc_label_5.gridy = 0;
      contentPane.add(label_5, gbc_label_5);
      
      label_6 = new JLabel("0");
      GridBagConstraints gbc_label_6 = new GridBagConstraints();
      gbc_label_6.fill = GridBagConstraints.VERTICAL;
      gbc_label_6.insets = new Insets(0, 0, 5, 5);
      gbc_label_6.gridx = 6;
      gbc_label_6.gridy = 0;
      contentPane.add(label_6, gbc_label_6);
      
      label_7 = new JLabel("0");
      GridBagConstraints gbc_label_7 = new GridBagConstraints();
      gbc_label_7.fill = GridBagConstraints.VERTICAL;
      gbc_label_7.insets = new Insets(0, 0, 5, 5);
      gbc_label_7.gridx = 7;
      gbc_label_7.gridy = 0;
      contentPane.add(label_7, gbc_label_7);
      
      label_8 = new JLabel("0");
      GridBagConstraints gbc_label_8 = new GridBagConstraints();
      gbc_label_8.fill = GridBagConstraints.VERTICAL;
      gbc_label_8.insets = new Insets(0, 0, 5, 5);
      gbc_label_8.gridx = 8;
      gbc_label_8.gridy = 0;
      contentPane.add(label_8, gbc_label_8);
      
      label_9 = new JLabel("0");
      GridBagConstraints gbc_label_9 = new GridBagConstraints();
      gbc_label_9.fill = GridBagConstraints.VERTICAL;
      gbc_label_9.insets = new Insets(0, 0, 5, 5);
      gbc_label_9.gridx = 9;
      gbc_label_9.gridy = 0;
      contentPane.add(label_9, gbc_label_9);
      
      label_10 = new JLabel("0");
      GridBagConstraints gbc_label_10 = new GridBagConstraints();
      gbc_label_10.fill = GridBagConstraints.VERTICAL;
      gbc_label_10.insets = new Insets(0, 0, 5, 5);
      gbc_label_10.gridx = 10;
      gbc_label_10.gridy = 0;
      contentPane.add(label_10, gbc_label_10);
      
      label_11 = new JLabel("0");
      GridBagConstraints gbc_label_11 = new GridBagConstraints();
      gbc_label_11.fill = GridBagConstraints.VERTICAL;
      gbc_label_11.insets = new Insets(0, 0, 5, 5);
      gbc_label_11.gridx = 11;
      gbc_label_11.gridy = 0;
      contentPane.add(label_11, gbc_label_11);
      
      JLabel lblIp = new JLabel("IP:");
      GridBagConstraints gbc_lblIp = new GridBagConstraints();
      gbc_lblIp.anchor = GridBagConstraints.EAST;
      gbc_lblIp.insets = new Insets(0, 0, 5, 5);
      gbc_lblIp.gridx = 12;
      gbc_lblIp.gridy = 0;
      contentPane.add(lblIp, gbc_lblIp);
      
      textField_ip = new JTextField();
      textField_ip.setText("192.168.0.255");
      GridBagConstraints gbc_textField_ip = new GridBagConstraints();
      gbc_textField_ip.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_ip.insets = new Insets(0, 0, 5, 0);
      gbc_textField_ip.anchor = GridBagConstraints.NORTH;
      gbc_textField_ip.gridx = 13;
      gbc_textField_ip.gridy = 0;
      contentPane.add(textField_ip, gbc_textField_ip);
      textField_ip.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("Port:");
      lblNewLabel.setAlignmentY(1.0f);
      GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
      gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
      gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
      gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
      gbc_lblNewLabel.gridx = 12;
      gbc_lblNewLabel.gridy = 1;
      contentPane.add(lblNewLabel, gbc_lblNewLabel);
      
      textField_port = new JTextField();
      textField_port.setAlignmentY(0.0f);
      textField_port.setAlignmentX(0.0f);
      textField_port.setText("6454");
      GridBagConstraints gbc_textField_port = new GridBagConstraints();
      gbc_textField_port.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_port.insets = new Insets(0, 0, 5, 0);
      gbc_textField_port.gridx = 13;
      gbc_textField_port.gridy = 1;
      contentPane.add(textField_port, gbc_textField_port);
      textField_port.setColumns(10);
      
      btnConnect = new JButton("Connect");
      btnConnect.addMouseListener(new MouseAdapter()
      {
        @Override
        public void mouseClicked(MouseEvent e)
        {
        
            if(btnConnect.getText().equals("Connect"))
            {
              System.out.println(btnConnect.getText()+" to "+textField_ip.getText()+" on Port:"+textField_port.getText());
              
          
              try
              {
                host = InetAddress.getByName(textField_ip.getText()) ;
                port = Integer.parseInt(textField_port.getText()) ;
                socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(data, 530, host, port ) ;
                socket.send( packet ) ;
              }
              catch( Exception e1 )
              {
                System.out.println( e1 ) ;
              }
              btnConnect.setText("Disconnect");
            }
            else if (btnConnect.getText().equals("Disconnect"))
            {
              System.out.println(btnConnect.getText());
              if( socket != null )
          socket.close();
              socket = null;
              btnConnect.setText("Connect");
            }
        }
      });
      GridBagConstraints gbc_btnConnect = new GridBagConstraints();
      gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
      gbc_btnConnect.gridx = 13;
      gbc_btnConnect.gridy = 2;
      contentPane.add(btnConnect, gbc_btnConnect);
      
      slider_0 = new JSlider();
      slider_0.setValue(0);
      slider_0.setMaximum(255);
      slider_0.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_0.setText(""+slider_0.getValue());
            if(Integer.parseInt(textField_0.getText()) > 0 && Integer.parseInt(textField_0.getText()) <= 512 && socket != null)
          {
              label_0.setText(""+slider_0.getValue());
              data[Integer.parseInt(textField_0.getText()) + 17] = (byte) slider_0.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_0.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_0 = new GridBagConstraints();
      gbc_slider_0.gridheight = 3;
      gbc_slider_0.insets = new Insets(0, 5, 5, 5);
      gbc_slider_0.fill = GridBagConstraints.VERTICAL;
      gbc_slider_0.gridx = 0;
      gbc_slider_0.gridy = 1;
      contentPane.add(slider_0, gbc_slider_0);
      
      slider_1 = new JSlider();
      slider_1.setValue(0);
      slider_1.setMaximum(255);
      slider_1.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_1.setText(""+slider_1.getValue());
            if(Integer.parseInt(textField_1.getText()) > 0 && Integer.parseInt(textField_1.getText()) <= 512 && socket != null)
          {
              label_1.setText(""+slider_1.getValue());
              data[Integer.parseInt(textField_1.getText()) + 17] = (byte) slider_1.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_1.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_1 = new GridBagConstraints();
      gbc_slider_1.gridheight = 3;
      gbc_slider_1.fill = GridBagConstraints.VERTICAL;
      gbc_slider_1.insets = new Insets(0, 5, 5, 5);
      gbc_slider_1.gridx = 1;
      gbc_slider_1.gridy = 1;
      contentPane.add(slider_1, gbc_slider_1);
      
      slider_2 = new JSlider();
      slider_2.setValue(0);
      slider_2.setMaximum(255);
      slider_2.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_2.setText(""+slider_2.getValue());
            if(Integer.parseInt(textField_2.getText()) > 0 && Integer.parseInt(textField_2.getText()) <= 512 && socket != null)
          {
              label_2.setText(""+slider_2.getValue());
              data[Integer.parseInt(textField_2.getText()) + 17] = (byte) slider_2.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_2.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_2 = new GridBagConstraints();
      gbc_slider_2.gridheight = 3;
      gbc_slider_2.fill = GridBagConstraints.VERTICAL;
      gbc_slider_2.insets = new Insets(0, 5, 5, 5);
      gbc_slider_2.gridx = 2;
      gbc_slider_2.gridy = 1;
      contentPane.add(slider_2, gbc_slider_2);
      
      slider_3 = new JSlider();
      slider_3.setValue(0);
      slider_3.setMaximum(255);
      slider_3.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_3.setText(""+slider_3.getValue());
            if(Integer.parseInt(textField_3.getText()) > 0 && Integer.parseInt(textField_3.getText()) <= 512 && socket != null)
          {
              label_3.setText(""+slider_3.getValue());
              data[Integer.parseInt(textField_3.getText()) + 17] = (byte) slider_3.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_3.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_3 = new GridBagConstraints();
      gbc_slider_3.gridheight = 3;
      gbc_slider_3.fill = GridBagConstraints.VERTICAL;
      gbc_slider_3.insets = new Insets(0, 5, 5, 5);
      gbc_slider_3.gridx = 3;
      gbc_slider_3.gridy = 1;
      contentPane.add(slider_3, gbc_slider_3);
      
      slider_4 = new JSlider();
      slider_4.setValue(0);
      slider_4.setMaximum(255);
      slider_4.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_4.setText(""+slider_4.getValue());
            if(Integer.parseInt(textField_4.getText()) > 0 && Integer.parseInt(textField_4.getText()) <= 512 && socket != null)
          {
              label_4.setText(""+slider_4.getValue());
              data[Integer.parseInt(textField_4.getText()) + 17] = (byte) slider_4.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_4.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_4 = new GridBagConstraints();
      gbc_slider_4.gridheight = 3;
      gbc_slider_4.fill = GridBagConstraints.VERTICAL;
      gbc_slider_4.insets = new Insets(0, 5, 5, 5);
      gbc_slider_4.gridx = 4;
      gbc_slider_4.gridy = 1;
      contentPane.add(slider_4, gbc_slider_4);
      
      slider_5 = new JSlider();
      slider_5.setValue(0);
      slider_5.setMaximum(255);
      slider_5.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_5.setText(""+slider_5.getValue());
            if(Integer.parseInt(textField_5.getText()) > 0 && Integer.parseInt(textField_5.getText()) <= 512 && socket != null)
          {
              label_5.setText(""+slider_5.getValue());
              data[Integer.parseInt(textField_5.getText()) + 17] = (byte) slider_5.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_5.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_5 = new GridBagConstraints();
      gbc_slider_5.gridheight = 3;
      gbc_slider_5.fill = GridBagConstraints.VERTICAL;
      gbc_slider_5.insets = new Insets(0, 5, 5, 5);
      gbc_slider_5.gridx = 5;
      gbc_slider_5.gridy = 1;
      contentPane.add(slider_5, gbc_slider_5);
      
      slider_6 = new JSlider();
      slider_6.setValue(0);
      slider_6.setMaximum(255);
      slider_6.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_6.setText(""+slider_6.getValue());
            if(Integer.parseInt(textField_6.getText()) > 0 && Integer.parseInt(textField_6.getText()) <= 512 && socket != null)
          {
              label_6.setText(""+slider_6.getValue());
              data[Integer.parseInt(textField_6.getText()) + 17] = (byte) slider_6.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_6.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_6 = new GridBagConstraints();
      gbc_slider_6.gridheight = 3;
      gbc_slider_6.fill = GridBagConstraints.VERTICAL;
      gbc_slider_6.insets = new Insets(0, 5, 5, 5);
      gbc_slider_6.gridx = 6;
      gbc_slider_6.gridy = 1;
      contentPane.add(slider_6, gbc_slider_6);
      
      slider_7 = new JSlider();
      slider_7.setValue(0);
      slider_7.setMaximum(255);
      slider_7.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_7.setText(""+slider_7.getValue());
            if(Integer.parseInt(textField_7.getText()) > 0 && Integer.parseInt(textField_7.getText()) <= 512 && socket != null)
          {
              label_7.setText(""+slider_7.getValue());
              data[Integer.parseInt(textField_7.getText()) + 17] = (byte) slider_7.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_7.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_7 = new GridBagConstraints();
      gbc_slider_7.gridheight = 3;
      gbc_slider_7.fill = GridBagConstraints.VERTICAL;
      gbc_slider_7.insets = new Insets(0, 5, 5, 5);
      gbc_slider_7.gridx = 7;
      gbc_slider_7.gridy = 1;
      contentPane.add(slider_7, gbc_slider_7);
      
      slider_8 = new JSlider();
      slider_8.setValue(0);
      slider_8.setMaximum(255);
      slider_8.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_8.setText(""+slider_8.getValue());
            if(Integer.parseInt(textField_8.getText()) > 0 && Integer.parseInt(textField_8.getText()) <= 512 && socket != null)
          {
              label_8.setText(""+slider_8.getValue());
              data[Integer.parseInt(textField_8.getText()) + 17] = (byte) slider_8.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_8.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_8 = new GridBagConstraints();
      gbc_slider_8.fill = GridBagConstraints.VERTICAL;
      gbc_slider_8.gridheight = 3;
      gbc_slider_8.insets = new Insets(0, 5, 5, 5);
      gbc_slider_8.gridx = 8;
      gbc_slider_8.gridy = 1;
      contentPane.add(slider_8, gbc_slider_8);
      
      slider_9 = new JSlider();
      slider_9.setValue(0);
      slider_9.setMaximum(255);
      slider_9.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_9.setText(""+slider_9.getValue());
            if(Integer.parseInt(textField_9.getText()) > 0 && Integer.parseInt(textField_9.getText()) <= 512 && socket != null)
          {
              label_9.setText(""+slider_9.getValue());
              data[Integer.parseInt(textField_9.getText()) + 17] = (byte) slider_9.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_9.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_9 = new GridBagConstraints();
      gbc_slider_9.gridheight = 3;
      gbc_slider_9.fill = GridBagConstraints.VERTICAL;
      gbc_slider_9.insets = new Insets(0, 5, 5, 5);
      gbc_slider_9.gridx = 9;
      gbc_slider_9.gridy = 1;
      contentPane.add(slider_9, gbc_slider_9);
      
      slider_10 = new JSlider();
      slider_10.setValue(0);
      slider_10.setMaximum(255);
      slider_10.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_10.setText(""+slider_10.getValue());
            if(Integer.parseInt(textField_10.getText()) > 0 && Integer.parseInt(textField_10.getText()) <= 512 && socket != null)
          {
              label_10.setText(""+slider_10.getValue());
              data[Integer.parseInt(textField_10.getText()) + 17] = (byte) slider_10.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_10.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_10 = new GridBagConstraints();
      gbc_slider_10.gridheight = 3;
      gbc_slider_10.fill = GridBagConstraints.VERTICAL;
      gbc_slider_10.insets = new Insets(0, 5, 5, 5);
      gbc_slider_10.gridx = 10;
      gbc_slider_10.gridy = 1;
      contentPane.add(slider_10, gbc_slider_10);
      
      slider_11 = new JSlider();
      slider_11.setValue(0);
      slider_11.setMaximum(255);
      slider_11.addChangeListener(new ChangeListener()
      {
        public void stateChanged(ChangeEvent arg0)
        {
            label_11.setText(""+slider_11.getValue());
            if(Integer.parseInt(textField_11.getText()) > 0 && Integer.parseInt(textField_11.getText()) <= 512 && socket != null)
          {
              label_11.setText(""+slider_11.getValue());
              data[Integer.parseInt(textField_11.getText()) + 17] = (byte) slider_11.getValue();
              try
              {
                DatagramPacket packet = new DatagramPacket(data, 530, host, port );
                socket.send( packet ) ;
              }
              catch( Exception e )
              {
                System.out.println( e ) ;
              }
          }
        }
      });
      slider_11.setOrientation(SwingConstants.VERTICAL);
      GridBagConstraints gbc_slider_11 = new GridBagConstraints();
      gbc_slider_11.gridheight = 3;
      gbc_slider_11.fill = GridBagConstraints.VERTICAL;
      gbc_slider_11.insets = new Insets(0, 5, 5, 5);
      gbc_slider_11.gridx = 11;
      gbc_slider_11.gridy = 1;
      contentPane.add(slider_11, gbc_slider_11);
      
      textField_0 = new JTextField();
      textField_0.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField = new GridBagConstraints();
      gbc_textField.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField.gridx = 0;
      gbc_textField.gridy = 4;
      contentPane.add(textField_0, gbc_textField);
      textField_0.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_1 = new GridBagConstraints();
      gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_1.gridx = 1;
      gbc_textField_1.gridy = 4;
      contentPane.add(textField_1, gbc_textField_1);
      textField_1.setColumns(10);
      
      textField_2 = new JTextField();
      textField_2.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_2 = new GridBagConstraints();
      gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_2.gridx = 2;
      gbc_textField_2.gridy = 4;
      contentPane.add(textField_2, gbc_textField_2);
      textField_2.setColumns(10);
      
      textField_3 = new JTextField();
      textField_3.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_3 = new GridBagConstraints();
      gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_3.gridx = 3;
      gbc_textField_3.gridy = 4;
      contentPane.add(textField_3, gbc_textField_3);
      textField_3.setColumns(10);
      
      textField_4 = new JTextField();
      textField_4.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_4 = new GridBagConstraints();
      gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_4.gridx = 4;
      gbc_textField_4.gridy = 4;
      contentPane.add(textField_4, gbc_textField_4);
      textField_4.setColumns(10);
      
      textField_5 = new JTextField();
      textField_5.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_5 = new GridBagConstraints();
      gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_5.gridx = 5;
      gbc_textField_5.gridy = 4;
      contentPane.add(textField_5, gbc_textField_5);
      textField_5.setColumns(10);
      
      textField_6 = new JTextField();
      textField_6.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_6 = new GridBagConstraints();
      gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_6.gridx = 6;
      gbc_textField_6.gridy = 4;
      contentPane.add(textField_6, gbc_textField_6);
      textField_6.setColumns(10);
      
      textField_7 = new JTextField();
      textField_7.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_7 = new GridBagConstraints();
      gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_7.gridx = 7;
      gbc_textField_7.gridy = 4;
      contentPane.add(textField_7, gbc_textField_7);
      textField_7.setColumns(10);
      
      textField_8 = new JTextField();
      textField_8.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_8 = new GridBagConstraints();
      gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_8.gridx = 8;
      gbc_textField_8.gridy = 4;
      contentPane.add(textField_8, gbc_textField_8);
      textField_8.setColumns(10);
      
      textField_9 = new JTextField();
      textField_9.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_9 = new GridBagConstraints();
      gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_9.gridx = 9;
      gbc_textField_9.gridy = 4;
      contentPane.add(textField_9, gbc_textField_9);
      textField_9.setColumns(10);
      
      textField_10 = new JTextField();
      textField_10.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_10 = new GridBagConstraints();
      gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_10.gridx = 10;
      gbc_textField_10.gridy = 4;
      contentPane.add(textField_10, gbc_textField_10);
      textField_10.setColumns(10);
      
      textField_11 = new JTextField();
      textField_11.setHorizontalAlignment(SwingConstants.CENTER);
      GridBagConstraints gbc_textField_11 = new GridBagConstraints();
      gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
      gbc_textField_11.gridx = 11;
      gbc_textField_11.gridy = 4;
      contentPane.add(textField_11, gbc_textField_11);
      textField_11.setColumns(10);
      
      textField_0.setText("1");
      textField_1.setText("2");
      textField_2.setText("3");
      textField_3.setText("4");
      textField_4.setText("5");
      textField_5.setText("6");
      textField_6.setText("7");
      textField_7.setText("8");
      textField_8.setText("9");
      textField_9.setText("10");
      textField_10.setText("11");
      textField_11.setText("12");
      
  }
  
}
