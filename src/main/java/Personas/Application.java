package Personas;

import Personas.presentation.Medico.Controller;
import Personas.presentation.Medico.Model;
import Personas.presentation.Medico.View;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {

        }

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        JFrame window = new JFrame();
        window.setSize(600,400);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Gestión de Médicos");
        window.setContentPane(view.getPanel());
        window.setVisible(true);
    }

    public static final Color BACKGROUND_ERROR = new Color(209, 102, 255, 255);
}
