package _07_Stack_and_Queue._4_Implementation_Problems;

import java.util.HashMap;
import java.util.Map;

public class _29_LRU_cache {

}

class LRUCache {

	class DoubleNode {
		int key, val;
		DoubleNode prev, next;

		public DoubleNode(int key, int value) {
			this.key = key;
			this.val = value;
		}
	}

	Map<Integer, DoubleNode> map = new HashMap<Integer, LRUCache.DoubleNode>();

	int capacity;
	DoubleNode head = new DoubleNode(-1, -1);
	DoubleNode tail = new DoubleNode(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}

	int get(int key) {
		if (map.containsKey(key)) {
			DoubleNode node = map.get(key);
			remove(node);
			insertAfterHead(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DoubleNode node = map.get(key);
			node.val = value;
			remove(node);
			insertAfterHead(node);
		} else {
			if (map.size() == capacity) {
				DoubleNode node = tail.prev;
				map.remove(node.key);
				remove(node);
			}

			DoubleNode node = new DoubleNode(key, value);
			map.put(key, node);
			insertAfterHead(node);
		}
	}

	private void insertAfterHead(DoubleNode node) {
		DoubleNode currAfterHead = head.next;
		head.next = node;
		node.next = currAfterHead;
		node.prev = head;
		currAfterHead.prev = node;
	}

	private void remove(DoubleNode node) {
		DoubleNode prevNode = node.prev;
		DoubleNode afterNode = node.next;
		prevNode.next = afterNode;
		afterNode.prev = prevNode;
	}

}
