package it.unibs.pajc.graphicomponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaintArea extends JPanel implements MouseMotionListener {
    private int paintCount = 0;

    public PaintArea() {
        this.addMouseMotionListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

		/*
		g.drawLine(0, 0, w, h);
		g.setColor(Color.BLUE);
		g.drawRect((w-100)/2, (h-100)/2, 100, 100);
		g.fillRect((w-50)/2, (h-50)/2, 50, 50);
		*/

        int cellSize = (w < h) ? w / 8 : h / 8;

        g.setColor(Color.white);
        g.fillRect(0, 0, cellSize * 8, cellSize * 8);
        g.setColor(Color.black);
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i+j) % 2 != 0) {
                    g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                }
            }
        }

        // disegnare la posizine del mouse
        if(mousePosition != null) {
            g.setColor(Color.red);
            g.fillOval(mousePosition.x, mousePosition.y, 30, 30);
        }

        g.drawString("" + paintCount++, 10, 10);
    }


    Point mousePosition = null;
    public void mouseMoved(MouseEvent e) {
        mousePosition = e.getPoint(); // x, y

        this.repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
