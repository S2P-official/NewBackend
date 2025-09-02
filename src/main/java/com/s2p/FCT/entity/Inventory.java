package com.s2p.FCT.entity;

import java.util.UUID;

// import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stockCount;
    private String ageGroup;
    private String facebook;
    private String amazon;
    private String meesho;
    private String youtube;
    private String mrp;
    private String tax;
    private String aboutItem1;
    private String aboutItem2;
    private String aboutItem3;
    private String aboutItem4;
    private String aboutItem5;
    private String brand;
    private String toyFigureType;
    private String characteroftoy;
    private String modelName;
    private String modelNumber;
    private String manufacturer;
    private String theme;
    private String colours;
    private String occasion;
    private String material;
    private String additionalFeatures;
    private String areBatteriesRequired;
    private String status;
    private String originalPrice;
    private String subcategory;
    private Integer rating;
    private Integer reviews;
    private String specifications;
    private Boolean inStock;
    private Boolean isNew;
    private Boolean isOnSale;
    private String features;
    
    
    
 // Assuming you want to store image paths as a comma-separated string internally
    private String imagePaths;

    public String getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(String imagePaths) {
        this.imagePaths = imagePaths;
    }

    // Assuming quantityAvailable means stockCount (or create a separate field if different)
    public int getQuantityAvailable() {
        return stockCount != null ? stockCount : 0;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.stockCount = quantityAvailable;
    }

    // Assuming productName is same as name
    public String getProductName() {
        return name;
    }


    // Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getAmazon() {
        return amazon;
    }

    public void setAmazon(String amazon) {
        this.amazon = amazon;
    }

    public String getMeesho() {
        return meesho;
    }

    public void setMeesho(String meesho) {
        this.meesho = meesho;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getAboutItem1() {
        return aboutItem1;
    }

    public void setAboutItem1(String aboutItem1) {
        this.aboutItem1 = aboutItem1;
    }

    public String getAboutItem2() {
        return aboutItem2;
    }

    public void setAboutItem2(String aboutItem2) {
        this.aboutItem2 = aboutItem2;
    }

    public String getAboutItem3() {
        return aboutItem3;
    }

    public void setAboutItem3(String aboutItem3) {
        this.aboutItem3 = aboutItem3;
    }

    public String getAboutItem4() {
        return aboutItem4;
    }

    public void setAboutItem4(String aboutItem4) {
        this.aboutItem4 = aboutItem4;
    }

    public String getAboutItem5() {
        return aboutItem5;
    }

    public void setAboutItem5(String aboutItem5) {
        this.aboutItem5 = aboutItem5;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getToyFigureType() {
        return toyFigureType;
    }

    public void setToyFigureType(String toyFigureType) {
        this.toyFigureType = toyFigureType;
    }

    public String getCharacteroftoy() {
        return characteroftoy;
    }

    public void setCharacteroftoy(String characteroftoy) {
        this.characteroftoy = characteroftoy;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getColours() {
        return colours;
    }

    public void setColours(String colours) {
        this.colours = colours;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        this.additionalFeatures = additionalFeatures;
    }

    public String getAreBatteriesRequired() {
        return areBatteriesRequired;
    }

    public void setAreBatteriesRequired(String areBatteriesRequired) {
        this.areBatteriesRequired = areBatteriesRequired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Boolean getInStock() {
        return inStock;
    }

  public void setInStock(Boolean inStock) {
    // If null is passed, default to true
    this.inStock = (inStock != null) ? inStock : true;
}


    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = (isNew != null)? isNew :true;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = (isOnSale != null)? isOnSale:true;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}
