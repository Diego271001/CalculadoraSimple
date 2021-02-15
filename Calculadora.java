import javax.swing.*;
import java.awt.event.*;

public class Calculadora extends JFrame{
   static double resultado;
   JPanel panel;
   JTextField num1;
   JTextField num2;
   JTextField res;
   JTextField operacion;
   JLabel letrero;
   JButton btnSuma;
   JButton btnResta;
   JButton btnMult;
   JButton btnDivision;
   JButton btnAns;
   JButton btnSalir;
   JButton btnIgual;
   
   
    public Calculadora(){
       initComponents();
    }
   
    private void initComponents(){
      setSize(280, 200);
      num1 = new JTextField(10);
      operacion = new JTextField(1);
      operacion.setEditable(false);
      num2 = new JTextField(10);
      letrero = new JLabel("  Resultado  ");
      res = new JTextField(20);
      res.setEditable(false);
      btnSuma = new JButton("      +      ");
      btnResta = new JButton("  -  ");
      btnMult = new JButton("  *  ");
      btnDivision = new JButton("  /  ");
      btnIgual = new JButton ("     =     ");
      btnAns = new JButton (" Ans ");
      btnSalir = new JButton("Salir");
      
      btnSuma.addMouseListener(new Suma());
      btnResta.addMouseListener(new Resta());
      btnMult.addMouseListener(new Multiplicacion());
      btnDivision.addMouseListener(new Division());
      btnIgual.addMouseListener(new Igual());
      btnSalir.addMouseListener(new Salir());
      btnAns.addMouseListener(new Ans());
      
      panel = new JPanel();
      setTitle("Calculadora Diego Alatorre");
      panel.add(num1);
      panel.add(operacion);
      panel.add(num2);
      panel.add(letrero);
      panel.add(res);
      panel.add(btnSuma);
      panel.add(btnResta);
      panel.add(btnMult);
      panel.add(btnDivision);
      panel.add(btnAns);
      panel.add(btnIgual);
      panel.add(btnSalir);
      setContentPane(panel);
      setVisible(true);
    }
    
    private class Suma extends MouseAdapter{
    double n1=0,n2=0;
    
    
    public void mouseClicked(MouseEvent event){
       if( num1.getText().equals("") || num2.getText().equals(""))
               JOptionPane.showMessageDialog(null, "Un campo esta vacio =)","ERROR", JOptionPane.WARNING_MESSAGE);
       else{
         try{  
            operacion.setText("  + ");
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
            
               resultado = n2 + n1;
            
            
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Un valor ingresado es incorrecto");
            num1.setText(null);
            num2.setText(null);   
         }
          
       }
    }
  }
  
  private class Resta extends MouseAdapter{
    double n1=0,n2=0;
    
    
    public void mouseClicked(MouseEvent event){
       if( num1.getText().equals("") || num2.getText().equals(""))
               JOptionPane.showMessageDialog(null, "Un campo esta vacio =)","ERROR", JOptionPane.WARNING_MESSAGE);
       else{
         try{  
            operacion.setText("  - ");
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
            resultado = n1-n2;
            
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Un valor ingresado es incorrecto");
            num1.setText(null);
            num2.setText(null);   
         }
          
       }
    }
  }
  
  private class Multiplicacion extends MouseAdapter{
    double n1=0,n2=0;
    
    
    public void mouseClicked(MouseEvent event){
      if( num1.getText().equals("") || num2.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Un campo esta vacio =)","ERROR", JOptionPane.WARNING_MESSAGE);
      else{
         try{  
            operacion.setText("  * ");
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
            resultado = n1*n2;
            
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Un valor ingresado es incorrecto");
            num1.setText(null);
            num2.setText(null);   
         }
          
       }
     }
  }
  
  private class Division extends MouseAdapter{
    double n1=0,n2=0;
    
    
    public void mouseClicked(MouseEvent event){
      if(num1.getText().equals("") || num2.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Un campo esta vacio =)","ERROR", JOptionPane.WARNING_MESSAGE);
      else{
         try{  
            operacion.setText("  / ");
            n1 = Double.parseDouble(num1.getText());
            n2 = Double.parseDouble(num2.getText());
            
            if(n2 == 0){
               JOptionPane.showMessageDialog(null, "Division entre cero","ERROR", JOptionPane.WARNING_MESSAGE);
            }else
               resultado = n1/n2;
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Un valor ingresado es incorrecto");
            num1.setText(null);
            num2.setText(null);  
         }
          
       }
     }
  }
  
  
  
  private class Igual extends MouseAdapter{
    
    public void mouseClicked(MouseEvent event){         
         if(operacion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Un campo esta vacio","ERROR", JOptionPane.WARNING_MESSAGE);
         }else{
            res.setText(String.valueOf(resultado));
            num1.setText(null);
            num1.requestFocus();
            num2.setText(null);
   
            operacion.setText(null);
            //resultado=0;
         }
    }
  }
  
  private class Salir extends MouseAdapter{
    public void mouseClicked(MouseEvent event){

         JOptionPane.showMessageDialog(null, "Diego Alatorre Diaz ;)","PROGRAMADOR", JOptionPane.WARNING_MESSAGE);
         System.exit(0);
      
    }
  }
  
  private class Ans extends MouseAdapter{
    public void mouseClicked(MouseEvent event){
      if(resultado==0){
         JOptionPane.showMessageDialog(null, "Aun no se realizan operaciones o el valor guardado es 0","ERROR", JOptionPane.WARNING_MESSAGE);
      }else{
         num1.setText(String.valueOf(resultado));
         num2.setText(null);
         num2.requestFocus();
         operacion.setText(null);
      }   
    }
  }

}
