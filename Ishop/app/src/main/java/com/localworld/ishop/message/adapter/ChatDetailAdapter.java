package com.localworld.ishop.message.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.localworld.ishop.R;
import com.localworld.ishop.message.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.List;


public class ChatDetailAdapter extends RecyclerView.Adapter<ChatDetailAdapter.ViewHolder> {

    //    private Context mContext;

    public ImageView leftImg;
    private List<ChatMessage> mChatMessages;
    int x;
    int y;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_chatobj, parent, false);

        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       final ChatMessage chatMessage = mChatMessages.get(position);

        //  holder.titleImg.setImageResource(imgid);

        holder.time.setText(getSysTime(chatMessage.getTime()));
        if (chatMessage.getType() == chatMessage.TYPE_RECEIVED) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftImg.setImageResource(chatMessage.getImageId());
            holder.leftMsg.setText(chatMessage.getContent());
            holder.leftImg.setVisibility(View.VISIBLE);

        } else if (chatMessage.getType() == chatMessage.TYPE_SENT) {
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftImg.setVisibility(View.GONE);
            holder.leftMsg.setVisibility(View.GONE);
            holder.rightMsg.setText(chatMessage.getContent());

        }


    }

    @Override
    public int getItemCount() {
        return mChatMessages.size();
    }

//    private OnRecyclerViewItemLongClick mOnRecyclerViewItemLongClick;

    //    private final int TYPE_MSG_SEND = C.TYPE_MSG_SEND;              //
//    private final int TYPE_MSG_RECEIVE = C.TYPE_MSG_RECEIVE;          //
    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView titleImg;
        ImageView leftImg;
        Button reportBtn;
        TextView time;
        ImageView rightImg;

        public ViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.rl_message_left);
            rightLayout = (LinearLayout) view.findViewById(R.id.rl_message_right);
            leftMsg = (TextView) view.findViewById(R.id.tv_message_chatobj);
            rightMsg = (TextView) view.findViewById(R.id.tv_message_user);
            titleImg = view.findViewById(R.id.iv_message_title);
            leftImg = view.findViewById(R.id.iv_message_chatobj);
            time = view.findViewById(R.id.message_time);
            // rightImg = view.findViewById(R.id.iv_massage_user);
            reportBtn = view.findViewById(R.id.btn_message_report);

        }
    }

    private void showPopupWindow(View parent) {

    }

    public ChatDetailAdapter(List<ChatMessage> chatMessages) {
        mChatMessages = chatMessages;
    }

    /**
     * 根据long类型的时间戳，转换为一个String类型的描述性时间
     * 通话记录如果发生在今天：“15：30”
     * 发生在昨天：“昨天8:23”
     * 发生在前天：“前天4:56”
     * 更早：     “2016/04/15”
     *
     * @return
     */
    //timeStample是聊天记录发生的时间
    private String getSysTime(long timeStample) {
        //timeStample是聊天记录发生的时间

        //得到现在的时间戳
        long now = System.currentTimeMillis();
        //在java中,int类型的数进行除法运算,只能的整数,正是利用这一点,
        //在下列日期中,只要没过昨天24点,无论相差了1s还是23小时,除法得到的结果都是前一天,

        int day = (int) (now / 1000 / 60 / 60 / 24 - timeStample / 1000 / 60 / 60 / 24);
        switch (day) {
            //如果是0这则说明是今天,显示时间
            case 0:
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                return sdf.format(timeStample);
            //如果是1说明是昨天,显示昨天+时间
            case 1:
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                return "昨 天  " + sdf1.format(timeStample);
            //如果是1说明是前天,显示前天+时间
            case 2:
                SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                return "前 天  " + sdf2.format(timeStample);
            //结果大于2就只显示年月日
            default:
                SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
                return sdf3.format(timeStample);


        }


    }

}
