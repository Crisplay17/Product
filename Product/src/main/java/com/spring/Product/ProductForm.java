package com.spring.Product;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Route("products/form")
@UIScope
@SpringComponent
@Component
public class ProductForm extends VerticalLayout {
    private final ProductService productService;

    private TextField nameField;
    private TextField priceField;
    private TextField quantityField;
    private TextField descriptionField;

    public ProductForm(ProductService productService) {
        this.productService = productService;

        FormLayout formLayout = new FormLayout();

        nameField = new TextField("Nume produs");
        priceField = new TextField("Pret produs");
        quantityField = new TextField("Cantitate produs");
        descriptionField = new TextField("Descriere produs");

        Button saveButton = new Button("Salvează", event -> saveProduct());

        formLayout.add(nameField, priceField, quantityField, descriptionField, saveButton);
        add(formLayout);
    }

    private void saveProduct() {
        String name = nameField.getValue();
        double price = Double.parseDouble(priceField.getValue());
        int quantity = Integer.parseInt(quantityField.getValue());
        String description = descriptionField.getValue();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescription(description);

        productService.createProduct(product);

        Notification.show("Produsul a fost salvat cu succes");
        clearFields();
    }

    private void clearFields() {
        nameField.clear();
        priceField.clear();
        quantityField.clear();
        descriptionField.clear();
    }
}







/*

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


@Route("")
@UIScope
public class ProductForm extends Div {
    private final ProductService productService;

    private TextField nameField;
    private TextField priceField;
    private TextField quantityField;
    private TextField descriptionField;

    @Autowired
    public ProductForm(ProductService productService) {
        this.productService = productService;

        // Configurează aspectul și comportamentul formularului
        FormLayout formLayout = new FormLayout();

        nameField = new TextField("Nume produs");
        priceField = new TextField("Pret produs");
        quantityField = new TextField("Cantitate produs");
        descriptionField = new TextField("Descriere produs");

        Button saveButton = new Button("Salvează", event -> saveProduct());

        formLayout.add(nameField, priceField, quantityField, descriptionField, saveButton);
        add(formLayout);
    }

    private void saveProduct() {
        // Obțineți valorile introduse de utilizator
        String name = nameField.getValue();
        double price = Double.parseDouble(priceField.getValue());
        int quantity = Integer.parseInt(quantityField.getValue());
        String description = descriptionField.getValue();

        // Creați un obiect Product cu valorile introduse
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setDescription(description);

        // Salvați produsul în backend folosind serviciul ProductService
        UI.getCurrent().navigate("products");

        // Afișați o notificare pentru confirmarea salvării
        Notification.show("Produsul a fost salvat cu succes");
    }
    private void clearFields() {
        nameField.clear();
        priceField.clear();
        quantityField.clear();
        descriptionField.clear();
    }
} */



