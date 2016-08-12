package app.com.example.android.productswipe.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.com.example.android.productswipe.R;
import app.com.example.android.productswipe.model.ProductModel;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shuvam on 11-08-2016.
 */
public class ProductSwipeAdapter extends ArrayAdapter {
    private Context context;
    private List<ProductModel> productModelList;

    public ProductSwipeAdapter(Context context,int resourceId, List<ProductModel> productModelList){
        super(context,resourceId,productModelList);
        this.context = context;
        this.productModelList = productModelList;
    }

    private class ViewHolder{
        TextView sellerName;
        CircleImageView sellerPic;
        ImageView productImage;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        //ProductModel productModel = (ProductModel) productModelList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item,parent,false);
            holder = new ViewHolder();
            holder.productImage = (ImageView) convertView.findViewById(R.id.productimage);
            holder.sellerName = (TextView) convertView.findViewById(R.id.sellername);
            holder.sellerPic = (CircleImageView) convertView.findViewById(R.id.sellerpic);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        ProductModel productModel = (ProductModel) this.productModelList.get(position);
        Picasso.with(this.context).load(productModel.getProductSellerPic()).placeholder((int) R.drawable.ic_android).fit().centerCrop().into(holder.sellerPic);
        //holder.productPrice.setText(productModel.getProductPrice());
        holder.sellerName.setText(productModel.getProductSellerName());
        Picasso.with(this.context).load(productModel.getProductImage()).placeholder((int) R.drawable.skull).fit().centerCrop().into(holder.productImage);
        return convertView;

    }

}

