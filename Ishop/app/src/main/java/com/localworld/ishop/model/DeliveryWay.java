package com.localworld.ishop.model;



public class DeliveryWay {

    private Long id;

    private String name;

    private String code;

    private Double startWeight;

    private Double startFee;

    private Double incPrice;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getStartWeight() {
        return startWeight;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public Double getStartFee() {
        return startFee;
    }

    public void setStartFee(Double startFee) {
        this.startFee = startFee;
    }

    public Double getIncPrice() {
        return incPrice;
    }

    public void setIncPrice(Double incPrice) {
        this.incPrice = incPrice;
    }
}
