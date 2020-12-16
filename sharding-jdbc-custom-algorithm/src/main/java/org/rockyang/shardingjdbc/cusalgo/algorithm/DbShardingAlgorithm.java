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
 * 自定义分库算法，这里实现一个最简单的分库算法
 * @author l.k
 */
public class DbShardingAlgorithm implements ComplexKeysShardingAlgorithm {

    private static Logger logger = LoggerFactory.getLogger(DbShardingAlgorithm.class);
    // 取模因子
    public static final Integer MODE_FACTOR = 1331;

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {

        List<String> shardingResults = new ArrayList<>();
        Long shardingIndex = getIndex(shardingValues) % availableTargetNames.size();
        // loop and match datasource
        for (String name : availableTargetNames) {
            // get logic datasource index suffix
            String nameSuffix = name.substring(2);
            if (nameSuffix.equals(shardingIndex.toString())) {
                shardingResults.add(name);
                break;
            }
        }

        logger.info("DataSource sharding index ： {}", shardingIndex);
        return shardingResults;
    }

    /**
     * get datasource sharding index <p>
     * sharding algorithm : shardingIndex = (orderId + userId.hashCode()) % db.size
     * @param shardingValues
     * @return
     */
    private long getIndex(Collection<ShardingValue> shardingValues)
    {
        long shardingIndex = 0L;
        ListShardingValue<Long> listShardingValue;
        List<Long> shardingValue;
        for (ShardingValue sVal : shardingValues) {
            listShardingValue = (ListShardingValue<Long>) sVal;
            if ("order_id".equals(listShardingValue.getColumnName())) {
                shardingValue = (List<Long>) listShardingValue.getValues();
                shardingIndex += Math.abs(shardingValue.get(0)) % MODE_FACTOR;
            } else if ("user_id".equals(listShardingValue.getColumnName())) {
                shardingValue = (List<Long>) listShardingValue.getValues();
                // 这里  % 1313 仅仅只是防止溢出
                shardingIndex += Math.abs(shardingValue.get(0).hashCode()) % MODE_FACTOR;
            }
        }
        return shardingIndex;
    }
}