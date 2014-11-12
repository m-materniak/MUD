package com.mud;

import com.mud.Entities.GameElement;
import com.mud.Entities.Item;

import java.util.Collection;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-10.
 */
public class CollectionHelper {
    public static String DescribeCollection(String collectionName, Collection<? extends GameElement> collection) {
        if (collection.isEmpty())
            return "";
        String description = collectionName + ": \r\n";
        for (GameElement element : collection) {
            description += element.Name + "\r\n";
        }
        return description;
    }
}
