# TAdapterLibrary
RecyclerView专用通用的Adapter库，再也不用谢ViewHolder了！！
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
       implementation 'com.github.bigSnck:TAdapterLibrary:1.0.1'
}
```

### 具体使用Demo<br>
#### 使用例子<br>
```
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
```


