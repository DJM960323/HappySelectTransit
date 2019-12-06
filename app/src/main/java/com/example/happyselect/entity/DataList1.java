package com.example.happyselect.entity;


import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

/**
 * Created on 2019-11-22.
 *
 * @author DengJianMing
 * @describe
 */
public class DataList1 extends LitePalSupport {

    private String itemText;



    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }




}
