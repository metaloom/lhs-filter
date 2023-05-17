//package io.metaloom.filter.operation;
//
//public enum DefaultFilterOperation implements FilterOperation {
//
//	RANGE("range"),
//
//	AFTER("after"),
//
//	BEFORE("before"),
//
//	GREATER("gte"),
//
//	LESSER("lte"),
//
//	EQUAL("eq");
//
//	private String id;
//
//	DefaultFilterOperation(String id) {
//		this.id = id;
//	}
//
//	public String id() {
//		return id;
//	}
//
//	public static FilterOperation fromId(String opStr) {
//		for (FilterOperation op : values()) {
//			if (op.id().equals(opStr)) {
//				return op;
//			}
//		}
//		return null;
//	}
//}
