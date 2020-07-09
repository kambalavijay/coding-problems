package iplproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class MapUtility<K1, K, V> {
	
	public static <K1, K, V> List<Entry<K, V>> getInnerKeyValueAsList(Map<K1, HashMap<K, V>> K1vsKvsV) {
		
		List<Entry<K, V>> KVEntries = new ArrayList<Entry<K, V>>();

		for (Entry<K1, HashMap<K, V>> entryK1KV : K1vsKvsV.entrySet()){
			for (Entry<K, V> entryKV : entryK1KV.getValue().entrySet()){
				KVEntries.add(entryKV);
			}
		}
		return KVEntries;
	}
}