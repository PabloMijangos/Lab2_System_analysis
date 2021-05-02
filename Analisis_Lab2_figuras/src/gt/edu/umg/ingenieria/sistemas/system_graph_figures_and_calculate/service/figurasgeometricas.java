package gt.edu.umg.ingenieria.sistemas.system_graph_figures_and_calculate.service;

import java.awt.Graphics;
import java.util.*;

public abstract class figurasgeometricas {

    public figurasgeometricas() {
    }

    public float getAreafiguras() {
        // TODO implement here
        return 0.0f;
    }

    public float getPerimetrofiguras() {
        // TODO implement here
        return 0.0f;
    }

    public abstract void getdrawFigure(Graphics g) ;
    public abstract void getimage(String formato) ;
}