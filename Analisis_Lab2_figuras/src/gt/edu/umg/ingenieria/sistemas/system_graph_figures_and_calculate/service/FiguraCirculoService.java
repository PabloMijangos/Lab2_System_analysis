package gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.service;
import gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.model.FiguraCirculoEntity;
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

public class FiguraCirculoService extends figurasgeometricas {
    FiguraCirculoEntity circulofigura = new FiguraCirculoEntity(); 
    Color ColorFigura = null;
    Color ColorBorde = null;
    public FiguraCirculoService() {

    }
     public void CrearFiguraCirculo(int radiofigura,String colorareafigura,String colorbordefigura) {   
         circulofigura.setRadiofigura(radiofigura);
         circulofigura.setColorareafigura(colorareafigura);
         circulofigura.setColorbordefigura(colorbordefigura);
          switch(circulofigura.getColoareafigura()){
            case "Negro":
                 ColorFigura = Color.BLACK;
            break;
            case "Rojo":
                ColorFigura = Color.RED;
            break;  
        }
         switch(circulofigura.getColorbordefigura()){
            case "Negro":
                 ColorBorde = Color.BLACK;
            break;
            case "Rojo":
                ColorBorde = Color.RED;
            break;  
        }
    }
    @Override 
    public float getAreafiguras() {
        // TODO implement here
          return (float) (Math.PI*Math.pow(circulofigura.getRadiofigura(), 2)); 
    }
     @Override 
    public float getPerimetrofiguras() {
        // TODO implement here
        return (float) (2*Math.PI*circulofigura.getRadiofigura());
    }
    @Override
    public void getdrawFigure(Graphics g) {
         Graphics2D g2d =(Graphics2D) g; 
        g2d.setColor(ColorFigura); 
        g2d.fillOval((int)(200-(circulofigura.getRadiofigura()/2)),(int)(200-(circulofigura.getRadiofigura()/2)), circulofigura.getRadiofigura(), circulofigura.getRadiofigura());
        g2d.setColor(ColorBorde);
        g2d.drawOval((int)(200-(circulofigura.getRadiofigura()/2)),(int)(200-(circulofigura.getRadiofigura()/2)), circulofigura.getRadiofigura(), circulofigura.getRadiofigura());
       
    }

    @Override
    public void getimage(String formato) {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g3d = bufferedImage.createGraphics();
        g3d.setColor(ColorFigura);
        g3d.fillOval((int)(200-(circulofigura.getRadiofigura()/2)),(int)(200-(circulofigura.getRadiofigura()/2)),circulofigura.getRadiofigura(), circulofigura.getRadiofigura());
        g3d.setColor(ColorBorde);
        g3d.drawOval((int)(200-(circulofigura.getRadiofigura()/2)),(int)(200-(circulofigura.getRadiofigura()/2)), circulofigura.getRadiofigura(), circulofigura.getRadiofigura());
        g3d.dispose(); 
         File file = new File("circulo."+formato);
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