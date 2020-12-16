package org.rockyang.shardingjdbc.cusalgo.algorithm;


import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义分表算法，可以设计自己的实现算法
 * @author l.k
 */
public class TableShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    private static Logger logger = LoggerFactory.getLogger(TableShardingAlgorithm.class);
    // 取模因子
    public static final Integer MODE_FACTOR = 131;

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {

        List<String> shardingResults = new ArrayList<>();
        Long shardingIndex = getIndex(shardingValues) % availableTargetNames.size();
        // loop and match datasource
        for (String name : availableTargetNames) {
            // get logic datasource index suffix
            String nameSuffix = name.substring(name.length() - 1, name.length());
            if (nameSuffix.equals(shardingIndex.toString())) {
                shardingResults.add(name);
                break;
            }
        }
        logger.info("Table sharding index ： {}", shardingIndex);
        return shardingResults;
    }

    /**
     * get table sharding index <p>
     * @param shardingValues
     * @return
     */
    private long getIndex(Collection<ShardingValue> shardingValues)
    {
        Long shardingIndex = 0L;
        ListShardingValue<Long> listShardingValue;
        List<Long> shardingValue;
        for (ShardingValue sVal : shardingValues) {
            listShardingValue = (ListShardingValue<Long>) sVal;
            shardingValue = (List<Long>) listShardingValue.getValues();
            // 这里取模仅仅只是防止溢出
            shardingIndex += (Math.abs(shardingValue.get(0).hashCode()) % MODE_FACTOR);
        }
        return shardingIndex;
    }
}