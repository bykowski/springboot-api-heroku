package pl.bykowski.springbootapi.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.springbootapi.AnimalRepo;

@Route("AnimalsGui")
public class AnimalsGui extends VerticalLayout {

    AnimalRepo animalRepo;
    Label label = new Label();

    @Autowired
    public AnimalsGui(AnimalRepo animalRepo) {
        add(label);
        this.animalRepo = animalRepo;
        label.setText(animalRepo.findAll().toString());
    }



}
