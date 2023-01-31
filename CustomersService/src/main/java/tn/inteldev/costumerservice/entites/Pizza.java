package tn.inteldev.costumerservice.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.*;
import tn.inteldev.costumerservice.entites.enums.DoughType;
import tn.inteldev.costumerservice.entites.enums.PizzaSize;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String reference;

    private PizzaSize size;

    private DoughType doughType;

    private String Description;

    private String image;

    private double baseCost;

    private boolean customizable;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL)
    private List<PizzaIngredient> pizzaIngrediants;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}


