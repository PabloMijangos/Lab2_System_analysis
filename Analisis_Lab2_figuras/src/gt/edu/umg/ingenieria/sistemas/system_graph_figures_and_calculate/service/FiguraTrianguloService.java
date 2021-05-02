package gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.service;
import gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.model.FiguraTrianguloEntity;
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

public class FiguraTrianguloService extends figurasgeometricas {
     FiguraTrianguloEntity triangulofigura = new FiguraTrianguloEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;

    public FiguraTrianguloService() {
    }
    
    
     public void CrearFiguraTriangulo(int basefigura,int alturafigura,String colorareafigura,String colorbordefigura) {   
          triangulofigura.setAlturafigura(alturafigura);
          triangulofigura.setBasefigura(basefigura);
          triangulofigura.setColorareafigura(colorareafigura);
          triangulofigura.setColorbordefigura(colorbordefigura);
          switch(triangulofigura.getColoareafigura()){
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
         switch(triangulofigura.getColorbordefigura()){
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
          return (float) (triangulofigura.getBasefigura()*triangulofigura.getAlturafigura());  
    }

     @Override 
       public float getPerimetrofiguras() {
        // TODO implement here
          return (float) ((triangulofigura.getAlturafigura()*2)+(triangulofigura.getBasefigura()*1));
    }
       
       
       
       
    @Override
    public void getdrawFigure(Graphics g) {
         g.setColor(ColorBorde);
        int xpoints[] = {(int)(200-(triangulofigura.getBasefigura()/2)), (int)(200), (int)(200+(triangulofigura.getBasefigura()/2))};
        int ypoints[] = {(int)(200+(triangulofigura.getAlturafigura()/2)), (int)(200-triangulofigura.getAlturafigura()), (int)(200+(triangulofigura.getAlturafigura()/2))};
        int npoints = 3;
        g.drawPolygon(xpoints, ypoints, npoints);
        g.setColor(ColorFigura);
   
        g.fillPolygon(xpoints, ypoints, npoints); 
    }

    @Override
    public void getimage(String formato) {
          BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
           Graphics2D g3d = bufferedImage.createGraphics();
           g3d.setColor(ColorFigura);
           g3d.fillRect((int)(200-(triangulofigura.getAlturafigura()/2)), (int)(200-(triangulofigura.getBasefigura())), triangulofigura.getAlturafigura(), triangulofigura.getBasefigura());
           g3d.setColor(ColorBorde);
           g3d.drawRect((int)(200-(triangulofigura.getAlturafigura()/2)), (int)(200-(triangulofigura.getBasefigura())), triangulofigura.getAlturafigura(), triangulofigura.getBasefigura());
           g3d.dispose();
   File file = new File("triangulo."+formato);
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