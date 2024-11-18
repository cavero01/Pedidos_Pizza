package com.pizzacustomizer.config;

import com.pizzacustomizer.model.entity.Dia;
import com.pizzacustomizer.model.entity.Ingrediente;
import com.pizzacustomizer.model.entity.PizzaSize;
import com.pizzacustomizer.model.entity.PromocionDescuento;
import com.pizzacustomizer.model.entity.Receta;
import com.pizzacustomizer.broker.storage.ingrediente.IIngredienteStoragebroker;
import com.pizzacustomizer.broker.storage.pizzasize.IPizzaSizeStoragebroker;
import com.pizzacustomizer.broker.storage.promociondescuento.IPromocionDescuentoStoragebroker;
import com.pizzacustomizer.broker.storage.receta.IRecetaStoragebroker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final IPizzaSizeStoragebroker pizzaSizeStorageBroker;
    private final IIngredienteStoragebroker ingredienteStorageBroker;
    private final IPromocionDescuentoStoragebroker promocionDescuentoStorageBroker;
    private final IRecetaStoragebroker recetaStorageBroker;

    public DataLoader(IPizzaSizeStoragebroker pizzaSizeStorageBroker,
                      IIngredienteStoragebroker ingredienteStorageBroker,
                      IPromocionDescuentoStoragebroker promocionDescuentoStorageBroker,
                      IRecetaStoragebroker recetaStorageBroker) {
        this.pizzaSizeStorageBroker = pizzaSizeStorageBroker;
        this.ingredienteStorageBroker = ingredienteStorageBroker;
        this.promocionDescuentoStorageBroker = promocionDescuentoStorageBroker;
        this.recetaStorageBroker = recetaStorageBroker;
    }

    @Override
    @Transactional // Aseguramos que todos los métodos se ejecuten en una transacción
    public void run(String... args) throws Exception {
        loadPizzaSizes();
        loadIngredientes();
        loadPromociones();
        loadRecetas();
    }

    private void loadPizzaSizes() {
        if (pizzaSizeStorageBroker.findAll(PizzaSize.class).isEmpty()) {
            pizzaSizeStorageBroker.create(new PizzaSize(null, "Pequeña", 8.0));
            pizzaSizeStorageBroker.create(new PizzaSize(null, "Mediana", 12.0));
            pizzaSizeStorageBroker.create(new PizzaSize(null, "Grande", 15.0));
            System.out.println("Tamaños de pizza precargados.");
        }
    }

    private void loadIngredientes() {
        if (ingredienteStorageBroker.findAll(Ingrediente.class).isEmpty()) {
            ingredienteStorageBroker.create(new Ingrediente(null, "Queso", 1.5));
            ingredienteStorageBroker.create(new Ingrediente(null, "Tomate", 1.0));
            ingredienteStorageBroker.create(new Ingrediente(null, "Pepperoni", 2.0));
            ingredienteStorageBroker.create(new Ingrediente(null, "Champiñones", 1.5));
            System.out.println("Ingredientes precargados.");
        }
    }

    private void loadPromociones() {
        if (promocionDescuentoStorageBroker.findAll(PromocionDescuento.class).isEmpty()) {
            promocionDescuentoStorageBroker.create(new PromocionDescuento(null, "2x1", "Martes y Miércoles"));
            promocionDescuentoStorageBroker.create(new PromocionDescuento(null, "Delivery Gratis", "Jueves"));
            System.out.println("Promociones precargadas.");
        }
    }

    private void loadRecetas() {
        if (recetaStorageBroker.findAll(Receta.class).isEmpty()) {
            List<Ingrediente> ingredientes = ingredienteStorageBroker.findAll(Ingrediente.class);

            Receta margarita = new Receta(null, "Margarita", List.of(
                    findIngredienteByName(ingredientes, "Queso"),
                    findIngredienteByName(ingredientes, "Tomate")
            ));

            Receta pepperoni = new Receta(null, "Pepperoni", List.of(
                    findIngredienteByName(ingredientes, "Queso"),
                    findIngredienteByName(ingredientes, "Pepperoni")
            ));

            recetaStorageBroker.create(margarita);
            recetaStorageBroker.create(pepperoni);

            System.out.println("Recetas precargadas.");
        }
    }

    private void loadDiasYPremociones() {
    if (diaStorageBroker.findAll(Dia.class).isEmpty()) {
        PromocionDescuento promo2x1 = promocionDescuentoStorageBroker.create(new PromocionDescuento(null, "2x1", "Martes y Miércoles"));
        PromocionDescuento deliveryGratis = promocionDescuentoStorageBroker.create(new PromocionDescuento(null, "Delivery Gratis", "Jueves"));

        Dia lunes = new Dia(null, "Lunes", List.of());
        Dia martes = new Dia(null, "Martes", List.of(promo2x1));
        Dia miercoles = new Dia(null, "Miércoles", List.of(promo2x1));
        Dia jueves = new Dia(null, "Jueves", List.of(deliveryGratis));
        Dia viernes = new Dia(null, "Viernes", List.of());
        Dia sabado = new Dia(null, "Sábado", List.of());
        Dia domingo = new Dia(null, "Domingo", List.of());

        diaStorageBroker.create(lunes);
        diaStorageBroker.create(martes);
        diaStorageBroker.create(miercoles);
        diaStorageBroker.create(jueves);
        diaStorageBroker.create(viernes);
        diaStorageBroker.create(sabado);
        diaStorageBroker.create(domingo);

        System.out.println("Días y promociones precargados.");
    }
}


    private Ingrediente findIngredienteByName(List<Ingrediente> ingredientes, String name) {
        return ingredientes.stream()
                .filter(ing -> ing.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Ingrediente no encontrado: " + name));
    }
}
