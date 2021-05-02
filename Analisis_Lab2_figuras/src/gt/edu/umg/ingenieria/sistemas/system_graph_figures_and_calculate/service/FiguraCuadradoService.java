package gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.service;
import gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.model.FiguraCuadradoEntity;
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

public class FiguraCuadradoService extends figurasgeometricas {
    FiguraCuadradoEntity cuadradofigura = new FiguraCuadradoEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;
    public FiguraCuadradoService() {
    }
    
      public void CrearFiguraCuadrado(int ladofigura,String colorareafigura,String colorbordefigura) {   
          cuadradofigura.setLadofigura(ladofigura);
          cuadradofigura.setColorareafigura(colorareafigura);
          cuadradofigura.setColorbordefigura(colorbordefigura);
          switch(cuadradofigura.getColoareafigura()){
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
         switch(cuadradofigura.getColorbordefigura()){
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
          return (float) (cuadradofigura.getLadofigura()*cuadradofigura.getLadofigura());  
    }
     @Override 
    public float getPerimetrofiguras() {
        // TODO implement here
        return (float) (cuadradofigura.getLadofigura()*4);
    }
    @Override
    public void getdrawFigure(Graphics g) {
            g.setColor(ColorFigura);
            g.fillRect((int)(200-(cuadradofigura.getLadofigura()/2)), (int)(200-(cuadradofigura.getLadofigura()/2)), cuadradofigura.getLadofigura(), cuadradofigura.getLadofigura());
             g.setColor(ColorBorde);
            g.drawRect((int)(200-(cuadradofigura.getLadofigura()/2)), (int)(200-(cuadradofigura.getLadofigura()/2)), cuadradofigura.getLadofigura(), cuadradofigura.getLadofigura());
    }

    @Override
    public void getimage(String formato) {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g3d = bufferedImage.createGraphics();
        g3d.setColor(ColorFigura);
        g3d.fillRect((int)(200-(cuadradofigura.getLadofigura()/2)), (int)(200-(cuadradofigura.getLadofigura()/2)), cuadradofigura.getLadofigura(), cuadradofigura.getLadofigura());
        g3d.setColor(ColorBorde);
        g3d.drawRect((int)(200-(cuadradofigura.getLadofigura()/2)), (int)(200-(cuadradofigura.getLadofigura()/2)), cuadradofigura.getLadofigura(), cuadradofigura.getLadofigura());
        g3d.dispose(); 
         File file = new File("cuadrado."+formato);
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