package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.util;

import java.util.Optional;

import org.bson.types.ObjectId;

public class MongoUtil {
	
	private MongoUtil() {

    }

    public static Optional<ObjectId> createObjectId(String id) {
        if (id != null && !id.isEmpty()) {
            return Optional.of(new ObjectId(id));
        } else {
            return Optional.empty();
        }
    }

}
