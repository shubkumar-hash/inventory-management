package org.example;

public class Supplier {

    private static int counter = 0;

    private final int supplierId;
    private String name;
    private final String gstNumber;
    private String address;
    private String phoneNo;

    public Supplier(String name, String gstNumber, String address, String phoneNo) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Supplier name cannot be empty");
        }
        if (gstNumber == null || gstNumber.isBlank()) {
            throw new IllegalArgumentException("GST number cannot be empty");
        }
        if (phoneNo == null || phoneNo.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        this.supplierId = ++counter;
        this.name = name;
        this.gstNumber = gstNumber;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo == null || phoneNo.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Supplier [supplierId=" + supplierId + ", name=" + name + ", gstNumber=" + gstNumber + ", address="
                + address + ", phoneNo=" + phoneNo + "]";
    }

}

