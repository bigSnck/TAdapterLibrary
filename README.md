# TAdapterLibrary
RecyclerView专用通用的Adapter库，再也不用写ViewHolder了！！适配了多种布局
### 添加到Android studio<br>
##### Step1: 在根build.gradle中添加仓库：<br>

```
allprojects {
	repositories {
		
		maven { url 'https://jitpack.io' }
	}
}
```
##### 注意:maven { url "https://jitpack.io" }一定要放到 allprojects 里面不然更新不下来
#### Step2: 在工程中添加依赖：<br>
```
dependencies {
       implementation 'com.github.bigSnck:TAdapterLibrary:1.0.3'
}
```

### 具体使用Demo<br>
#### 使用例子<br>
```
//单一布局
public class ContentAdaper extends TBaseAdapter<String> {

    public ContentAdaper(Context context, List<String> data) {
        super(context, data, R.layout.adapter_content_item);
    }

    @Override
    public void convert(ViewHolder holder, String s) {

        holder.setText(R.id.item_tv_content, s);//直接可以设置文字内容
        TextView tv = (TextView) holder.getView(R.id.item_tv_content);//获取View

    }
}


//多种类型的布局
public class ContentMultAdaper extends TBaseAdapter<String> {

    public ContentMultAdaper(Context context, List<String> data) {
        super(context, data, new MultiTypeSupport() {
            @Override
            public int getLayout(Object item, int postion) {
                //设置不同类型的布局
                if(item.toString().contains("男男女女")){
                    return R.layout.adapter_content_item;
                }
                return R.layout.adapter_content1_item;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, String s) {

        holder.setText(R.id.item_tv_content, s);//直接可以设置文字内容
        TextView tv = (TextView) holder.getView(R.id.item_tv_content);//获取View

    }
}

```


