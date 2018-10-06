package com.localworld.ishop.message.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.message.ChatObj;
import com.localworld.ishop.message.MessageDetailActivity;
import com.localworld.ishop.message.util.PopupWindowUtil;

import java.util.HashSet;
import java.util.List;

import static android.view.View.GONE;

public class ChatObjAdapter extends RecyclerView.Adapter<ChatObjAdapter.ViewHolder> {
    private List<ChatObj> mChatObjList;
    private PopupWindow mPopupWindow;
    private LayoutInflater mInflater;
    private Context mContext;
    public boolean isShow = false;
    private boolean isSelectAll;
    private HashSet<Integer> positionSet;
    private OnPopItemListener mOnPopItemListener;
    private View contentView;
    private View finalConvertView;
    private View itemview;
    // ChatObjAdapter adapter;

    int x;
    int y;

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {


        itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_chat, parent, false);

        final int layoutId = R.layout.popup_message;
        contentView = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);
        finalConvertView = itemview;
        final ViewHolder holder = new ViewHolder(itemview);
        //holder.checkBox.setVisibility(View.GONE);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ChatObj chatObj = mChatObjList.get(position);
        holder.chatImage.setImageResource(chatObj.getImageId());
        holder.chatObjMsg.setText(chatObj.getMessage());
        holder.chatObjName.setText(chatObj.getName());
        holder.chatObjTime.setText(chatObj.getTime());
        holder.checkBox.setChecked(chatObj.isSelect);
        if (!chatObj.isRead) holder.readPoint.setVisibility(View.VISIBLE);
        else holder.readPoint.setVisibility(GONE);

        //  holder.checkBox.setChecked(listCheck.get(position));
        if (isShow) {
            holder.checkBox.setVisibility(View.VISIBLE);
        } else {
            holder.checkBox.setVisibility(GONE);
        }



        holder.chatObjView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if(!isShow) {
                    readData(position);
                    //        ChatObj chatObj = mChatObjList.get(position);
                    Intent intent = new Intent(v.getContext(), MessageDetailActivity.class);
                    //String tname = ((TextView) v.findViewById(R.id.tv_message_name)).getText().toString();
                    intent.putExtra("chatObjName",chatObj.getName());
                    intent.putExtra("chatObjImg", chatObj.getImageId());
                    intent.putExtra("chatObjMsg",chatObj.getMessage());
//                    int tpic = holder.chatImage.getDrawable();
//                    intent.putExtra("chatObjImg",tpic);
                    //        intent.putExtra("leftImg",chatObj.getImageId());
                    //        intent.putExtra("name",chatObj.getName());
                    v.getContext().startActivity(intent);
                }
                else {

                }
            }
        });


        holder.chatObjView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (!isShow) {
                    mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                    // 如果不设置PopupWindow的背景，有些版本就会出现一个问题：无论是点击外部区域还是Back键都无法dismiss弹框
                    mPopupWindow.setBackgroundDrawable(new ColorDrawable());
                    // 设置好参数之后再show
                    int windowPos[] = PopupWindowUtil.calculatePopWindowPos(finalConvertView, contentView, x, y);
                    mPopupWindow.showAtLocation(finalConvertView, Gravity.TOP | Gravity.START, windowPos[0], windowPos[1]);

                    View.OnClickListener menuItemOnClickListener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mPopupWindow != null) {
                                mPopupWindow.dismiss();
                            }
                            switch (v.getId()) {

                                case R.id.item_message_del:
                                    //实现接口中的操作，这样我们可以在Recyclerview所在的活动中进行数据操作，而无需转入该类。

                                    removeData(position);
                                    break;
                                case R.id.item_message_select:
                                    //   position = holder.getAdapterPosition();
                                    isShowCheckBox(position);

                                    mChatObjList.get(position).isSelect = holder.checkBox.isChecked();
                                    mOnPopItemListener.onPopItemClick(itemview, position);


                                    //   holder.layoutBottom.setVisibility(View.VISIBLE);
                                    break;
                                case R.id.item_message_read:
                                    readData(position);
                                    break;
                                case R.id.item_message_top:
                                    topData(position);
                                    break;
                                default:
                                    break;

                            }

                        }
                    };
                    contentView.findViewById(R.id.item_message_del).setOnClickListener(menuItemOnClickListener);
                    contentView.findViewById(R.id.item_message_select).setOnClickListener(menuItemOnClickListener);
                    contentView.findViewById(R.id.item_message_read).setOnClickListener(menuItemOnClickListener);
                    contentView.findViewById(R.id.item_message_top).setOnClickListener(menuItemOnClickListener);


                    return false;
                }else{
                    return false;
            }
            }
        });

        holder.chatObjView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //   v.setBackgroundColor(Color.parseColor("#e9e9eb"));
                x = (int) event.getRawX();
                y = (int) event.getRawY();
                if (mPopupWindow != null && mPopupWindow.isShowing())
                    return true;
                return false;
            }
        });




        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatObj.isSelect = holder.checkBox.isChecked();
                mOnPopItemListener.checkBoxClick(position);
            }
        });


    }

    public void removeData(int position) {
        mChatObjList.remove(position);
        //删除动画
        notifyItemRemoved(position);
        //刷新
        notifyDataSetChanged();
    }

    public void topData(int position) {
        //获取当前item的对象
        ChatObj obj = mChatObjList.get(position);
        //删除当前item
        mChatObjList.remove(position);
        //将item插入到recycleView的头部
        mChatObjList.add(0, obj);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    public void readData(int position){
        ChatObj obj = mChatObjList.get(position);
        mChatObjList.get(position).isRead = true;
        notifyDataSetChanged();
    }

    public void isShowCheckBox(int position) {
        ChatObj obj = mChatObjList.get(position);
        //将第一次长按的item设为选中
        isShow =!isShow;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return mChatObjList.size();
    }

    public ChatObj getItem(int position) {
        return mChatObjList.get(position);
    }

    public void remove(ChatObj chatObj) {
        mChatObjList.remove(chatObj);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        View chatObjView;
        ImageView chatImage;
        TextView chatObjName;
        TextView chatObjMsg;
        TextView chatObjTime;
     //   LinearLayout layoutBottom;
        ImageView readPoint;

        //TextView chatObjTime1;
        CheckBox checkBox;
        View moreRoot;
        View moreImgv;

        public ViewHolder(View view) {

            super(view);
            chatObjView = view;
            chatImage = (ImageView) view.findViewById(R.id.iv_message_img);
            chatObjName = (TextView) view.findViewById(R.id.tv_message_name);
            chatObjMsg = (TextView) view.findViewById(R.id.tv_message_msg);
            chatObjTime = (TextView) view.findViewById(R.id.tv_message_time);
            checkBox = (CheckBox) view.findViewById(R.id.check_message);
           // layoutBottom = (LinearLayout) view.findViewById(R.id.layout_message_bottom);
            readPoint = view.findViewById(R.id.iv_message_hasRead);
        }
        //checkBox.setOnCheckedChangeListener(this);
    }

    public void setOnPopItemListener(OnPopItemListener onItemListener) {
        mOnPopItemListener = onItemListener;
    }

    public ChatObjAdapter(Context context, List<ChatObj> chatObjList) {
        this.mChatObjList = chatObjList;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public interface OnPopItemListener {
        void checkBoxClick(int position);

        void onItemClick(View view, int position);

        void onPopItemClick(View view, int position);
    }

}
