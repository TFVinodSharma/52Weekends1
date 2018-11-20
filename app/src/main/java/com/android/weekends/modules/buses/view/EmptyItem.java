package com.android.weekends.modules.buses.view;

public class EmptyItem extends AbstractItem {

    public EmptyItem(String label) {
        super(label);
    }


    @Override
    public int getType() {
        return TYPE_EMPTY;
    }

}
