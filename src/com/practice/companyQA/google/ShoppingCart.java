package com.practice.companyQA.google;

import java.util.*;

/**
 * Created by Prathap on 26 Jan, 2020
 *
 * There are three entities prodcutID, offerID, and Price.
 * Implement these three methods in the most efficient manner :
 * public class ShoppingCart {
 *
 * 	public void addOffer(long productID, long offerID, double price) {
 *        }
 *
 * 	public void removeOffer(long offerID) {
 *    }
 *
 * 	public long getClosestOffer(long productID, double price) {
 *    }
 *
 * }
 *
 * P1 - O1 - $300
 * P1 - O2 - $450
 * P2 - O3 - $50
 *
 * getClosestOffer(P1, 250) -> O1
 * getClosestOffer(P1, 500) -> O2
 *
 */
public class ShoppingCart {

    Map<Long, List<OfferProduct>> productMap = new HashMap<>();
    Map<Long,Long> offerProductMapping = new HashMap<>();

    public void addOffer(long productID, long offerID, double price) {
        if( !productMap.containsKey( productID)){
            productMap.put( productID, new ArrayList<>());
        }
        productMap.get(productID).add(OfferProduct.builder().offerId(offerID).price(price).productId(productID).build());
        offerProductMapping.put(offerID, productID);
    }

    public void removeOffer(long offerID) {
        long productId = offerProductMapping.remove( offerID);
        List<OfferProduct> offerProducts = productMap.get(productId);
        offerProducts.remove(OfferProduct.builder().offerId(offerID).build());
    }

    public long getClosestOffer(long productID, double price) {
        List<OfferProduct> offerProducts = productMap.get( productID);
        long offerId = Long.MAX_VALUE;
        double priceDiff = Long.MIN_VALUE;
        for( OfferProduct offerProduct : offerProducts ){
            if( price - offerProduct.price > priceDiff ){
                offerId = offerProduct.offerId;
                priceDiff = price - offerProduct.price;
            }
        }
        return offerId;
    }

    public static class OfferProduct {
        long productId;
        long offerId;
        double price;

        public OfferProduct() {}

        public OfferProduct(long productId, long offerId, double price) {
            this.productId = productId;
            this.offerId = offerId;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OfferProduct that = (OfferProduct) o;
            return offerId == that.offerId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(offerId);
        }

        public static OfferProductBuilder builder() {
            return new OfferProductBuilder();
        }

        static class OfferProductBuilder {
            static long productId;
            static long offerId;
            static double price;

            public OfferProductBuilder() {}

            public OfferProductBuilder(OfferProduct offerProduct) {
                this.price = offerProduct.price;
                this.productId = offerProduct.productId;
                this.offerId = offerProduct.offerId;
            }

            public OfferProductBuilder productId(long productId) {
                this.productId = productId;
                return this;
            }

            public OfferProductBuilder offerId(long offerId) {
                this.offerId = offerId;
                return this;
            }

            public OfferProductBuilder price(double price) {
                this.price = price;
                return this;
            }

            public static OfferProduct build() {
                OfferProduct offerProduct = new OfferProduct();
                offerProduct.productId = productId;
                offerProduct.price = price;
                offerProduct.offerId = offerId;
                return offerProduct;
            }
        }
    }
}


