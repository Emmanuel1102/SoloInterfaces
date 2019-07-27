import java.awt.*;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.TableColumnModel;

public class PrincipalOriginal extends JFrame implements ActionListener {

    private JPanel bienvenido, Maquinaria, Obras, Clientes, Finanzas;
    private CardLayout Imagenes;
    private  String nImagenes []={"C:\\Users\\Emmanuel\\Desktop\\manual\\m1.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m2.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m3.jpg",
    		"C:\\Users\\Emmanuel\\Desktop\\manual\\m4.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m5.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m6.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m7.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m8.jpg","C:\\Users\\Emmanuel\\Desktop\\manual\\m9.jpg"
    		,"C:\\Users\\Emmanuel\\Desktop\\manual\\m10.jpg"};
    private Icon  icons[]={new ImageIcon(nImagenes[0]),new ImageIcon(nImagenes[1]),new ImageIcon(nImagenes[2]),new ImageIcon(nImagenes[3]),new ImageIcon(nImagenes[4]),new ImageIcon(nImagenes[5]),new ImageIcon(nImagenes[6]),new ImageIcon(nImagenes[7]),new ImageIcon(nImagenes[8])
    ,new ImageIcon(nImagenes[9])};
    private JLabel la[];
	 private JPanel ap[]; 
	 int contar=0;
	 ImageIcon Graficas = new ImageIcon("C:\\Users\\Emmanuel\\Desktop\\manual\\graf.png");
    
    PrincipalOriginal() {
        setSize(1366, 768);
        setTitle("Sistema de gestion de maquinaria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

  
        JPanel principal = new JPanel();
        principal.setLayout(null);

        principal.setBackground(Color.black);
        principal.setBounds(0, 115, 1366, 768);
      
        ImageIcon background_image = new ImageIcon("C:\\Users\\Emmanuel\\Desktop\\neoo3.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1366, 768, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.add(principal);
        background.setBounds(0, 0, 1366, 768);
        add(background);

        /**Parte donde se agregan las Pestañas*/
        JTabbedPane tabla = new JTabbedPane();
        tabla.setBounds(0, 0, 1366, 768);
        principal.add(tabla);
        tabla.addTab("Bienvenido al sistema ", bienvenido());
        tabla.addTab("Maquinaria", Maquinaria());
        tabla.addTab("Obras",Obras());
        tabla.addTab("Clientes", Clientes());
        tabla.addTab("Finanzas", Finanzas());
       

    }

    public static void main(String[] args) {
        new PrincipalOriginal();
    }

    public JPanel bienvenido() {
        bienvenido = new JPanel();
        bienvenido.setLayout(null);
        setBounds(0, 0, 1366, 768);
        bienvenido.setBackground(Color.black);
        
        JLabel manual = new JLabel("Guía rápida del manual de usuario:");
        manual.setForeground(Color.decode("#049cff"));
    	Font fuente=new Font("Arial", Font.BOLD, 16);
    	manual.setBounds(550,15,400,30);
    	manual.setFont(fuente);
        bienvenido.add(manual);
   
		JPanel botonAtras = new JPanel();
		 botonAtras.setLayout(null);
		 botonAtras.setBackground(new Color (0,0,0,100));
		 botonAtras.setBounds(50,250,51,87);
			bienvenido.add(botonAtras);

		JPanel botonAdelante = new JPanel();
		botonAdelante.setLayout(null);
		botonAdelante.setBackground(new Color (0,0,0,100));
		botonAdelante.setBounds(1260,250,51,87);
		bienvenido.add(botonAdelante);
		
		JButton atras= new JButton("<");
		atras.setBackground(Color.black);
		Font fuenteA=new Font("Arial", Font.BOLD, 86);
		atras.setForeground(Color.decode("#049cff"));
		atras.setFont(fuenteA);
		atras.setBounds(1,1,1,1);
		atras.setSize(51,87);
		atras.setBorder(null);
		 botonAtras.add(atras);
		
		JButton adelante= new JButton(">");
		adelante.setBackground(Color.black);
		Font fuenteAd=new Font("Arial", Font.BOLD, 86);
		adelante.setForeground(Color.decode("#049cff"));
		adelante.setFont(fuenteA);
		adelante.setBounds(1,1,1,1);
		adelante.setSize(51,87);
		adelante.setBorder(null);
		botonAdelante.add(adelante);
		
//En esta parte empieza el algoritmo que ayuda a recorrer las imagenes en el manual de usuario		
		Imagenes=new CardLayout(); 
		final JPanel ImagenPanel = new JPanel();
		 ImagenPanel.setLayout(null);
		 ImagenPanel.setBackground(Color.white);
		 ImagenPanel.setBounds(132,50,1105,500);
		 la =new JLabel[ nImagenes.length]; 
		 ap=new JPanel[icons.length];   
		 ImagenPanel.setLayout(Imagenes);
		
		 for(int z=0; z<nImagenes.length;z++){
			    la[z]=new JLabel(icons[z]); 
			    ap[z ]=new JPanel(); 
			    ap[z].add(la[z]);
			    ap[z].setBackground(Color.BLACK);
			    ImagenPanel.add(ap[z],String.valueOf(z));
			}
		
	//Botones para manejar el manual de usuario	 
		 adelante.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			 if (contar < nImagenes.length) {
			 contar += 1;
			 Imagenes.show( ImagenPanel,"" + (contar));
			 }
			 }
			 });
			
