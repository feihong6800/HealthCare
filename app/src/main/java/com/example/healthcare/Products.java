package com.example.healthcare;

class Products {
    private String title;
    private String info;
    private String detail;

    private final int imageResource;

    Products(String title, String info, String detail, int imageResource) {
        this.title = title;
        this.info = info;
        this.detail = detail;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    String getDetail()
    {
        return detail;
    }

    public int getImageResource()
    {
        return imageResource;
    }
}
