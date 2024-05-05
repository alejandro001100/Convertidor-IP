package com.example.application.views.paginaprincipal;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@PageTitle("Página Principal")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class PaginaPrincipalView extends Composite<VerticalLayout> {

    public PaginaPrincipalView() {
        VerticalLayout contenido = getContent();
        contenido.setSizeFull();
        contenido.setAlignItems(FlexComponent.Alignment.START);
        contenido.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        H2 title = new H2("Bienvenido al convertidor de direcciones IP");
        TextField ipInput = new TextField("Ingrese una dirección IP");
        ipInput.setPlaceholder("Ejemplo: 192.168.1.1");

        ComboBox<String> conversionType = new ComboBox<>("Tipo de Conversión");
        conversionType.setItems("Binario", "Decimal", "Hexadecimal");
        conversionType.setPlaceholder("Selecciona el tipo");

        TextArea resultArea = new TextArea("Resultado");
        resultArea.setWidth("300px");
        resultArea.setReadOnly(true);

        Button convertButton = new Button("Convertir", e -> convertirDireccionIP(ipInput.getValue(), conversionType.getValue(), resultArea));
        convertButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(ipInput, "Dirección IP");
        formLayout.addFormItem(conversionType, "Tipo de Conversión");
        formLayout.addFormItem(convertButton, "");
        formLayout.addFormItem(resultArea, "Resultado de la Conversión");

        contenido.add(title, new Hr(), formLayout);
    }

    private void convertirDireccionIP(String ip, String tipoConversion, TextArea resultArea) {
        if (ip.isEmpty() || tipoConversion == null) {
            resultArea.setValue("Por favor complete todos los campos.");
            return;
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            byte[] bytes = inetAddress.getAddress();
            String resultado = switch (tipoConversion) {
                case "Binario" -> convertirABinario(bytes);
                case "Decimal" -> convertirADecimal(bytes);
                case "Hexadecimal" -> convertirAHexadecimal(bytes);
                default -> "Tipo de conversión no soportado.";
            };
            resultArea.setValue(resultado);
            Dialog dialog = new Dialog();
            dialog.add(new Label("La conversión a " + tipoConversion + " se ha realizado exitosamente."));
            dialog.open();
        } catch (UnknownHostException e) {
            resultArea.setValue("Dirección IP no válida.");
        }
    }

    private String convertirABinario(byte[] bytes) {
        return IntStream.range(0, bytes.length)
                .mapToObj(i -> String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0'))
                .collect(Collectors.joining("."));
    }

    private String convertirADecimal(byte[] bytes) {
        long resultado = 0;
        for (int i = 0; i < bytes.length; i++) {
            resultado = (resultado << 8) + (bytes[i] & 0xFF);
        }
        return String.valueOf(resultado);
    }

    private String convertirAHexadecimal(byte[] bytes) {
        return IntStream.range(0, bytes.length)
                .mapToObj(i -> String.format("%02X", bytes[i]))
                .collect(Collectors.joining("."));
    }
}
