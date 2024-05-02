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
import com.vaadin.flow.component.orderedlayout.FlexComponent;
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
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        FormLayout formLayout3Col = new FormLayout();
        H4 h4 = new H4();
        FormLayout formLayout2Col = new FormLayout();
        AvatarItem avatarItem = new AvatarItem();
        AvatarItem avatarItem2 = new AvatarItem();
        AvatarItem avatarItem3 = new AvatarItem();
        AvatarItem avatarItem4 = new AvatarItem();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h2.setText("Tarea métodos de conteo, permutaciones y combinaciones");
        h2.setWidth("max-content");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        h4.setText("Integrantes:");
        h4.setWidth("max-content");
        formLayout2Col.setWidth("100%");
        avatarItem.setWidth("min-content");
        setAvatarItemSampleData(avatarItem);
        avatarItem2.setWidth("min-content");
        setAvatarItemSampleData(avatarItem2);
        avatarItem3.setWidth("min-content");
        setAvatarItemSampleData(avatarItem3);
        avatarItem4.setWidth("min-content");
        setAvatarItemSampleData(avatarItem4);
        buttonPrimary.setText("Pagina Principal");
        getContent().setAlignSelf(FlexComponent.Alignment.END, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        getContent().add(formLayout3Col);
        formLayout3Col.add(h4);
        getContent().add(formLayout2Col);
        formLayout2Col.add(avatarItem);
        formLayout2Col.add(avatarItem2);
        formLayout2Col.add(avatarItem3);
        formLayout2Col.add(avatarItem4);
        getContent().add(buttonPrimary);
    }

    private void setAvatarItemSampleData(AvatarItem avatarItem) {
        avatarItem.setHeading("Aria Bailey");
        avatarItem.setDescription("Endocrinologist");
        avatarItem.setAvatar(new Avatar("Aria Bailey"));
    }
}
