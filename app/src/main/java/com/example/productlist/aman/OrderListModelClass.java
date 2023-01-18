package com.example.productlist.aman;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderListModelClass implements Parcelable {
    String productName, productPrice;
    int productImage;
    String fullAddress, upi;
    int priceInt, gst, shippingCharge;

    public OrderListModelClass(String productName, String productPrice, int productImage, String fullAddress, String upi, int priceInt, int gst, int shippingCharge) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.fullAddress = fullAddress;
        this.upi = upi;
        this.priceInt = priceInt;
        this.gst = gst;
        this.shippingCharge = shippingCharge;
    }

    protected OrderListModelClass(Parcel in) {
        productName = in.readString();
        productPrice = in.readString();
        productImage = in.readInt();
        fullAddress = in.readString();
        upi = in.readString();
        priceInt = in.readInt();
        gst = in.readInt();
        shippingCharge = in.readInt();
    }

    public static final Creator<OrderListModelClass> CREATOR = new Creator<OrderListModelClass>() {
        @Override
        public OrderListModelClass createFromParcel(Parcel in) {
            return new OrderListModelClass(in);
        }

        @Override
        public OrderListModelClass[] newArray(int size) {
            return new OrderListModelClass[size];
        }
    };

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public int getPriceInt() {
        return priceInt;
    }

    public void setPriceInt(int priceInt) {
        this.priceInt = priceInt;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public int getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(int shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(productName);
        parcel.writeString(productPrice);
        parcel.writeInt(productImage);
        parcel.writeString(fullAddress);
        parcel.writeString(upi);
        parcel.writeInt(priceInt);
        parcel.writeInt(gst);
        parcel.writeInt(shippingCharge);
    }
}
