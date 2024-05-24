package com.example.skladinfo.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Order implements Parcelable, Serializable {

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("user_address")
    @Expose
    String addressUser;

    @SerializedName("user_name")
    @Expose
    String nameUser;

    @SerializedName("counter")
    @Expose
    int counterProduct;

    @SerializedName("title")
    @Expose
    String nameProduct;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("price")
    @Expose
    String priceProduct;

    @SerializedName("image")
    @Expose
    String modelImage;

    public Order(int id, String addressUser, String nameUser, int counterProduct, String nameProduct, String description, String priceProduct, String modelImage) {
        this.id = id;
        this.addressUser = addressUser;
        this.nameUser = nameUser;
        this.counterProduct = counterProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.modelImage = modelImage;
    }

    protected Order(Parcel in) {
        id = in.readInt();
        addressUser = in.readString();
        nameUser = in.readString();
        counterProduct = in.readInt();
        nameProduct = in.readString();
        description = in.readString();
        priceProduct = in.readString();
        modelImage = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getCounterProduct() {
        return counterProduct;
    }

    public void setCounterProduct(int counterProduct) {
        this.counterProduct = counterProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getModelImage() {
        return modelImage;
    }

    public void setModelImage(String modelImage) {
        this.modelImage = modelImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", addressUser='" + addressUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", counterProduct=" + counterProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", description='" + description + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", modelImage='" + modelImage + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(addressUser);
        dest.writeString(nameUser);
        dest.writeInt(counterProduct);
        dest.writeString(nameProduct);
        dest.writeString(description);
        dest.writeString(priceProduct);
        dest.writeString(modelImage);
    }
}