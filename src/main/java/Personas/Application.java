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
            ex.printStackTrace();
        }


        //ESTO ES DE MEDICO
        View medicoView = new View();
        Model medicoModel = new Model();
        Controller medicoController = new Controller(medicoView, medicoModel);

       //ESTO ES DE FARMACEUTA, sin embargo no puedo hacer la implementacion tan directa porque por algun no motivo no me deja hacer el puto import de Farmaceutas
        Personas.presentation.Farmaceuta.View farmView = new Personas.presentation.Farmaceuta.View();
        Personas.presentation.Farmaceuta.Model farmModel = new Personas.presentation.Farmaceuta.Model();
        Personas.presentation.Farmaceuta.Controller farmController = new Personas.presentation.Farmaceuta.Controller(farmView, farmModel);


        JFrame window = new JFrame("Gestión de Personal");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ---PESTANAS
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Médicos", medicoView.getPanel());
        tabs.addTab("Farmaceutas", farmView.getPanel());

        window.setContentPane(tabs);
        window.setVisible(true);
    }

    public static final Color BACKGROUND_ERROR = new Color(209, 102, 255, 255);
}
