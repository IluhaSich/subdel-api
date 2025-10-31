package com.example.subdel_api.dtos.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**

 * DTO для ответа при получении информации о деликатесе.
 *
 * @param id айди деликатеса
 * @param name название деликатеса
 * @param price цена (в условной валюте)
 * @param mass масса продукта (в граммах)
 * @param proteins количество белков (г на 100 г)
 * @param fats количество жиров (г на 100 г)
 * @param carbohydrates количество углеводов (г на 100 г)
 * @param kcal калорийность (ккал на 100 г)
 * @param country страна происхождения
 * @param products список связанных продуктов (ингредиенты или состав)
 * @param createdAt дата добавления
 */
@Relation(collectionRelation = "delicacies", itemRelation = "delicacy")
public class DelicacyResponse extends RepresentationModel<DelicacyResponse> {

    private Long id;
    private String name;
    private Double price;
    private Double mass;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;
    private Double kcal;
    private String country;
    private List<ProductResponse> products;
    private LocalDateTime createdAt;

    protected DelicacyResponse() {
    }

    public DelicacyResponse(Long id, String name, Double price, Double mass, Double proteins, Double fats, Double carbohydrates, Double kcal, String country, List<ProductResponse> products, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mass = mass;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.kcal = kcal;
        this.country = country;
        this.products = products;
        this.createdAt = createdAt;
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

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DelicacyResponse that = (DelicacyResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(mass, that.mass) && Objects.equals(proteins, that.proteins) && Objects.equals(fats, that.fats) && Objects.equals(carbohydrates, that.carbohydrates) && Objects.equals(kcal, that.kcal) && Objects.equals(country, that.country) && Objects.equals(products, that.products) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, price, mass, proteins, fats, carbohydrates, kcal, country, products, createdAt);
    }
}
