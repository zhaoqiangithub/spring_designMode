package com.zq.designdemo.delegate;

public class Dispatcher implements IDelegate{

    private IDelegate delegate;

    public Dispatcher(IDelegate iDelegate){
        this.delegate = iDelegate;
    }

    @Override
    public void doing() {
        delegate.doing();
    }
}
