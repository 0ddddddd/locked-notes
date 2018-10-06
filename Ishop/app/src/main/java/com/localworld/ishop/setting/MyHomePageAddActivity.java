package com.localworld.ishop.setting;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.localworld.ishop.R;
import com.localworld.ishop.setting.bean.MyHomePageAddBean;


public class MyHomePageAddActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int CHOOSE_PHPTO = 2;
    private ImageView showImg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_myhomepage_add);
        initView();
    }

    private void initView() {
        ImageView back = findViewById(R.id.iv_setting_myhomepage_add_back);
        TextView push = findViewById(R.id.tv_setting_myhomepage_add_push);
        showImg = findViewById(R.id.iv_setting_myhomepage_add_show);
        ImageView addImg = findViewById(R.id.iv_setting_myhomepage_add_add);
        TextView addText = findViewById(R.id.tv_setting_myhomepage_add_text);
        back.setOnClickListener(this);
        push.setOnClickListener(this);
        addImg.setOnClickListener(this);
        addText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.iv_setting_myhomepage_add_back:
                finish();
                break;
            case R.id.tv_setting_myhomepage_add_push:
                Toast.makeText(view.getContext(),"发表成功",Toast.LENGTH_LONG).show();
                // todo 发帖
                break;
            case R.id.iv_setting_myhomepage_add_add:
                //todo 添加发帖图片 调用相册
                if(ContextCompat.checkSelfPermission(MyHomePageAddActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MyHomePageAddActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else {
                    //打开相册
                    openAlbum();
                }

                break;
            case R.id.tv_setting_myhomepage_add_text:
                //todo 添加发帖文字
                break;
            default:
                break;
        }
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent,CHOOSE_PHPTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(this,"没有权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case CHOOSE_PHPTO:
                if(resultCode == RESULT_OK){
                    //判断手机系统版本
                    if(Build.VERSION.SDK_INT >= 19){
                        //4.4以上版本
                        handleImageOnKitKat(data);
                    }else{
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)){
            //如果是documen类型的uri，则通过document id 处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docId.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docId));
                imagePath = getImagePath(contentUri,null);
            }
        }else if("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的uri,则使用普通方式处理
            imagePath = getImagePath(uri,null);
        }else if("file".equalsIgnoreCase(uri.getScheme())){
            //如果为file类型，直接获取图片路径
            imagePath = uri.getPath();
        }
        //根据图片路径显示图片
        displayImage(imagePath);
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        MyHomePageAddBean picsPath = new MyHomePageAddBean();
        String imagePath = getImagePath(uri,null);
        picsPath.pics = imagePath;
        displayImage(imagePath);
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if(imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            showImg.setImageBitmap(bitmap);
            showImg.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(this,"图片不存在",Toast.LENGTH_LONG).show();
        }
    }

}
