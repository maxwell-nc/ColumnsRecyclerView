# ColumnsRecyclerView
Android Multi-column list view desgin with RecyclerView, usually used to show stocks(shares).

# Usage
layout:
```xml
<com.github.maxwell.nc.library.view.ColumnsRecyclerView
    android:id="@+id/rv_container"
    android:layout_width="match_parent"
    android:layout_height="400dp" />
```
code:
```java
ColumnsRecyclerView rvContainer = (ColumnsRecyclerView) findViewById(R.id.rv_container);
rvContainer.setAdapter(new SampleAdapter(this));
```
SampleAdapter code was too long,just read the sample from the source code.

# Preview
![gif](https://github.com/maxwell-nc/ColumnsRecyclerView/blob/master/preview.gif?raw=true)

# Notice
This view will load list data in once,so if you need load many data,your should desgin a paging logic to controll it or it will be to slow to load.