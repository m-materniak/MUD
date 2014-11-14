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
        return DescribeCollection(collectionName, collection, "");
    }

    public static String DescribeCollection(String collectionName, Collection<? extends GameElement> collection, String emptyText) {
        if (collection.isEmpty())
            return emptyText + "\r\n";
        String description = collectionName + ": \r\n";
        for (GameElement element : collection) {
            description += element.Name + "\r\n";
        }
        return description;
    }
}
