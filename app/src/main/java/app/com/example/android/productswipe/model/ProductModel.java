package app.com.example.android.productswipe.model;

import java.io.Serializable;

/**
 * Created by shuvam on 11-08-2016.
 */
public class ProductModel implements Serializable {
    private String productSellerName;
    private String productSellerPic;
    //private String productPrice;
    private String productImage;
    //private String productTitle;

    public String getProductSellerName(){
        return this.productSellerName;
    }

    public void setProductSellerName(String productSellerName){
        this.productSellerName = productSellerName;
    }

    public String getProductSellerPic(){
        return this.productSellerPic;
    }

    public void setProductSellerPic(String productSellerPic){
        this.productSellerPic = productSellerPic;
    }

    //public String getProductPrice(){
  //      return this.productPrice;
//    }

    //public void setProductPrice(String productPrice){
      //  this.productPrice = productPrice;
    //}

    public String getProductImage(){
        return this.productImage;
    }

    public void setProductImage(String productImage){
        this.productImage = productImage;
    }

    //public String getProductTitle(){
      //  return this.productTitle;
    //}

    //public void setProductTitle(String productTitle){
      //  this.productTitle = productTitle;
    //}
}


