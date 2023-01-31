package tn.inteldev.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private float cost;
    private String description;

    @OneToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany
    private List<ExtraIngredient> extraIngredients = new ArrayList<>();

    @OneToMany
    private List<Image> images;


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

    public void addExtraIngredient(ExtraIngredient extraIngredient) {
        this.cost += extraIngredient.getCost();
        this.extraIngredients.add(extraIngredient);
    }

    public void removeExtraIngredient(ExtraIngredient extraIngredient) {
        this.cost -= extraIngredient.getCost();
        this.extraIngredients.remove(extraIngredient);
    }
}
