package com.localworld.ishop.setting.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.EditAddressActivity;
import com.localworld.ishop.model.ReceivedAddress;

import java.util.List;

/**
 * Created by Even.P on 2018/1/29.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private List<ReceivedAddress> mReceivedAddressList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView addressReceiver;
        TextView addressMobile;
        TextView addressPostcode;
        TextView addressAddress;
        Button editAddressButton;

        public ViewHolder(View view){
            super(view);
            addressReceiver = (TextView)view.findViewById(R.id.tv_address_name);
            addressMobile = (TextView)view.findViewById(R.id.tv_address_tel);
            addressPostcode = (TextView)view.findViewById(R.id.tv_address_postcode);
            addressAddress = (TextView)view.findViewById(R.id.tv_address_received_address);
            editAddressButton = (Button)view.findViewById(R.id.btn_settings_edit_address);
        }
    }

    public AddressAdapter(List<ReceivedAddress> addressList){
        mReceivedAddressList = addressList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_settings_address_list, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.editAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = parent.getContext();
                Intent intent = new Intent(context, EditAddressActivity.class);
                intent.putExtra("Receiver", holder.addressReceiver.getText().toString());
                intent.putExtra("Mobile", holder.addressMobile.getText().toString());
                intent.putExtra("Postcode", holder.addressPostcode.getText().toString());
                intent.putExtra("Address", holder.addressAddress.getText().toString());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ReceivedAddress receivedAddress = mReceivedAddressList.get(position);
        holder.addressReceiver.setText(receivedAddress.getReceiver());
        holder.addressMobile.setText(receivedAddress.getMobile());
        holder.addressPostcode.setText(receivedAddress.getPostCode());
        holder.addressAddress.setText(receivedAddress.getAddress());
    }

    @Override
    public int getItemCount() {
        return mReceivedAddressList.size();
    }

//    public static final int COMMON_TYPE = 2001;
//    public static final int BOTTOM_TYPE = 2002;
//
//    public AddressAdapter (List<ReceivedAddress> receivedAddressList){
//        mReceivedAddressList = receivedAddressList;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (position >= 0 && position < getItemCount()) {
//            return mReceivedAddressList.get(position).type;
//        } else {
//            return -1;
//        }
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view;
//        RecyclerView.ViewHolder holder = null;
//        switch (viewType){
//            case COMMON_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings_address_list, parent, false);
////                Log.d(TAG, "onCreateViewHolder: "+ viewType);
//                holder = new IndexItemVH(view);
//            case BOTTOM_TYPE:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings_add_address, parent, false);
////                Log.d(TAG, "onCreateViewHolder: "+ viewType);
//                holder = new ButtonItemVH(view);
//            default:
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings_address_list, parent, false);
////                Log.d(TAG, "onCreateViewHolder: "+ viewType);
//        }
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
////        super.onBindViewHolder(holder, position, payloads);
//        if(holder instanceof IndexItemVH){
//            ReceivedAddress receivedAddress = mReceivedAddressList.get(position);
//            ((IndexItemVH)holder).addressReceiver.setText(receivedAddress.getReceiver());
//            ((IndexItemVH)holder).addressMobile.setText(receivedAddress.getMobile());
//            ((IndexItemVH)holder).addressPostcode.setText(receivedAddress.getPostCode());
//            ((IndexItemVH)holder).addressAddress.setText(receivedAddress.getAddress());
//        }else {
//            return;
//        }
//    }
//
//        @Override
//    public int getItemCount() {
//        return mReceivedAddressList.size();
//    }
//
//    public class IndexItemVH extends RecyclerView.ViewHolder{
//        TextView addressReceiver;
//        TextView addressMobile;
//        TextView addressPostcode;
//        TextView addressAddress;
//
//        public IndexItemVH(View view){
//            super(view);
//            addressReceiver = (TextView)view.findViewById(R.id.tv_address_name);
//            addressMobile = (TextView)view.findViewById(R.id.tv_address_tel);
//            addressPostcode = (TextView)view.findViewById(R.id.tv_address_postcode);
//            addressAddress = (TextView)view.findViewById(R.id.tv_address_received_address);
//        }
//
////        void bind(RecyclerView.ViewHolder holder) {
////            ((IndexItemVH)holder).addressReceiver.setText(receivedAddress.getReceiver());
////            ((IndexItemVH)holder).addressMobile.setText(receivedAddress.getMobile());
////            ((IndexItemVH)holder).addressPostcode.setText(receivedAddress.getPostCode());
////            ((IndexItemVH)holder).addressAddress.setText(receivedAddress.getAddress());
////        }
//    }
//
//    public class ButtonItemVH extends RecyclerView.ViewHolder{
//        public ButtonItemVH(View view){
//            super(view);
//        }
//        void bind(RecyclerView.ViewHolder holder){
//
//        }
//    }
}
