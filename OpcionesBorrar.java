//Esta es una ventana emergente para sustituir las otras se supone que JOption si acepta booleanos

import javax.swing.JOptionPane;

public class OpcionesBorrar{
    public static void main(String[] args){


        int Aviso = JOptionPane.showConfirmDialog(
            null,
            "�ESTAS SEGURO DE BORRAR LOS DATOS!?",
            "",
            JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
        

        if(Aviso == JOptionPane.YES_OPTION)
        {
        	   JOptionPane.showMessageDialog(null, "�SE HAN BORRADO LOS DATOS SATISFACTORIAMENTE!");
        	   /////Se debe reflejar que se borro la celda (la informacion de lo que se haya borrado y despues mandar a la principal)
        	   new PrincipalOriginal();
        }
        else
        {
        	
     //// Aqui te debe poner en la pesta�a donde pensabas eliminar algo en vista de que no se puede esta bien
        	//si solo arroja la interfaz principal
        new PrincipalOriginal();
   
        }
}
}