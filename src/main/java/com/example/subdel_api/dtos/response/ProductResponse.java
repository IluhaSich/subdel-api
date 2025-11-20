package com.example.subdel_api.dtos.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Objects;

/**

 * Dto возвращающее продукт
 * @param id айди продукта
 * @param name название продукта
 * @param price цуна продукта
 */
@Relation(collectionRelation = "products", itemRelation = "product")
public class ProductResponse extends RepresentationModel<ProductResponse> {

    private Long id;
    private String name;
    private Double price;

    public ProductResponse() {}

    public ProductResponse(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, price);
    }
}
