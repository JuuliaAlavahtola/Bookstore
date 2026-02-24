package hh.sof03.bookstore.domain;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long categoryid;
private String category;

@OneToMany (cascade = CascadeType.MERGE, mappedBy = "category")
private List<Book> books;


public Category() {}


public Long getCategoryid() {
    return categoryid;
}

public void setCategoryid(Long categoryid) {
    this.categoryid = categoryid;
}

public String getName() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

@Override
public String toString() {
    return "Category [categoryid=" + categoryid + ", category=" + category + "]";
}

}
