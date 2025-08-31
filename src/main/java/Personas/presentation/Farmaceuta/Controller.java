package Personas.presentation.Farmaceuta;

import Personas.logic.Farmaceuta;
import Personas.logic.Service;
import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    // ====== MÉTODOS CRUD ======

    // Crear farmaceuta
    public void createFarmaceuta(Farmaceuta f) throws Exception {
        Service.instance().createFarmaceuta(f);
        model.setCurrent(new Farmaceuta());
        model.setList(Service.instance().findAllFarmaceutas());
    }

    // Leer farmaceuta
    public void readFarmaceuta(String id) throws Exception {
        Farmaceuta temp = new Farmaceuta();
        temp.setId(id);
        try {
            Farmaceuta result = Service.instance().readFarmaceuta(temp);
            model.setCurrent(result);
        } catch (Exception ex) {
            model.setCurrent(new Farmaceuta());
            throw ex;
        }
    }

    // Borrar farmaceuta
    public void deleteFarmaceuta(String id) throws Exception {
        Service.instance().deleteFarmaceuta(id);
        model.setCurrent(new Farmaceuta());
        model.setList(Service.instance().findAllFarmaceutas());
    }

    // Limpiar formulario (reset current)
    public void clear() {
        model.setCurrent(new Farmaceuta());
    }

    // Obtener listado completo
    public List<Farmaceuta> getAll() {
        return Service.instance().findAllFarmaceutas();
    }
}