			 atras.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			 if (contar > 0) {
			 contar -= 1;
			 Imagenes.show( ImagenPanel, "" + (contar));
			 }
			 
			 
			 }
			 });
		bienvenido.add(ImagenPanel);
        return bienvenido;
    }

    public JPanel Maquinaria() {

        JPanel Maquinas = new JPanel();
        Maquinas.setLayout(null);
        Maquinas.setBackground(Color.black);


        String[] Cabecera = {"NOMBRE", "TIPO", "MODELO", "COSTO", "ESTADO", "PRECIO DE RENTA"};
        String[][] datos = {{"","","","","",""}};
        JTable MaquinasT = new JTable(datos, Cabecera);
        JScrollPane sc = new JScrollPane(MaquinasT);
        sc.setVisible(true);
        sc.setBounds(10, 70, 1336, 410);
        Maquinas.add(sc);

        JTextField busqueda= new JTextField();
        busqueda.setForeground(Color.black);
        busqueda.setBounds(463,15,400,30);
        Maquinas.add(busqueda);
        
        JButton Buscar = new JButton("BUSCAR");
        Buscar.setBackground(Color.black);
        //entrar.setBounds(110, 350, 150, 50);
        Buscar.setBorder(new ComponenteBotonRedondo(40));
        Buscar.setForeground(Color.decode("#049cff"));
        Buscar.setBounds(866, 15, 150, 30);
        Maquinas.add(Buscar);
       
        
        JButton Agregar = new JButton("Agregar");
        Agregar.setBackground(Color.black);
        Agregar.setBorder(new ComponenteBotonRedondo(40));
        Agregar.setForeground(Color.decode("#049cff"));
        Agregar.setBounds(350, 498, 150, 50);
        Maquinas.add(Agregar);
        
        JButton Editar = new JButton("Editar");
        Editar.setBackground(Color.black);
        Editar.setBorder(new ComponenteBotonRedondo(40));
        Editar.setForeground(Color.decode("#049cff"));
        Editar.setBounds(550, 498, 150, 50);
        Maquinas.add(Editar);
 
        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBackground(Color.black);
        Eliminar.setBorder(new ComponenteBotonRedondo(40));
        Eliminar.setForeground(Color.decode("#049cff"));
        Eliminar.setBounds(750, 498, 150, 50);
        Maquinas.add(Eliminar);
        
        JButton Autorizar = new JButton("Autorizar");
        Autorizar.setBackground(Color.black);
        Autorizar.setBorder(new ComponenteBotonRedondo(40));
        Autorizar.setForeground(Color.decode("#049cff"));
        Autorizar.setBounds(950, 498, 150, 50);
        Maquinas.add(Autorizar);
        
        return Maquinas;
        
       
     
        

    }

    public JPanel Obras() {

        JPanel Obras = new JPanel();
        Obras.setLayout(null);
        Obras.setBackground(Color.black);


        String[] Cabecera = {"NOMBRE DE LA OBRA", "NOMBRE DEL RESPONSABLE", "FECHA DE INICIO", "FECHA DE FINALIZACIÓN", "NÚMERO DEL RESPONSABLE", "INVERSIÓN $","NOMBRE DE LA EMPRESA","NUM DE MÁQUINAS RENTADAS"};
        String[][] datos = {{"","","","","","","",""}};
        JTable MaquinasT = new JTable(datos, Cabecera);
        JScrollPane sc = new JScrollPane(MaquinasT);
        sc.setVisible(true);
        sc.setBounds(10, 70, 1336, 410);
        Obras.add(sc);

        JTextField busqueda= new JTextField();
        busqueda.setForeground(Color.black);
        busqueda.setBounds(463,15,400,30);
        Obras.add(busqueda);
        
        JButton Buscar = new JButton("BUSCAR");
        Buscar.setBackground(Color.black);
        //entrar.setBounds(110, 350, 150, 50);
        Buscar.setBorder(new ComponenteBotonRedondo(40));
        Buscar.setForeground(Color.decode("#049cff"));
        Buscar.setBounds(866, 15, 150, 30);
        Obras.add(Buscar);
       
        
        JButton Agregar = new JButton("Agregar");
        Agregar.setBackground(Color.black);
        Agregar.setBorder(new ComponenteBotonRedondo(40));
        Agregar.setForeground(Color.decode("#049cff"));
        Agregar.setBounds(400, 498, 150, 50);
        Obras.add(Agregar);
        
        JButton Editar = new JButton("Editar");
        Editar.setBackground(Color.black);
        Editar.setBorder(new ComponenteBotonRedondo(40));
        Editar.setForeground(Color.decode("#049cff"));
        Editar.setBounds(600, 498, 150, 50);
        Obras.add(Editar);

        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBackground(Color.black);
        Eliminar.setBorder(new ComponenteBotonRedondo(40));
        Eliminar.setForeground(Color.decode("#049cff"));
        Eliminar.setBounds(800, 498, 150, 50);
        Obras.add(Eliminar);
        return Obras;
    }

    public JPanel Clientes() {
    	 JPanel Clientes = new JPanel();
         Clientes.setLayout(null);
         Clientes.setBackground(Color.black);

         String[] Cabecera = {"NOMBRE(S)", "CALLE", "NÚMERO", "COLONIA", "MUNICIPIO", "ESTADO","CORREO ELECTRÓNICO","NÚMERO TELEFÓNICO"};
         String[][] datos = {{"", "", "", "", "","", "",""}};
         JTable MaquinasT = new JTable(datos, Cabecera);
         JScrollPane sc = new JScrollPane(MaquinasT);
         sc.setVisible(true);
         sc.setBounds(10, 70, 1336, 410);
         Clientes.add(sc);

         JTextField busqueda= new JTextField();
         busqueda.setForeground(Color.black);
         busqueda.setBounds(463,15,400,30);
         Clientes.add(busqueda);
         
         JButton Buscar = new JButton("BUSCAR");
         Buscar.setBackground(Color.black);
         //entrar.setBounds(110, 350, 150, 50);
         Buscar.setBorder(new ComponenteBotonRedondo(40));
         Buscar.setForeground(Color.decode("#049cff"));
         Buscar.setBounds(866, 15, 150, 30);
         Clientes.add(Buscar);
        
         
         JButton Agregar = new JButton("Agregar");
         Agregar.setBackground(Color.black);
         Agregar.setBorder(new ComponenteBotonRedondo(40));
         Agregar.setForeground(Color.decode("#049cff"));
         Agregar.setBounds(400, 498, 150, 50);
         Clientes.add(Agregar);
         
         JButton Editar = new JButton("Editar");
         Editar.setBackground(Color.black);
         Editar.setBorder(new ComponenteBotonRedondo(40));
         Editar.setForeground(Color.decode("#049cff"));
         Editar.setBounds(600, 498, 150, 50);
         Clientes.add(Editar);

         JButton Eliminar = new JButton("Eliminar");
         Eliminar.setBackground(Color.black);
         Eliminar.setBorder(new ComponenteBotonRedondo(40));
         Eliminar.setForeground(Color.decode("#049cff"));
         Eliminar.setBounds(800, 498, 150, 50);
         Clientes.add(Eliminar);
         
        return Clientes;
    }

    public JPanel Finanzas() {
        Finanzas = new JPanel();
        Finanzas.setLayout(null);
        Finanzas.setBackground(Color.black);
        JLabel FinanzasMensaje = new JLabel("Gráficas de finanzas mesuales");
        FinanzasMensaje.setForeground(Color.white);
        Finanzas.add(FinanzasMensaje);
        
    	final JButton BotonGraf = new JButton();
		 BotonGraf.setLayout(null);
		 BotonGraf.setBorder(null);
		 BotonGraf.setBackground(Color.black);
		 BotonGraf.setBounds(132,50,1105,500);
		 BotonGraf.setIcon(Graficas);
    //Boton para abrir la ventana de los datos
	BotonGraf.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			Graficador g =new Graficador();
			g.setVisible(true);
			 }
			 
			 });
        Finanzas.add(BotonGraf);
        
        return Finanzas;
    }

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
