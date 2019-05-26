package pl.bykowski.springbootapi.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.springbootapi.AnimalRepo;


@Route("AnimalDeleteGui")
public class AnimalDeleteGui extends VerticalLayout {

    AnimalRepo animalRepo;

    TextField textField = new TextField("podaj id");
    Button button = new Button("usun");

    @Autowired
    public AnimalDeleteGui(AnimalRepo animalRepo) {

        add(textField, button);
        this.animalRepo = animalRepo;

        button.addClickListener(click -> {
            animalRepo.deleteById(Long.parseLong(textField.getValue()));
        });
    }
}
