package com.company;

public class Package {

    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent(){
        return content;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Package that = (Package) o;
        if (!content.equals(that.content)) return false;
        if (this.price != that.price) return false;

        return true;
    }

}
