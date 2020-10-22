package proyectoreceta;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;
import proyectoreceta.Lista;

public class Grafica extends javax.swing.JFrame implements ActionListener{
    JPanel fondo;
    JButton boton;
    JTextField cajaBus, cajaBus2;
    JLabel nombre, dificultad;
    
    Lista listadePostres= new Lista();
    public Grafica(){
        
        //fondo.setLayout(null);
        
        this.setSize(500,400);
        setTitle("Lista de Postres");
        this.setResizable(false);
        setLocationRelativeTo(null);
        fondo_interno();
        cajaBusqueda();
        botones();
        Toolkit logo = Toolkit.getDefaultToolkit();
        Image miIcono =logo.getImage("imagenes/logo.png");
        setIconImage(miIcono);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        cajaBusqueda2();
        
    }
    private void fondo_interno(){
        fondo= new JPanel();
        this.getContentPane().add(fondo);
        fondo.setLayout(null);
        JLabel titulo = new JLabel("LISTA DE POSTRES",SwingConstants.CENTER); 
        titulo.setBounds (180,30,280,40);
        titulo.setOpaque(true);
        titulo.setFont (new Font("lucida calligraphy", Font.BOLD , 24));
        fondo.add(titulo);
        
         JLabel imag =new JLabel();
        ImageIcon imagene = new ImageIcon("imagenes/logos.png");
        imag.setBounds(340,200,150,150);
        imag.setIcon(new ImageIcon(imagene.getImage().getScaledInstance(imag.getWidth(),imag.getHeight(),Image.SCALE_SMOOTH)));
        fondo.add(imag);
        
        JLabel image =new JLabel();
        ImageIcon imagen = new ImageIcon("imagenes/fondo.jpg");
        image.setBounds(0,0,500,400);
        image.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(image.getWidth(),image.getHeight(),Image.SCALE_SMOOTH)));
        fondo.add(image);
      
    }
    private void botones(){
        boton = new JButton ("AÑADIR");
        boton.setBounds (280,210,100,30);
        boton.setFont(new Font ("lucida calligraphy", Font.BOLD , 11));
        fondo.add (boton);
        boton.addActionListener(this);
        
        
    }public void actionPerformed(ActionEvent e){
        if(e.getSource() == boton ){
                if(estado()){
               JOptionPane.showMessageDialog(this,"receta ya existe en la base de datos");
            }
            
            else{
            JOptionPane.showMessageDialog(this,"postre agregado");
            }
        }
    }
    public boolean estado(){
            boolean existe = false;

            String nom = cajaBus.getText().toUpperCase(); //Todo en mayuscula
            
            int nivel = Integer. parseInt (cajaBus2.getText());
            existe = listadePostres.verificar(nom);
            if (existe){
                 existe= true;
            }else{
                listadePostres.agregar(nom,nivel);
                
                existe= false;
            }
            return existe;
        } 
    private void cajaBusqueda (){
        cajaBus = new JTextField("Nombre de receta");
        cajaBus.setBounds (240,100,200,30);
        fondo.add(cajaBus);
        
        

    }
   
     private void cajaBusqueda2 (){
        cajaBus2 = new JTextField("Dificultad");
        cajaBus2.setBounds (240,160,200,30);
        fondo.add(cajaBus2);
        
    }
    
    
    
}
