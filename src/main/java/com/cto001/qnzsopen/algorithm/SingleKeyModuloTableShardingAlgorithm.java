package com.cto001.qnzsopen.algorithm;

/**
 * Created by huzhixin on 2017/6/28.
 */
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

public final class SingleKeyModuloTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {
    @Override
    public String doEqualSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        for (String each : availableTargetNames) {
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Collection<Integer> values = shardingValue.getValues();
        for (Integer value : values) {
            for (String each : availableTargetNames) {
                if (each.endsWith(value % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(final Collection<String> availableTargetNames, final ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
