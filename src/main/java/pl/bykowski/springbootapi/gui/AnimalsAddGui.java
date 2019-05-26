package pl.bykowski.springbootapi.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.bykowski.springbootapi.Animal;
import pl.bykowski.springbootapi.AnimalRepo;


@Route("AnimalsAddGui")
public class AnimalsAddGui extends VerticalLayout {

    AnimalRepo animalRepo;
    TextField textFieldName = new TextField("podaj imie");
    TextField textFieldAge = new TextField("podaj wiek");
    Button button = new Button("dodaj");

    @Autowired
    public AnimalsAddGui(AnimalRepo animalRepo) {
        add(textFieldName, textFieldAge, button);
        this.animalRepo = animalRepo;

        button.addClickListener(click -> {
            Animal animal = new Animal();
            animal.setAge(Integer.parseInt(textFieldAge.getValue()));
            animal.setName(textFieldName.getValue());
            animalRepo.save(animal);
        });
    }
}
