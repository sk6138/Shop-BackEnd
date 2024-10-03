package com.sahil.Shop.Model;


public class CartRequest {

    private String userId;
    private CartItemDTO item;

    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CartItemDTO getItem() {
        return item;
    }

    public void setItem(CartItemDTO item) {
        this.item = item;
    }

    // Inner class for cart item details
    public static class CartItemDTO {
        private Long productId;
        private String productName;
        private Double price;
        private Integer quantity;
        private String image;

        // Getters and setters
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}

