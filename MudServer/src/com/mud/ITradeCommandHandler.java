package com.mud;

import com.mud.Entities.Item;

/**
 * Created by krzysiek on 2014-11-18.
 */
public interface ITradeCommandHandler {
    void EventTerminate();

    void EventSell(Item item, int price);
}
