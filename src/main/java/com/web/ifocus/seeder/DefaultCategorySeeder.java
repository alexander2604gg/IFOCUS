package com.web.ifocus.seeder;

import com.web.ifocus.entity.DefaultCategory;
import com.web.ifocus.repository.DefaultCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DefaultCategorySeeder implements CommandLineRunner {

    private final DefaultCategoryRepository defaultCategoryRepository;

    public DefaultCategorySeeder(DefaultCategoryRepository defaultCategoryRepository) {
        this.defaultCategoryRepository = defaultCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (defaultCategoryRepository.count() == 0) {
            
            DefaultCategory cat1 = new DefaultCategory(null, "Mal hábito", "fa-exclamation-circle", "Categoría para hábitos negativos");
            DefaultCategory cat2 = new DefaultCategory(null, "Estudio", "fa-book", "Categoría para actividades académicas");
            DefaultCategory cat3 = new DefaultCategory(null, "Ejercicio", "fa-dumbbell", "Categoría para rutinas de ejercicio");
            DefaultCategory cat4 = new DefaultCategory(null, "Nutrición", "fa-apple-alt", "Categoría para hábitos alimenticios");
            DefaultCategory cat5 = new DefaultCategory(null, "Salud", "fa-heartbeat", "Categoría para cuidados de la salud");
            DefaultCategory cat6 = new DefaultCategory(null, "Productividad", "fa-briefcase", "Categoría para mejorar la productividad");
            DefaultCategory cat7 = new DefaultCategory(null, "Higiene", "fa-tooth", "Categoría para hábitos de higiene personal");
            DefaultCategory cat8 = new DefaultCategory(null, "Finanzas", "fa-wallet", "Categoría para temas financieros");
            DefaultCategory cat9 = new DefaultCategory(null, "Bienestar", "fa-smile", "Categoría para bienestar general");
            DefaultCategory cat10 = new DefaultCategory(null, "Social", "fa-users", "Categoría para actividades sociales");

          
            defaultCategoryRepository.saveAll(java.util.List.of(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));

            System.out.println("✅ Default Categories seeded successfully.");
        } else {
            System.out.println("ℹ️ Default Categories already exist, skipping seeding.");
        }
    }
}
