package gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.service;
import gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.model.FiguraRectanguloEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class FiguraRectanguloService extends figurasgeometricas {
 FiguraRectanguloEntity rectangulofigura = new FiguraRectanguloEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;
    public FiguraRectanguloService() {
        
        
    }
      public void CrearFiguraRectangulo(int basefigura,int alturafigura,String colorareafigura,String colorbordefigura) {   
          rectangulofigura.setAlturafigura(alturafigura);
          rectangulofigura.setBasefigura(basefigura);
          rectangulofigura.setColorareafigura(colorareafigura);
          rectangulofigura.setColorbordefigura(colorbordefigura);
          switch(rectangulofigura.getColoareafigura()){
            case "Negro":
                 ColorFigura = Color.BLACK;
            break;
            case "Rojo":
                ColorFigura = Color.RED;
            break;  
            case "Anaranjado":
                ColorFigura = Color.ORANGE;
            break;  
        }
         switch(rectangulofigura.getColorbordefigura()){
            case "Negro":
                 ColorBorde = Color.BLACK;
            break;
            case "Rojo":
                ColorBorde = Color.RED;
            break;  
             case "Anaranjado":
                ColorBorde = Color.ORANGE;
            break;  
        }
    }

      
      
      @Override 
       public float getAreafiguras() {
        // TODO implement here
          return (float) (rectangulofigura.getBasefigura()*rectangulofigura.getAlturafigura());  
    }
      
       @Override 
       public float getPerimetrofiguras() {
        // TODO implement here
          return (float) ((rectangulofigura.getAlturafigura()*2)+(rectangulofigura.getBasefigura()*2));
    }
      
      
      
      
      
      
      
    @Override
    public void getdrawFigure(Graphics g) {
            g.setColor(ColorFigura);
            g.fillRect((int)(200-(rectangulofigura.getAlturafigura()/2)), (int)(200-(rectangulofigura.getBasefigura()/2)), rectangulofigura.getAlturafigura(), rectangulofigura.getBasefigura());
            g.setColor(ColorBorde);
            g.drawRect((int)(200-(rectangulofigura.getAlturafigura()/2)), (int)(200-(rectangulofigura.getBasefigura()/2)), rectangulofigura.getAlturafigura(), rectangulofigura.getBasefigura());
    }
    
    
    
    

    @Override
    public void getimage(String formato) {
          BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
           Graphics2D g3d = bufferedImage.createGraphics();
           g3d.setColor(ColorFigura);
           g3d.fillRect((int)(200-(rectangulofigura.getAlturafigura()/2)), (int)(200-(rectangulofigura.getBasefigura()/2)), rectangulofigura.getAlturafigura(), rectangulofigura.getBasefigura());
           g3d.setColor(ColorBorde);
           g3d.drawRect((int)(200-(rectangulofigura.getAlturafigura()/2)), (int)(200-(rectangulofigura.getBasefigura()/2)), rectangulofigura.getAlturafigura(), rectangulofigura.getBasefigura());
           g3d.dispose();
           
      File file = new File("rectangulo."+formato);
        switch(formato){
            case "PNG":
                try {
                    ImageIO.write(bufferedImage, "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(FiguraCirculoService.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case "JPG":    
            try {
                ImageIO.write(bufferedImage, "jpg", file);
            } catch (IOException ex) {
                Logger.getLogger(FiguraCirculoService.class.getName()).log(Level.SEVERE, null, ex);
            }  
            break;  
        }
    }
    
    
    

}