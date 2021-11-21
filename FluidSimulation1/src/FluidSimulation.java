import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FluidSimulation extends JFrame implements MouseMotionListener, MouseListener {
    private Dimension dimension;
    private FluidCube fluidCube;

    FluidSimulation() {
        fluidCube = new FluidCube(256, 4, (float) 0.1, 0, 0);
        dimension = new Dimension(500, 500);
        setLayout(new FlowLayout());
        setSize(fluidCube.getWindowSize());
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        fluidCube.step();
//        fluidCube.fade();
        fluidCube.renderD(g, FluidSimulation.this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        fluidCube.addDensity(e.getX() / FluidCube.SCALE, e.getY() / FluidCube.SCALE, 100);
        fluidCube.addVelocity(e.getX() / FluidCube.SCALE, e.getY() / FluidCube.SCALE, 50, 50);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
