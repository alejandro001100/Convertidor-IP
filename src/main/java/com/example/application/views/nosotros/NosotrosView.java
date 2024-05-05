package com.example.application.views.nosotros;

import com.example.application.components.avataritem.AvatarItem;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Nosotros")
@Route(value = "nosotros", layout = MainLayout.class)
@Uses(Icon.class)
public class NosotrosView extends Composite<VerticalLayout> {

    public NosotrosView() {
        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");

        HorizontalLayout layoutRow = new HorizontalLayout();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");

        H2 h2 = new H2("Tarea métodos de conteo, permutaciones y combinaciones");
        layoutRow.add(h2);

        FormLayout formLayout3Col = new FormLayout();
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3)
        );

        H4 h4 = new H4("Integrantes:");
        formLayout3Col.add(h4);

        FormLayout formLayout2Col = new FormLayout();
        formLayout2Col.setWidth("100%");

        addAvatarItems(formLayout2Col);

        Button buttonPrimary = new Button("Pagina Principal");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> buttonPrimary.getUI().ifPresent(ui -> ui.navigate("")));

        content.add(layoutRow, formLayout3Col, formLayout2Col, buttonPrimary);
    }

    private void addAvatarItems(FormLayout layout) {
        String[] names = {"Alejandro Paqui", "Camila Torres", "Naomi Lizano", "Luis Tayupanta"};
        String[] occupations = {"Estudiante", "Estudiante", "Estudiante", "Estudiante"};

        for (int i = 0; i < names.length; i++) {
            AvatarItem avatarItem = new AvatarItem();
            avatarItem.setHeading(names[i]);
            avatarItem.setDescription(occupations[i]);
            avatarItem.setAvatar(new Avatar(names[i]));
            layout.add(avatarItem);
        }
    }
}

